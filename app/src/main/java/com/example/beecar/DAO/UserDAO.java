package com.example.beecar.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.User;

import java.util.ArrayList;

public class UserDAO {
    MyDbHelper dbHelper;

    public UserDAO(Context context) {
       dbHelper = new MyDbHelper(context);
    }

    public ArrayList<User> selectAll(){
        return null;
    }
    public void insert(User objUser){

    }
    public void update(User objUser){

    }
    public void delete(User objUser){

    }

}
