package com.example.android.a80ssongsandartistsquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void play_physical(View view) {
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.physical);
        mp.start();
    }
}
