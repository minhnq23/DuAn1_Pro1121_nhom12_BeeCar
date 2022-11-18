package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Driver;
import com.example.beecar.Model.User;
import com.example.beecar.Model.Vehicles;

import java.util.ArrayList;

public class DriverDAO {

    MyDbHelper myDbHelper;


    public DriverDAO(Context context) {
        myDbHelper = new MyDbHelper(context);
        myDbHelper.getWritableDatabase();
    }

    public ArrayList<Driver> selectAll(){
        ArrayList<Driver> list = new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String sql = "SELECT*FROM tb_driver";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Driver objD = new Driver();
                objD.setId(cursor.getInt(0));
                objD.setUser_name(cursor.getString(1));
                objD.setPassword(cursor.getString(2));
                objD.setFull_name(cursor.getString(3));
                objD.setLuongcb(cursor.getInt(4));
                objD.setStatus_driver(cursor.getInt(5));
                objD.setUser_id(cursor.getInt(6));

                list.add(objD);
                cursor.moveToNext();

            }
        }
        cursor.close();
        return list;
    }

    public boolean insert(Driver objD){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Driver.COL_user_name,objD.getUser_name());
        values.put(Driver.COL_password,objD.getPassword());
        values.put(Driver.COL_full_name,objD.getFull_name());
        values.put(Driver.COL_luongcb,objD.getLuongcb());
        values.put(Driver.COL_status,objD.getStatus_driver());
        values.put(Driver.COL_user_id,objD.getUser_id());
        long row = db.insert(Driver.TB_Name,null,values);
        return row>0;
    }
    public boolean update(Driver objD){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Driver.COL_user_name,objD.getUser_name());
        values.put(Driver.COL_password,objD.getPassword());
        values.put(Driver.COL_full_name,objD.getFull_name());
        values.put(Driver.COL_luongcb,objD.getLuongcb());
        values.put(Driver.COL_status,objD.getStatus_driver());
        values.put(Driver.COL_user_id,objD.getUser_id());
        int row = db.update(Driver.TB_Name,values,"id=?", new String[]{objD.getId()+""});
        return row>0;
    }



}
