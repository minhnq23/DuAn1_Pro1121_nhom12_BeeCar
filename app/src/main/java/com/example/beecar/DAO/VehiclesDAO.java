package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Vehicles;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
                objV.setImage(cursor.getBlob(1));
                objV.setName_car(cursor.getString(2));
                objV.setBien_ks(cursor.getString(3));
                objV.setCount_muon(cursor.getInt(4));
                objV.setPrice_time(cursor.getInt(5));
                objV.setPrice_date(cursor.getInt(6));
                objV.setDay_bd(cursor.getString(7));
                objV.setDay_dk(cursor.getString(8));
                objV.setVehicles_status(cursor.getInt(9));
                objV.setId_category(cursor.getInt(10));

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
        values.put(Vehicles.COL_bien_ks,objV.getBien_ks());
        values.put(Vehicles.COL_day_dk, objV.getDay_dk());
        values.put(Vehicles.COL_count_muon,objV.getCount_muon());
        values.put(Vehicles.COL_price_time,objV.getPrice_time());
        values.put(Vehicles.COL_price_date,objV.getPrice_date());
        values.put(Vehicles.COL_day_bd,objV.getDay_bd());
        values.put(Vehicles.COL_id_category,objV.getId_category());
        long row = db.insert(Vehicles.TB_name,null,values);
        return row>0;



    }
    public ArrayList<Vehicles> selectCarStatus0(){
        ArrayList<Vehicles> list = new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String sql = "SELECT *FROM tb_vehicles";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            while (!cursor.isAfterLast()){
                Vehicles objV = new Vehicles();
                objV.setId(cursor.getInt(0));
                objV.setImage(cursor.getBlob(1));
                objV.setName_car(cursor.getString(2));
                objV.setBien_ks(cursor.getString(3));
                objV.setCount_muon(cursor.getInt(4));
                objV.setPrice_time(cursor.getInt(5));
                objV.setPrice_date(cursor.getInt(6));
                objV.setDay_bd(cursor.getString(7));
                objV.setDay_dk(cursor.getString(8));
                objV.setVehicles_status(cursor.getInt(9));
                objV.setId_category(cursor.getInt(10));

                list.add(objV);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    public ArrayList<Vehicles> selectCarStatus1(String start_time,String end_time ){
        ArrayList<Vehicles> list = new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String sql = "SELECT*FROM tb_vehicles  INNER JOIN tb_receipt where (vehicles_status=1  and strftime("+start_time+", date)< tbvehicles.start_time and strftime("+end_time+", date) < tbvehicles.start_time) or" +
                "(vehicles_status=1  and strftime("+start_time+", date)>tbvehicles.end_time)";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            while (!cursor.isAfterLast()){
                Vehicles objV = new Vehicles();
                objV.setId(cursor.getInt(0));
                objV.setImage(cursor.getBlob(1));
                objV.setName_car(cursor.getString(2));
                objV.setBien_ks(cursor.getString(3));
                objV.setCount_muon(cursor.getInt(4));
                objV.setPrice_time(cursor.getInt(5));
                objV.setPrice_date(cursor.getInt(6));
                objV.setDay_bd(cursor.getString(7));
                objV.setDay_dk(cursor.getString(8));
                objV.setVehicles_status(cursor.getInt(9));
                objV.setId_category(cursor.getInt(10));
                list.add(objV);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }
    public boolean update(Vehicles objV){
        SQLiteDatabase db= myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Vehicles.COL_image_car,objV.getImage());
        values.put(Vehicles.COL_name_car,objV.getName_car());
        values.put(Vehicles.COL_bien_ks,objV.getBien_ks());
        values.put(Vehicles.COL_day_dk, objV.getDay_dk());
        values.put(Vehicles.COL_count_muon,objV.getCount_muon());
        values.put(Vehicles.COL_price_time,objV.getPrice_time());
        values.put(Vehicles.COL_price_date,objV.getPrice_date());
        values.put(Vehicles.COL_day_bd,objV.getDay_bd());
        values.put(Vehicles.COL_vehicles_status,objV.getVehicles_status());
        values.put(Vehicles.COL_id_category,objV.getId_category());
        int row = db.update(Vehicles.TB_name,values,"id=?",new String[]{objV.getId()+""});
        return row>0;

    }





    public boolean delete(int objV){
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        int row = db.delete(Vehicles.TB_name,"id=?",new String[]{objV+""});
        return row>0;
    }


    public  String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

}
