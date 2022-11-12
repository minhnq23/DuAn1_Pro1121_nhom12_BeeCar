package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tvSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
           imageView = findViewById(R.id.imageView);
           tvSplash = findViewById(R.id.tvSplash);
           Typeface font = Typeface.createFromAsset(getAssets(),"fonts/FredokaOne-Regular.ttf");
           tvSplash.setTypeface(font);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               finish();
            }
        },3000);


    }
}