package com.dochan.islamicguru;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class userPreference {
    SharedPreferences mSharedPreferences;

    public userPreference(Context context){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public int getHighscore(){
        return mSharedPreferences.getInt("highscore", 0);
    }

    public void setHighscore(int highscore){
        mSharedPreferences
                .edit()
                .putInt("highscore" ,highscore)
                .commit();
    }
}
