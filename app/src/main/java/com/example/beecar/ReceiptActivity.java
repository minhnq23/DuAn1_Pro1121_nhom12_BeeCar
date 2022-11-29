package com.example.beecar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.DAO.ClientDAO;
import com.example.beecar.DAO.ReceiptDAO;
import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Model.Client;
import com.example.beecar.Model.Receipt;
import com.example.beecar.Model.Vehicles;

public class ReceiptActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imgXe;
    TextView tvNameXe,tvPriceDay,tvDayBd,
    tvChuyen,tvIdXe,tvBien,tvDayDk,tvStatusXe,
    tvFullName,tvDayOder,tvDayStart,tvDayEnd,
    tvDonGia,tvTotal;
    VehiclesDAO vehiclesDAO;
    ClientDAO clientDAO;
    Vehicles vehicles = null;
    ReceiptDAO receiptDAO;
    Client client = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        toolbar = findViewById(R.id.tool_bar);
        imgXe = findViewById(R.id.img_xe);
        tvNameXe = findViewById(R.id.ten_xe);
        tvPriceDay = findViewById(R.id.tv_price_date);
        tvDayBd = findViewById(R.id.tv_day_bd);
        tvChuyen = findViewById(R.id.tv_luot_thue);
        tvIdXe = findViewById(R.id.tv_id_xe);
        tvBien = findViewById(R.id.bien_so);
        tvDayDk = findViewById(R.id.date_dk);
        tvStatusXe = findViewById(R.id.status_xe);
        tvFullName = findViewById(R.id.tv_full_name_client);
        tvDayOder = findViewById(R.id.tv_date_oder);
        tvTotal = findViewById(R.id.total);
        tvDayStart = findViewById(R.id.tv_date_nhan);
        tvDayEnd = findViewById(R.id.tv_date_tra);
        tvDonGia = findViewById(R.id.tv_don_gia);

        //set toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thông tin xe");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getobj
        vehiclesDAO = new VehiclesDAO(this);
        clientDAO = new ClientDAO(this);
        Receipt obj = (Receipt) getIntent().getSerializableExtra("obj");
        for (Vehicles v : vehiclesDAO.selectAll()){
            if (obj.getVehicles_id() == v.getId()){
                vehicles = v;
                break;
            }
        }
        for (Client c: clientDAO.selectAll() ){
            if (obj.getClient_id() == c.getId()){
                client = c;
                break;
            }
        }
    ////
        Bitmap bitmap = BitmapFactory.decodeByteArray(vehicles.getImage(),0,vehicles.getImage().length);
        imgXe.setImageBitmap(bitmap);
        tvNameXe.setText(vehicles.getName_car());
        tvPriceDay.setText(vehicles.getPrice_date()+"");
        tvDayBd.setText(vehicles.getDay_bd());
        tvChuyen.setText(vehicles.getCount_muon()+"");
        tvIdXe.setText(vehicles.getId()+"");
        tvBien.setText(vehicles.getBien_ks());
        tvDayDk.setText(vehicles.getDay_dk());
        tvStatusXe.setText("Thuê được");
        tvStatusXe.setTextColor(Color.GREEN);
        tvFullName.setText(client.getFull_name());
        tvDayOder.setText(obj.getOder_time());
        tvDayStart.setText(obj.getStart_time());
        tvDayEnd.setText(obj.getEnd_time());
        tvDonGia.setText(vehicles.getPrice_date()+"/ngày");
        tvTotal.setText(obj.getTotal()+"");

        findViewById(R.id.btn_dat_xe).setOnClickListener(view -> {
            receiptDAO = new ReceiptDAO(this);
            if (receiptDAO.insert(obj)){
                Toast.makeText(this, "Dat don thanh cong", Toast.LENGTH_SHORT).show();
                return;
            }else{
                Toast.makeText(this, "Dat don khong thanh cong", Toast.LENGTH_SHORT).show();
                return;
            }
        });

    }


}