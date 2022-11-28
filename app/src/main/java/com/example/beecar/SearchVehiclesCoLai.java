package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beecar.Adapter.VehiclesAdapter;
import com.example.beecar.DAO.ClientDAO;
import com.example.beecar.DAO.DriverDAO;
import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Model.Client;
import com.example.beecar.Model.Driver;
import com.example.beecar.Model.Vehicles;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchVehiclesCoLai extends AppCompatActivity {
    Toolbar toolbar;
    EditText ed_dia_diem;
    TextView ed_date_nhan;
    TextView ed_date_tra;
    Button btn_Search;

    DatePickerDialog.OnDateSetListener mDat1;
    DatePickerDialog.OnDateSetListener mDat;
    VehiclesDAO vehiclesDAO;
    VehiclesAdapter adapter;
    RecyclerView recyclerView;
    Driver driver;
    DriverDAO driverDAO;
    List<Vehicles> list = new ArrayList<>();
    ClientDAO clientDAO;
    Client objC = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vehicles_co_lai);
    }







    private Date stringToDate(String aDate) {
        if(aDate==null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/mm/yyyy");
        Date stringDate = simpledateformat.parse(aDate, pos);
        return stringDate;

    }






    private void showDialogPickerNhan() {
        Calendar cal1 = Calendar.getInstance();
        int year = cal1.get(Calendar.YEAR);
        int month = cal1.get(Calendar.MONTH);
        int day = cal1.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog1 = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDat1,year,month,day);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog1.isShowing();
        dialog1.show();
        mDat1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                String str = i2+"/"+i1+"/"+i;
                ed_date_nhan.setText(str);
            }
        };
    }





    private void showDialogPickerTra() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDat,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
        mDat = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                String str = i2+"/"+i1+"/"+i;
                ed_date_tra.setText(str);
            }
        };
    }
}