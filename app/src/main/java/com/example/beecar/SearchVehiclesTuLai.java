package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Model.Vehicles;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class SearchVehiclesTuLai extends AppCompatActivity {
    Toolbar toolbar;
    EditText ed_dia_diem;
    TextView ed_date_nhan;
    TextView ed_date_tra;
    Button btn_Search;
    DatePickerDialog.OnDateSetListener mDat1;
    DatePickerDialog.OnDateSetListener mDat;
    VehiclesDAO vehiclesDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vehicles_tu_lai);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tìm Xe");
        ed_dia_diem = findViewById(R.id.ed_đia_diem);
        ed_date_nhan = findViewById(R.id.date_picker_nhan);
        ed_date_tra = findViewById(R.id.date_picker_tra);
        btn_Search = findViewById(R.id.btn_tim_xe);

        ed_date_nhan.setOnClickListener(view -> {
          showDialogPickerNhan();

        });

        ed_date_tra.setOnClickListener(view -> {
            showDialogPickerTra();

        });

        btn_Search.setOnClickListener(view -> {
            checkDate();
            showData();
        });


    }

    private void showData() {
        List<Vehicles> list = new ArrayList<>();
        String strNhan = ed_date_nhan.getText().toString().trim();
        String strTra = ed_date_tra.getText().toString().trim();

        try {
            Date datenhan = stringToDate(strNhan);
            Date datetra = stringToDate(strTra);
            if (!datenhan.before(datetra)){
                Toast.makeText(this, "Bạn nhập sai ngày trả", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            Log.e("Notification","Chưa chọn ngày");
        }
        list.addAll(vehiclesDAO.selectCarStatus0());
        list.addAll(vehiclesDAO.selectCarStatus1(strNhan,strTra));
        Log.e("SIZE", list.size()+"");

    }


    public void checkDate(){

    }






    public void  checkData(){
        vehiclesDAO = new VehiclesDAO(this);


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