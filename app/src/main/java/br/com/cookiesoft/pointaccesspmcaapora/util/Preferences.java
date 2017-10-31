package br.com.cookiesoft.pointaccesspmcaapora.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Cookiesoft on 14/10/2017.
 */

public class Preferences {

    public static final String PREF_ID = "pratica_recyclerview";

    public static void setBoolean(Context context, String chave, boolean on){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(chave, on);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String chave){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        boolean b = preferences.getBoolean(chave, true);
        return b;
    }

    public static void setInteger(Context context, String chave, int valor){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(chave,valor);
        editor.commit();
    }

    public static int getInteger(Context context, String chave){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        int i = preferences.getInt(chave,0);
        return i;
    }

    public static void setString(Context context, String chave, String valor){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(chave,valor);
        editor.commit();
    }

    public static String getString(Context context, String chave){
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        String s = preferences.getString(chave,"");
        return s;
    }
}
