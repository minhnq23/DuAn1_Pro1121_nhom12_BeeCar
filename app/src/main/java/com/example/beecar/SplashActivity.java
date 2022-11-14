package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        Animation animationImg = AnimationUtils.loadAnimation(this,R.anim.anim_logo_splash_screen);
        imageView.startAnimation(animationImg);
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvSplash,"translationY",-100f,0f);
        animator.setDuration(2000);
        animator.setRepeatCount(0);
        animator.start();
        Animation animationTitle = AnimationUtils.loadAnimation(this,R.anim.anim_title_splash_screen);
            tvSplash.startAnimation(animationTitle);
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