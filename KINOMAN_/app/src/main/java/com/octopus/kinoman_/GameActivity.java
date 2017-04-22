package com.octopus.kinoman_;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import java.io.*;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Button;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageButton imButtonBack;
    private ImageView imageView;
    private TextView textView;
    private Button buttonAns1;
    private Button buttonAns2;
    private Button buttonAns3;
    private Button buttonAns4;
    private int correctAns;
    private String text = "Кунг-фу Панда";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        imButtonBack = (ImageButton)findViewById(R.id.imButtonBack);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);
        buttonAns1 = (Button)findViewById(R.id.buttonAns1);
        buttonAns2 = (Button)findViewById(R.id.buttonAns2);
        buttonAns3 = (Button)findViewById(R.id.buttonAns3);
        buttonAns4 = (Button)findViewById(R.id.buttonAns4);

        Random rand = new Random();
        correctAns = rand.nextInt(4) + 1;

        loadAns();
        loadImageFromAsset();
        loadText();

    }

    public void loadAns(){
        switch(correctAns){
            case 1: buttonAns1.setText(text); break;
            case 2: buttonAns2.setText(text); break;
            case 3: buttonAns3.setText(text); break;
            case 4: buttonAns4.setText(text); break;
        }
    }
    public void loadImageFromAsset() {
        try {
            InputStream ims = getAssets().open("pics/pandaPo.jpg");
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        }
        catch(IOException ex) {
            return;
        }
    }
    public void loadText(){
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/10425.ttf");
        textView.setText("Из какого мультфильма этот герой?");
        textView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTextSize(25);
        textView.setTypeface(font);
        textView.setLineSpacing(0.0f, 1.2f);

    }
    public void onCLick(View v){
        if (v == imButtonBack) {
            startActivity(new Intent(this, MainActivity.class));
        }
        else if (v == buttonAns1){
            startActivity(new Intent(this, ResultActivity.class));
            if (correctAns == 1)
                ResultActivity.setAns(true);
            else
                ResultActivity.setAns(false);
        }
        else if (v == buttonAns2){
            startActivity(new Intent(this, ResultActivity.class));
            if (correctAns == 2)
                ResultActivity.setAns(true);
            else
                ResultActivity.setAns(false);
        }
        else if (v == buttonAns3){
            startActivity(new Intent(this, ResultActivity.class));
            if (correctAns == 3)
                ResultActivity.setAns(true);
            else
                ResultActivity.setAns(false);
        }
        else if (v == buttonAns4){
            startActivity(new Intent(this, ResultActivity.class));
            if (correctAns == 4)
                ResultActivity.setAns(true);
            else
                ResultActivity.setAns(false);
        }
        this.finish();
    }

}
