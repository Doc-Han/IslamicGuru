package com.dochan.islamicguru;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(getIntent().getBooleanExtra("exit", false)){
            //here is the code to exit the app
        }

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
            }
        };

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread intentThread = new Thread(r);
        intentThread.start();

    }
}
