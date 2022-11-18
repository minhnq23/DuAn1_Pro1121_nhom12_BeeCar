package com.example.beecar.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    public static final String Name_db = "beeCar.db";
    public static final int Version_db =2 ;


    public MyDbHelper(@Nullable Context context) {
        super(context, Name_db, null, Version_db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //car
        String tb_category = "create table if not exists tb_category (id integer primary key autoincrement,name_category string)";
        sqLiteDatabase.execSQL(tb_category);
        String tb_vehicles = "create table if not exists tb_vehicles (id integer primary key autoincrement,image_car int,name_car string,price_time int ,price_date int,count_muon int , id_category references tb_category(id)) ";
        sqLiteDatabase.execSQL(tb_vehicles);

        // user
        String tb_user = "create table if not exists  tb_user (id integer primary key autoincrement, user_name string,password string,full_name string,int position)";
        sqLiteDatabase.execSQL(tb_user);
        String tb_driver = "create table if not exists  tb_driver (id integer primary key autoincrement, user_name string,password string,full_name string,luong int,status_driver int , user_id references tb_user(id))";
        sqLiteDatabase.execSQL(tb_driver);
        String tb_client = "create table if not exists  tb_client (id integer primary key autoincrement, user_name string,password string,full_name string, user_id references tb_user(id))";
        sqLiteDatabase.execSQL(tb_client);
            //
        String tb_schedule = "create table if not exists  tb_schedule (id integer primary key autoincrement, start_time date, end_time date," +
                "driver_id references tb_driver(id)," +
                "receipt_id references tb_receipt(id))";
        sqLiteDatabase.execSQL(tb_schedule);

        // receipt
        String tb_receipt = "create table if not exists tb_receipt (id integer primary key autoincrement ,oder_time date, start_time date,end_time date, status int, total int , " +
                "client_id references tb_client(id)," +
                "driver_id references tb_driver(id)) ";
        sqLiteDatabase.execSQL(tb_receipt);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
