package com.example.android.a80ssongsandartistsquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer physical;
    int paused;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play_physical(View view) {

        if(physical==null) {
            physical = MediaPlayer.create(MainActivity.this, R.raw.physical);
            physical.start();
        }else if(!physical.isPlaying()){
            physical.seekTo(paused);
            physical.start();
        }
    }

    public void pause_physical(View view) {

        physical.pause();
        paused = physical.getCurrentPosition();
        }

    public void stop_physical(View view) {

        physical.release();
        physical=null;
        }
    }
