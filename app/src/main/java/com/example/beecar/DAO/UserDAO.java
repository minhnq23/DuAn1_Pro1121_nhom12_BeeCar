package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.User;

import java.util.ArrayList;

public class UserDAO {
    private SQLiteDatabase database;
     private MyDbHelper dbHelper;
    public static final String TABLE_NAME = "tb_user";

    public UserDAO(Context context) {
       dbHelper = new MyDbHelper(context);
       database = dbHelper.getWritableDatabase();
    }

    public ArrayList<User> selectAll(){
        ArrayList<User> list_user = new ArrayList<>();
        String select = "SELECT * FROM "+ UserDAO.TABLE_NAME;
        Cursor cursor  = database.rawQuery(select, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                User user = new User();
                user.setIdUser(cursor.getString(0));
                user.setUser_name(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setFull_name(cursor.getString(3));
                user.setPosition(cursor.getString(4));
                list_user.add(user);
                cursor.moveToNext();
            }
            cursor.close();

        }

        return list_user;
    }

    public long insertUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUser",user.getIdUser());
        contentValues.put("user_name",user.getUser_name());
        contentValues.put("password",user.getPassword());
        contentValues.put("full_name",user.getFull_name());
        contentValues.put("position",user.getPosition());
        try {
            long res = database.insert(TABLE_NAME,null,contentValues);
            if(res<0){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }


    public int update(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUser",user.getIdUser());
        contentValues.put("user_name",user.getUser_name());
        contentValues.put("password",user.getPassword());
        contentValues.put("full_name",user.getFull_name());
        contentValues.put("position",user.getPosition());
        try {
            if(database.update(TABLE_NAME, contentValues, "idUser"+"=?", new String[]{"idUser"})==-1){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }


    public int delete(User user){
        try {
            if(database.delete(TABLE_NAME,"idUser"+"=?",new String[]{"idUser"})==-1){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

}
