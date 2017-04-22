package com.octopus.kinoman_;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.graphics.Typeface;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonSettings;
    private Button buttonQuit;
    private static MediaPlayer mySound;

    protected void onDestroy() {
        super.onDestroy();
        mySound.stop();
    }


    public static void startMusic(){
        mySound.start();
        mySound.setVolume(100, 100);
        mySound.setLooping(true);
    }

    public static void stopMusic(){
        mySound.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.happy);

        startMusic();

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/10425.ttf");

        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setTypeface(font);
        buttonStart.setText("Старт");
        buttonSettings = (Button)findViewById(R.id.buttonSettings);
        buttonSettings.setTypeface(font);
        buttonQuit = (Button)findViewById(R.id.buttonQuit);
        buttonQuit.setTypeface(font);

    }
    public void onCLick(View v){
        if (v == buttonStart){
            startActivity(new Intent(this, SelectModeActivity.class));
        }
        else if (v == buttonSettings){
            startActivity(new Intent(this, SettingsActivity.class));
        }
        else if (v == buttonQuit){
            this.finish();
        }

    }
    


}
