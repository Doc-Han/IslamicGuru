package com.dochan.islamicguru;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class userPreference {
    private SharedPreferences mSharedPreferences;

    userPreference(Context context){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public int getHighscore(){
        return mSharedPreferences.getInt("highscore", 0);
    }

    public void setHighscore(int highscore){
        mSharedPreferences
                .edit()
                .putInt("highscore" ,highscore)
                .apply();
    }

    public void showRules(boolean bool){
        mSharedPreferences
                .edit()
                .putBoolean("rules", bool)
                .apply();
    }

    public boolean showRules(){
        return mSharedPreferences.getBoolean("rules", true);
    }
}
