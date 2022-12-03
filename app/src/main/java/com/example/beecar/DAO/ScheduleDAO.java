package com.example.beecar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Schedule;

import java.util.ArrayList;

public class ScheduleDAO {
    MyDbHelper dbHelper;
    Context context;

    public ScheduleDAO(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
        dbHelper.getReadableDatabase();
    }

    public ArrayList<Schedule> selectOfDriver(int id){
        ArrayList<Schedule> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select*from tb_schedule where driver_id ="+id;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            while (!cursor.isAfterLast()){
                Schedule schedule = new Schedule();
                schedule.setId(cursor.getInt(0));
                schedule.setDia_diem(cursor.getString(1));
                schedule.setStatus_schedule(cursor.getInt(2));
                schedule.setStart_time(cursor.getString(3));
                schedule.setEnd_time(cursor.getString(4));
                schedule.setDriver_id(cursor.getInt(5));
                schedule.setReceipt_id(cursor.getInt(6));
            }
        }
        Log.e("scheduleListOfDrive",list.size()+"");
        cursor.close();
        return list;
    }

    public boolean insert(Schedule obj){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Schedule.COL_dia_diem,obj.getDia_diem());
        values.put(Schedule.COL_status,obj.getStatus_schedule());
        values.put(Schedule.COL_start_time,obj.getStart_time());
        values.put(Schedule.COL_end_time,obj.getEnd_time());
        values.put(Schedule.COL_driver_id,obj.getDriver_id());
        values.put(Schedule.COL_receipt_id,obj.getReceipt_id());
        long row = db.insert(Schedule.TB_name,null,values);
        return row>0;
    }


    public boolean update(Schedule obj){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Schedule.COL_dia_diem,obj.getDia_diem());
        values.put(Schedule.COL_status,obj.getStatus_schedule());
        values.put(Schedule.COL_start_time,obj.getStart_time());
        values.put(Schedule.COL_end_time,obj.getEnd_time());
        values.put(Schedule.COL_driver_id,obj.getDriver_id());
        values.put(Schedule.COL_receipt_id,obj.getReceipt_id());
        int row = db.update(Schedule.TB_name,values,"where id=?",new String[]{obj.getId()+""});
        return row>0;
    }

    public  boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int row = db.delete(Schedule.TB_name,"where receipt_id=?",new String[]{id+""});
        return row>0;

    }


}
