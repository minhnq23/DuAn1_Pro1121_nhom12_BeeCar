package com.example.beecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.DAO.DriverDAO;
import com.example.beecar.DAO.UserDAO;
import com.example.beecar.Model.Driver;
import com.example.beecar.Model.User;

import java.util.List;

public class RegisterDriverActivity extends AppCompatActivity {
    Toolbar toolbar ;

    EditText lastName , firtName , userNameDriver , passNameDriver ;
    TextView errorlastName , errorfirtName , erroreruserName , errorPass ;
    Button btnDriver;

    DriverDAO driverDAO;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_driver);
        toolbar = findViewById(R.id.tool_bar_register_driver);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_orange);

        driverDAO = new DriverDAO(getApplicationContext());


        lastName = findViewById(R.id.ed_last_name);
        firtName = findViewById(R.id.ed_first_name);
        userNameDriver = findViewById(R.id.ed_user_name_register_driver);
        passNameDriver = findViewById(R.id.ed_password_register_driver);

        errorlastName = findViewById(R.id.error_last_name);
        errorfirtName = findViewById(R.id.error_first_name);
        erroreruserName = findViewById(R.id.error_user_name);
        errorPass = findViewById(R.id.error_password);

        btnDriver = findViewById(R.id.btn_register_driver);

        btnDriver.setOnClickListener(view ->{
            if(checkSignin()==true){
                RegisterDiver();
                finish();
                }else{
                    Toast.makeText(RegisterDriverActivity.this, "Đăng ký thất bại ( Có thể UserName đã tồn tại)" , Toast.LENGTH_SHORT).show();
                }



        });




    }


        public  void RegisterDiver (){

            String str_userName = userNameDriver.getText().toString().trim();
            String str_passWord = passNameDriver.getText().toString().trim();
            String str_lName = lastName.getText().toString().trim();
            String str_fName = firtName.getText().toString().trim();

            User obj = new User();
            obj.setUser_name(str_userName);
            obj.setFull_name(str_lName+ "" + str_fName);
            obj.setPassword(str_passWord);
            obj.setPosition(2);

            if (userDAO.insert(obj) ){
                List<User>list = userDAO.selectAll();
                for (User u : list) {
                    if ( u.getUser_name().equals(obj.getUser_name())){
                        Driver objD = new Driver();
                        objD.setUser_name(u.getUser_name());
                        objD.setPassword(u.getPassword());
                        objD.setFull_name(u.getFull_name());
                        objD.setStatus_driver(0);
                        objD.setUser_id(u.getId());
                        if(driverDAO.insert(objD)){
                            Toast.makeText(this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
            for (User u : userDAO.selectAll()
                 ) {

                if(str_userName.equalsIgnoreCase(u.getUser_name())){
                    erroreruserName.setText("Tài Khoản Đã tồn tại");
                    return ;
                }


            }



        }


    public boolean checkSignin() {
        if (
                errorlastName.getText().toString().isEmpty() ||
                errorfirtName.getText().toString().isEmpty() ||
                erroreruserName.getText().toString().isEmpty() ||
                errorPass.getText().toString().isEmpty()
        ) {
            if (errorlastName.getText().toString().isEmpty()) {
                errorlastName.setText("Không được để trống trường này");
            } else {
                errorlastName.setText("");
            }
            if (errorfirtName.getText().toString().isEmpty()) {
                errorfirtName.setText("Không được để trống trường này");
            } else {
                errorfirtName.setText("");
            }
            if (erroreruserName.getText().toString().isEmpty()) {
                erroreruserName.setText("Không được để trống trường này");
            } else {
                erroreruserName.setText("");
            }
            if (errorPass.getText().toString().isEmpty()) {
                errorPass.setText("Không được để trống trường này");
            } else if (errorPass.getText().toString().trim().length() < 8) {
                errorPass.setText("Mật khẩu phải ít nhất 8 ký tự");
            } else {
                errorPass.setText("");
            }
            return false;
        } else {
            return true;
        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}