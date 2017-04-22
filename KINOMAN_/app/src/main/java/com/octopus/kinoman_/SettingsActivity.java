package com.octopus.kinoman_;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {


    private ImageButton imButtonBack;
    private CheckBox checkBoxMusic;
    private static boolean isChecked = true;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/10425.ttf");

        imButtonBack = (ImageButton)findViewById(R.id.imButtonBack);
        checkBoxMusic = (CheckBox)findViewById(R.id.checkBoxMusic);
        checkBoxMusic.setChecked(isChecked);
        checkBoxMusic.setTypeface(font);
    }

    public void onCLick(View v){
        if (v == imButtonBack) {
            startActivity(new Intent(SettingsActivity.this, MainActivity.class));
        }
        if (!checkBoxMusic.isChecked()){
            MainActivity.stopMusic();
            isChecked = false;

        }
        if (checkBoxMusic.isChecked()){
            MainActivity.startMusic();
            isChecked = true;
        }
    }
}
