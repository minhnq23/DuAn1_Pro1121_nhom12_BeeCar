package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Vehicles;

import java.util.ArrayList;

public class VehiclesDAO {
    MyDbHelper myDbHelper;

    public VehiclesDAO(Context context) {
        myDbHelper = new MyDbHelper(context);
        myDbHelper.getReadableDatabase();
    }
    public ArrayList<Vehicles> selectAll(){
        ArrayList<Vehicles> list = new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String sql = "SELECT *FROM tb_vehicles";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            while (!cursor.isAfterLast()){
                Vehicles objV = new Vehicles();
                objV.setId(cursor.getInt(0));
                objV.setImage(cursor.getInt(1));
                objV.setName_car(cursor.getString(2));
                objV.setPrice_time(cursor.getInt(3));
                objV.setPrice_date(cursor.getInt(4));
                objV.setCount_muon(cursor.getInt(5));
                objV.setDay_bd(cursor.getString(6));
                objV.setId_category(cursor.getInt(7));
                list.add(objV);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    public boolean insert(Vehicles objV){
        SQLiteDatabase db= myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Vehicles.COL_image_car,objV.getImage());
        values.put(Vehicles.COL_name_car,objV.getName_car());
        values.put(Vehicles.COL_count_muon,objV.getCount_muon());
        values.put(Vehicles.COL_price_time,objV.getPrice_time());
        values.put(Vehicles.COL_price_date,objV.getPrice_date());
        values.put(Vehicles.COL_day_bd,objV.getDay_bd());
        values.put(Vehicles.COL_id_category,objV.getId_category());
        long row = db.insert(Vehicles.TB_name,null,values);
        return row>0;



    }
    public boolean update(Vehicles objV){
        SQLiteDatabase db= myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Vehicles.COL_image_car,objV.getImage());
        values.put(Vehicles.COL_name_car,objV.getName_car());
        values.put(Vehicles.COL_count_muon,objV.getCount_muon());
        values.put(Vehicles.COL_price_time,objV.getPrice_time());
        values.put(Vehicles.COL_price_date,objV.getPrice_date());
        values.put(Vehicles.COL_day_bd,objV.getDay_bd());
        values.put(Vehicles.COL_id_category,objV.getId_category());
        int row = db.update(Vehicles.TB_name,values,"id=?",new String[]{objV.getId()+""});
        return row>0;

    }

    public boolean delete(int objV){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        int row = db.delete(Vehicles.TB_name,"id=?",new String[]{objV+""});
        return row>0;
    }
}
