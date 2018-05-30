package com.dochan.islamicguru;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
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

import java.util.Random;

public class playground extends AppCompatActivity {

    private TextView mquestion,mwrongs,mcorrects;
    private Button moption1,moption2,moption3,moption4;
    private questionFactory n;
    private ConstraintLayout mLayout;

    private int level,questionNo,ans,noCorrect,noWrong,deduction,highscore;
    private ProgressBar progress;

    private Handler handler;
    private Runnable myrunnable;
    private userPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);


        mLayout = (ConstraintLayout)findViewById(R.id.playground);
        mwrongs = (TextView)findViewById(R.id.wrongs);
        mcorrects = (TextView)findViewById(R.id.corrects);
        mquestion = (TextView)findViewById(R.id.question);
        moption1 = (Button)findViewById(R.id.option1);
        moption2 = (Button)findViewById(R.id.option2);
        moption3 = (Button)findViewById(R.id.option3);
        moption4 = (Button)findViewById(R.id.option4);

        deduction = 1;
        questionNo = 0;
        noCorrect = 0;
        noWrong = 0;
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setProgress(100);
        progressManager();
        questionLoader();

        userPreference = new userPreference(this);
        highscore = userPreference.getHighscore();

    }

    public void questionLoader(){
        //changing color
        Random r = new Random();
        int rnd = r.nextInt(colorStore.colors.length);
        colorStore color = colorStore.colors[rnd];
        String deep = color.getDeepColor();
        String light = color.getLightColor();
        mLayout.setBackgroundColor(Color.parseColor(light));
        moption1.setBackgroundColor(Color.parseColor(deep));
        moption2.setBackgroundColor(Color.parseColor(deep));
        moption3.setBackgroundColor(Color.parseColor(deep));
        moption4.setBackgroundColor(Color.parseColor(deep));

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

           gameOverDialog();

        }else{
            String question = n.getQuestion()+"";
            String op1 = n.getOption1()+"";
            String op2 =  n.getOption2()+"";
            String op3 = n.getOption3()+"";
            String op4 = n.getOption4()+"";
            String correct = noCorrect+"";
            String wrong = noWrong+"";
            mquestion.setText(question);
            moption1.setText(op1);
            moption2.setText(op2);
            moption3.setText(op3);
            moption4.setText(op4);
            mcorrects.setText(correct);
            mwrongs.setText(wrong);

            ans = n.getAnswer();
        }


    }

    public void gameOverDialog(){
        deduction = 0;
        AlertDialog.Builder over = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.game_over))
                .setMessage(getString(R.string.game_overMsg))
                .setPositiveButton(getString(R.string.game_overPos), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restart();
                    }
                })
                .setNegativeButton(getString(R.string.game_overNeg), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false);
        AlertDialog alertDialog = over.create();
        alertDialog.show();
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
                if(progresslevel <= 1){
                    restart();
                    gameOverDialog();
                }else{
                    progress.setProgress(progresslevel - deduction);
                }


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
                .setMessage(getString(R.string.stoping_msg))
                .setPositiveButton(getString(R.string.stoping_msgPo), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.removeCallbacks(myrunnable);
                        finish();
                    }
                })
                .setNegativeButton(getString(R.string.stoping_msgNeg), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deduction = 1;
                        dialog.dismiss();
                    }
                })
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}


