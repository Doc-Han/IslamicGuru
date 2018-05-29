package com.dochan.islamicguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class rules extends AppCompatActivity {

    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        mCheckBox = (CheckBox)findViewById(R.id.checkBox);

    }

    public void toPlayground(View view){
        if(mCheckBox.isChecked()){
            userPreference userPreference = new userPreference(this);
            userPreference.showRules(false);
        }else{
            userPreference userPreference = new userPreference(this);
            userPreference.showRules(true);
        }

        Intent intent = new Intent(this, playground.class);
        startActivity(intent);
    }

}
