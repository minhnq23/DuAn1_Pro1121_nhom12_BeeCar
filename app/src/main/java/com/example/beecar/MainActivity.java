package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.Database.MyDbHelper;

public class MainActivity extends AppCompatActivity {
//    MyDbHelper myDbHelper;
    TextView tvRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myDbHelper = new MyDbHelper(this);
//        myDbHelper.getReadableDatabase();
        Intent intent = new Intent(this,SplashActivity.class);
        startActivity(intent);
        tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()== MotionEvent.ACTION_DOWN){
                    tvRegister.setTextColor(Color.BLUE);
                }
                if (motionEvent.getAction()== MotionEvent.ACTION_UP){
                    tvRegister.setTextColor(Color.WHITE);
                }
                return false;
            }
        });



        tvRegister.setOnClickListener(view -> {
            Intent i = new Intent(this,PositionActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        });



    }
    int count = 0;
    @Override
    public void onBackPressed() {
        count++;
        Toast.makeText(this, "ấn 2 lần để thoát", Toast.LENGTH_SHORT).show();
            if (count == 2) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }

        }
    }
