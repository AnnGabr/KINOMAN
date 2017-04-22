package com.octopus.kinoman_;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton imButtonBack;
    private TextView textView;
    private static boolean ans = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imButtonBack = (ImageButton)findViewById(R.id.imButtonBack);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);
        loadImage();
        loadText();
        ans = true;
    }
    public static void setAns(boolean a){
        ans = a;
    }
    public void loadImage() {
        String route;
        if (ans)
            route = "pics/success.jpg";
        else
            route = "pics/fail.jpg";
        try {
            InputStream ims = getAssets().open(route);
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
        textView.setTypeface(font);
        if (ans){
            textView.setText("Well Done, Bro!");
        }
        else{
            textView.setText("Sorry not Sorry");
        }

    }
    public void onCLick(View v){
        if (v == imButtonBack) {
            startActivity(new Intent(this, MainActivity.class));
        }
        this.finish();
    }
}
