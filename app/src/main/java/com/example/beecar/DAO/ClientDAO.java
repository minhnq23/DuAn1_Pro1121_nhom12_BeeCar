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

public class ClientDAO {
    private SQLiteDatabase database;
    private MyDbHelper dbHelper;
    public static final String TABLE_NAME = "tb_client";

    public ClientDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public ArrayList<Client> selectAll(){
        ArrayList<Client> list_client = new ArrayList<>();
        String select = "SELECT * FROM "+ ClientDAO.TABLE_NAME;
        Cursor cursor  = database.rawQuery(select, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Client client = new Client();
                client.setIdCilent(cursor.getString(0));
                client.setUser_name(cursor.getString(1));
                client.setPassword(cursor.getString(2));
                client.setFull_name(cursor.getString(3));
                list_client.add(client);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list_client;
    }

    public long insertClient(Client client){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idCilent",client.getIdUser());
        contentValues.put("user_name",client.getUser_name());
        contentValues.put("password",client.getPassword());
        contentValues.put("full_name",client.getFull_name());
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

    public int update(Client client){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idCilent",client.getIdUser());
        contentValues.put("user_name",client.getUser_name());
        contentValues.put("password",client.getPassword());
        contentValues.put("full_name",client.getFull_name());
        try {
            if(database.update(TABLE_NAME, contentValues, "idCilent"+"=?", new String[]{"idCilent"})==-1){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
}
