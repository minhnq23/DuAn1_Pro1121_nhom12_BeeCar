package com.example.beecar.DAO;

import android.content.Context;

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
        String sql = "select*from tb_schedule where driver_id ="+id;
        return list;
    }


}
