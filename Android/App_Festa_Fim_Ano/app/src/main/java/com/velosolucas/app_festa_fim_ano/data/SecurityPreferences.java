package com.velosolucas.app_festa_fim_ano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context mContext){
        this.mSharedPreferences = mContext.getSharedPreferences("festaFimAno", Context.MODE_PRIVATE);
    }

    public void storeSting(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key){
        return this.mSharedPreferences.getString(key, "");
    }
}
