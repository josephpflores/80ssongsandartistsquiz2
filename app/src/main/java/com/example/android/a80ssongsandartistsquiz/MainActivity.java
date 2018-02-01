package com.example.android.a80ssongsandartistsquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer song1;
    MediaPlayer song2;
    MediaPlayer song3;
    MediaPlayer song4;
    MediaPlayer song5;
    EditText answer1;
    EditText answer2;
    CheckBox answer3a;
    CheckBox answer3b;
    CheckBox answer3c;
    EditText answer4;
    RadioGroup answer5;
    int paused;
    int score = 0;
    int wrong_answers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3a = findViewById(R.id.a3);
        answer3b = findViewById(R.id.b3);
        answer3c = findViewById(R.id.c3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);

    }

    public void play_song1(View view) {

        if(song1==null) {
            song1 = MediaPlayer.create(MainActivity.this, R.raw.physical);
            song1.start();
        }else if(!song1.isPlaying()){
            song1.seekTo(paused);
            song1.start();
        }
    }

    public void pause_song1(View view) {

        song1.pause();
        paused = song1.getCurrentPosition();
        }

    public void stop_song1(View view) {

        song1.release();
        song1=null;
        }

    public void play_song2(View view) {

        if(song2==null) {
            song2 = MediaPlayer.create(MainActivity.this, R.raw.eyeofthetiger);
            song2.start();
        }else if(!song2.isPlaying()){
            song2.seekTo(paused);
            song2.start();
        }
    }

    public void pause_song2(View view) {

        song2.pause();
        paused = song2.getCurrentPosition();
    }

    public void stop_song2(View view) {

        song2.release();
        song2=null;
    }
    public void play_song3(View view) {

        if(song3==null) {
            song3 = MediaPlayer.create(MainActivity.this, R.raw.ebonyandivory);
            song3.start();
        }else if(!song3.isPlaying()){
            song3.seekTo(paused);
            song3.start();
        }
    }

    public void pause_song3(View view) {

        song3.pause();
        paused = song3.getCurrentPosition();
    }

    public void stop_song3(View view) {

        song3.release();
        song3=null;
    }
    public void play_song4(View view) {

        if(song4==null) {
            song4 = MediaPlayer.create(MainActivity.this, R.raw.centerfold);
            song4.start();
        }else if(!song4.isPlaying()){
            song4.seekTo(paused);
            song4.start();
        }
    }

    public void pause_song4(View view) {

        song4.pause();
        paused = song4.getCurrentPosition();
    }

    public void stop_song4(View view) {

        song4.release();
        song4=null;
    }
    public void play_song5(View view) {

        if(song5==null) {
            song5 = MediaPlayer.create(MainActivity.this, R.raw.anotheronebitesthedust);
            song5.start();
        }else if(!song5.isPlaying()){
            song5.seekTo(paused);
            song5.start();
        }
    }

    public void pause_song5(View view) {

        song5.pause();
        paused = song5.getCurrentPosition();
    }

    public void stop_song5(View view) {

        song5.release();
        song5=null;
    }

    public void submitAnswers(View view) {

        String question5 = getRadioGroupAnswer(answer5.getCheckedRadioButtonId());

        String answerQuestion1 = answer1.getText().toString();
        if (answerQuestion1.toLowerCase().equals("olivia newton john")) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        String answerQuestion5 = answer2.getText().toString();
        if (answerQuestion5.toLowerCase().equals("survivor")) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        if (answer3a.isChecked() && !answer3b.isChecked() && answer3c.isChecked()) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        String answerQuestion4 = answer4.getText().toString();
        if (answerQuestion4.toLowerCase().equals("the j. gelis band")) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        if (question5.equals(getString(R.string.b5))) {
            score += 1;
        } else {
            wrong_answers += 1;
        }

        showToast();
    }


        private String getRadioGroupAnswer(int id) {

            if (id != -1) {
                RadioButton getSelectedRadioButton = findViewById(id);
                String answer = getSelectedRadioButton.getText().toString();
                return answer;
            } else {
                return "";
            }

        }
    /**
     * The Quiz toast messsage
     */
    private void showToast() {
        String toastMessage = getString(R.string.end_message, String.valueOf(score), String.valueOf(wrong_answers));
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

        resetScore();


    }

    /**
     * Method to reset Score and answers
     */
    private void resetScore() {
        score = 0;
        wrong_answers = 0;
        answer1.getText().clear();
        answer2.getText().clear();
        CheckBox checkBox1 = findViewById(R.id.a3);
        checkBox1.setChecked(false);
        CheckBox checkBox2 = findViewById(R.id.b3);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = findViewById(R.id.c3);
        checkBox3.setChecked(false);
        answer4.getText().clear();
        RadioGroup  group  = findViewById(R.id.answer5);
        group.clearCheck();
    }

    }
