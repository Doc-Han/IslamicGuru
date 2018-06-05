package com.dochan.islamicguru;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class settings extends AppCompatActivity {

    private Switch mButton;
    private userPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mButton = (Switch)findViewById(R.id.toggle);

        userPreference = new userPreference(this);
        if(userPreference.isShowRules()){
            mButton.setChecked(true);
        }else{
            mButton.setChecked(false);
        }

    }

    public void aboutDialog(View view){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.about))
                .setMessage(getString(R.string.about_msg))
                .setPositiveButton(getString(R.string.about_Po), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = alertDialog.create();
        dialog.show();

    }

    public void toggleRules(View view){
        if(mButton.isChecked()){
            userPreference.showRules(true);
        }else{
            userPreference.showRules(false);
        }
    }

}
