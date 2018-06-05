package com.dochan.islamicguru;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MediaPlayer ring = MediaPlayer.create(this,R.raw.bismillah);
        ring.start();

        if(getIntent().getBooleanExtra("exit", false)){
            //here is the code to exit the app
        }

        @SuppressLint("HandlerLeak") final Handler handler = new Handler(){
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
