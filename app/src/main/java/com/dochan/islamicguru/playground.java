package com.dochan.islamicguru;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class playground extends AppCompatActivity {

    private TextView mquestion,mwrongs,mcorrects;
    private Button moption1,moption2,moption3,moption4;
    private questionFactory n;

    private int level,questionNo,ans,noCorrect,noWrong,deduction,highscore;
    private ProgressBar progress;

    private Handler handler;
    private Runnable myrunnable;
    private userPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        mwrongs = (TextView)findViewById(R.id.wrongs);
        mcorrects = (TextView)findViewById(R.id.corrects);
        mquestion = (TextView)findViewById(R.id.question);
        moption1 = (Button)findViewById(R.id.option1);
        moption2 = (Button)findViewById(R.id.option2);
        moption3 = (Button)findViewById(R.id.option3);
        moption4 = (Button)findViewById(R.id.option4);

        deduction = 0;
        questionNo = 0;
        noCorrect = 0;
        noWrong = 0;
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setProgress(100);
        progressManager();
        questionLoader();

        userPreference = new userPreference(this);
        highscore = userPreference.getHighscore();

        AlertDialog.Builder alert = new AlertDialog.Builder(this)
                .setTitle("Rules - Must Read!")
                .setMessage("This is a simple game that asks you Islamic questions requiring answers. It takes ten(10) wrong answers for the game to be over. So let's see how far you can get before 10 wrongs.")
                .setPositiveButton("Show next time", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        deduction = 1;
                    }
                })
                .setNegativeButton("Don't show again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        deduction = 1;
                    }
                });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void questionLoader(){
        if(questionNo < questionFactory.questions.length){
            n = questionFactory.questions[questionNo];
            questionNo++;
        }else{
            questionNo = 0;
        }
        if(noWrong >= 5){

            if(noCorrect > highscore){
                userPreference.setHighscore(noCorrect);
            }

            restart();

            AlertDialog.Builder over = new AlertDialog.Builder(this)
                    .setTitle("GAME OVER!!!")
                    .setMessage("play again?")
                    .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            restart();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = over.create();
            alertDialog.show();

        }else{
            mquestion.setText(n.getQuestion()+"");
            moption1.setText(n.getOption1()+"");
            moption2.setText(n.getOption2()+"");
            moption3.setText(n.getOption3()+"");
            moption4.setText(n.getOption4()+"");
            mcorrects.setText(noCorrect+"");
            mwrongs.setText(noWrong+"");

            ans = n.getAnswer();
        }


    }

    public void option_one(View view){
        if(ans == 1){
            noCorrect++;
        }else{
            noWrong++;
        }
        questionLoader();
        restartProgress();
    }

    public void option_two(View view){
        if(ans == 2){
            noCorrect++;
        }else{
            noWrong++;
        }
        questionLoader();
        restartProgress();
    }

    public void option_three(View view){
        if(ans == 3){
            noCorrect++;
        }else{
            noWrong++;
        }
        questionLoader();
        restartProgress();
    }

    public void option_four(View view){
        if(ans == 4){
            noCorrect++;
        }else{
            noWrong++;
        }
        questionLoader();
        restartProgress();
    }

    public void progressManager(){
        handler = new Handler();
        handler.post(myrunnable = new Runnable() {
            @Override
            public void run() {
                int progresslevel = progress.getProgress();
                progress.setProgress(progresslevel - deduction);

                handler.postDelayed(this, 150);
            }
        });
    }

    public void restartProgress(){
        progress.setProgress(100);
    }

    public void restart(){
        noWrong = 0;
        noCorrect = 0;
        deduction = 1;
        mwrongs.setText("0");
        mcorrects.setText("0");
        restartProgress();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.playground_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        closeDialog();
        return super.onOptionsItemSelected(item);
    }

    //PopUp
    @Override
    public void onBackPressed() {
        closeDialog();
    }

    public void closeDialog(){

        deduction = 0;

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Do you want to stop playing")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.removeCallbacks(myrunnable);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deduction = 1;
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}


