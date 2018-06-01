package com.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 描述   ：本地存储XML文件
 * <p>
 * 作者   ：Created by DR on 2018/6/1.
 */

public class SharedPreferencesUtil {

    //存储的sharedpreferences文件名
    private static final String FILE_NAME = "south_worker";

    public static void saveData(Context context, String key, Object data){

        String type = data.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)){
            editor.putInt(key, (Integer)data);
        }else if ("Boolean".equals(type)){
            editor.putBoolean(key, (Boolean)data);
        }else if ("String".equals(type)){
            editor.putString(key, (String)data);
        }else if ("Float".equals(type)){
            editor.putFloat(key, (Float)data);
        }else if ("Long".equals(type)){
            editor.putLong(key, (Long)data);
        }
        editor.apply();
    }

    public static void clearData(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key).apply();
    }

    public static Object getData(Context context, String key, Object defValue){
        String type = defValue.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        //defValue为为默认值，如果当前获取不到数据就返回它
        if ("Integer".equals(type)){
            return sharedPreferences.getInt(key, (Integer)defValue);
        }else if ("Boolean".equals(type)){
            return sharedPreferences.getBoolean(key, (Boolean)defValue);
        }else if ("String".equals(type)){
            return sharedPreferences.getString(key, (String)defValue);
        }else if ("Float".equals(type)){
            return sharedPreferences.getFloat(key, (Float)defValue);
        }else if ("Long".equals(type)){
            return sharedPreferences.getLong(key, (Long)defValue);
        }
        return null;
    }

    public static long getLong(Context context, String key, long defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key,defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }
}
