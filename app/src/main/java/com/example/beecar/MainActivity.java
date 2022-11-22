package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.DAO.UserDAO;
import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.User;

public class MainActivity extends AppCompatActivity {
//    MyDbHelper myDbHelper;
    UserDAO userDAO;

    TextView tvRegister;
    EditText ed_userName;
    EditText ed_password;
    Button btnLogin;
    LoadingDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myDbHelper = new MyDbHelper(this);
//        myDbHelper.getReadableDatabase();

        tvRegister = findViewById(R.id.tv_register);
        dialog  = new LoadingDialog(MainActivity.this);
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
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(view -> {
            loginApp();
        });



        tvRegister.setOnClickListener(view -> {
            Intent i = new Intent(this,PositionActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        });



    }



    private void loginApp() {
        userDAO = new UserDAO(this);
        ed_userName = findViewById(R.id.ed_user_name_lg);
        ed_password = findViewById(R.id.ed_password_lg);
        String str_UserName = ed_userName.getText().toString().trim();
        String str_Password = ed_password.getText().toString().trim();




        for (User obj: userDAO.selectAll()){
            if (obj.getUser_name().equalsIgnoreCase(str_UserName)&& obj.getPassword().equalsIgnoreCase(str_Password)) {
                if (obj.getPosition() == 1) {
                    Intent ic = new Intent(this, HomeClient.class);
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ic.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(ic);
                            dialog.dismiss();
                        }
                    },3000);


                    return;
                }
                if (obj.getPosition() == 2) {
                    Intent id = new Intent(this, NavigationDrawerForDriver.class);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            id.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(id);
                            dialog.dismiss();
                        }
                    },3000);

                    return;
                }
            }
        }


    }




    int count = 0;
    @Override
    public void onBackPressed() {
        count++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                count = 0;
            }
        },3000);
        Toast.makeText(this, "ấn 2 lần để thoát", Toast.LENGTH_SHORT).show();
            if (count == 2) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }

        }
    }
