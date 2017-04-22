package com.octopus.kinoman_;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.util.Log;

public class SelectModeActivity extends AppCompatActivity {


    final String TAG = "States";
    private ImageButton imButtonBack;
    private Button buttonHeroMode;
    private Button buttonFilmMode;
    private static boolean isHeroMode;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/10425.ttf");

        buttonHeroMode = (Button)findViewById(R.id.buttonHeroMode);
        buttonFilmMode = (Button)findViewById(R.id.buttonFilmMode);
        imButtonBack = (ImageButton)findViewById(R.id.imButtonBack);

        buttonFilmMode.setTypeface(font);
        buttonHeroMode.setTypeface(font);
    }

    public static boolean getMode(){
        return isHeroMode;
    }

    public void onClick(View v){
        if (v == buttonFilmMode){
            isHeroMode = false;

            startActivity(new Intent(this, FilmCategoryActivity.class));
        }
        else if (v == buttonHeroMode){
            isHeroMode = true;
            startActivity(new Intent(this, ResultActivity.class));
        }
        else if (v == imButtonBack){
            startActivity(new Intent(this, MainActivity.class));
        }
        this.finish();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityTwo: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityTwo: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityTwo: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityTwo: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityTwo: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivityTwo: onDestroy()");
    }
}
