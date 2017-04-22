package com.octopus.kinoman_;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Button;

public class FilmCategoryActivity extends AppCompatActivity {

    private ImageButton imButtonBack;
    private Button buttonFilms;
    private Button buttonCartoons;
    private Button buttonSeries;
    private static int buttonSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_category);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/10425.ttf");

        imButtonBack = (ImageButton)findViewById(R.id.imButtonBack);
        buttonFilms = (Button)findViewById(R.id.buttonFilms);
        buttonCartoons = (Button)findViewById(R.id.buttonCartoons);
        buttonSeries = (Button)findViewById(R.id.buttonSeries);

        buttonFilms.setTypeface(font);
        buttonCartoons.setTypeface(font);
        buttonSeries.setTypeface(font);
    }


    public static int getButtonSelected(){
        return buttonSelected;
    }

    public void onClick(View v){
        if (v == imButtonBack){
            startActivity(new Intent(FilmCategoryActivity.this, MainActivity.class));
        }
        else if (v == buttonCartoons){
            buttonSelected = 1;
            startActivity(new Intent(FilmCategoryActivity.this, GameActivity.class));
        }
        else if (v == buttonFilms){
            buttonSelected = 2;
            startActivity(new Intent(FilmCategoryActivity.this, ResultActivity.class));
        }
        else if (v == buttonSeries){
            buttonSelected = 3;
            startActivity(new Intent(FilmCategoryActivity.this, ResultActivity.class));
        }
        this.finish();
    }
}
