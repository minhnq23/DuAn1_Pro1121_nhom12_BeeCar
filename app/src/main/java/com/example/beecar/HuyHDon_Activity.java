package com.example.beecar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beecar.DAO.ClientDAO;
import com.example.beecar.DAO.ReceiptDAO;
import com.example.beecar.Model.Client;
import com.example.beecar.Model.Receipt;
import com.example.beecar.Model.User;

public class HuyHDon_Activity extends AppCompatActivity {
    Toolbar toolbarCn;
    RecyclerView recyclerViewCN;
    ReceiptDAO receiptDAOCN;
    Receipt objr = null;
    ClientDAO clientDAO;
    Client objC = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huy_hdon);
        toolbarCn = findViewById(R.id.toolbar_cn2);
        setSupportActionBar(toolbarCn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hoa don cua toi");
        User objU = (User) getIntent().getSerializableExtra("obj");
        receiptDAOCN = new ReceiptDAO(this);
    }
}