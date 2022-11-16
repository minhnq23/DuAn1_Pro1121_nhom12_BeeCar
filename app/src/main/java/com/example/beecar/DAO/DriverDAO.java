package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Client;
import com.example.beecar.Model.Driver;
import com.example.beecar.Model.User;

import java.util.ArrayList;

public class DriverDAO {
    private SQLiteDatabase database;
    private MyDbHelper dbHelper;
    public static final String TABLE_NAME = "tb_driver";

    public DriverDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public ArrayList<Driver> selectAll(){
        ArrayList<Driver> list_driver = new ArrayList<>();
        String select = "SELECT * FROM "+ DriverDAO.TABLE_NAME;
        Cursor cursor  = database.rawQuery(select, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Driver driver = new Driver();
                driver.setIdDriver(cursor.getString(0));
                driver.setUser_name(cursor.getString(1));
                driver.setPassword(cursor.getString(2));
                driver.setFull_name(cursor.getString(3));
                driver.setStatus_driver(cursor.getString(4));
             //   User.setPosition(cursor.getString(4));
                list_driver.add(driver);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list_driver;
    }

    public long insertDriver(Driver driver){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idDriver",driver.getIdUser());
        contentValues.put("user_name",driver.getUser_name());
        contentValues.put("password",driver.getPassword());
        contentValues.put("full_name",driver.getFull_name());
        contentValues.put("status_driver",driver.getStatus_driver());
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

    public int update(Driver driver){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idDriver",driver.getIdUser());
        contentValues.put("user_name",driver.getUser_name());
        contentValues.put("password",driver.getPassword());
        contentValues.put("full_name",driver.getFull_name());
        contentValues.put("status_driver",driver.getStatus_driver());
        try {
            if(database.update(TABLE_NAME, contentValues, "idDriver"+"=?", new String[]{"idDriver"})==-1){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

}
