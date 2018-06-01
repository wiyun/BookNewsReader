package com.south.worker.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.baselib.utils.SharedPreferencesUtil;
import com.south.worker.R;
import com.south.worker.constant.SharedPreferencesConfig;
import com.south.worker.ui.BaseActivity;
import com.south.worker.ui.login.LoginActivity;
import com.south.worker.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Observable.timer(2, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        String userId = SharedPreferencesUtil.getString(getBaseContext(), SharedPreferencesConfig.SHARED_KEY_USER_ID,"");

                        if(TextUtils.isEmpty(userId)){
                            goLogin();
                        }else{
                            goMain();
                        }

                    }
                })
                .subscribe();

        goLogin();


    }



    private void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void goMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}