package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.beecar.Database.MyDbHelper;

public class MainActivity extends AppCompatActivity {
//    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myDbHelper = new MyDbHelper(this);
//        myDbHelper.getReadableDatabase();
        Intent intent = new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
}