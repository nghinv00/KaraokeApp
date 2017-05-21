package com.karaapp.karaokeapp.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nganq on 4/18/2017.
 */


public class ZShPre {
    private SharedPreferences sharedPreferences;

    private static ZShPre instance = null;

    public static ZShPre gIns(Context context) {
        if (instance == null) {
            instance = new ZShPre(context);
        }
        return instance;
    }

    private ZShPre(Context context) {
        sharedPreferences = context.getSharedPreferences(Config.SHARED_PREFERENCE_NAME, Context
                .MODE_PRIVATE);
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public String getProfileUser() {
        return sharedPreferences.getString(Config.PROFILE_USER, "");
    }

    public void setTokenUser(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Config.PROFILE_USER, token);
        editor.commit();
    }


}
