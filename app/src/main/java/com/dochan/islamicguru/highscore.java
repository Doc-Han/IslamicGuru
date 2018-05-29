package com.dochan.islamicguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class highscore extends AppCompatActivity {

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        score = (TextView)findViewById(R.id.score);

        userPreference userPreference = new userPreference(this);
        int highscore = userPreference.getHighscore();
        score.setText(highscore+"");
    }
}
