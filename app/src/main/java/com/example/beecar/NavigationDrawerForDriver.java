package com.example.beecar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.beecar.Fragment.CongViecTaiXeFragment;
import com.example.beecar.Fragment.GioiThieuTaiXeFragment;
import com.example.beecar.Fragment.HoatDongTaiXeFragment;
import com.example.beecar.Fragment.HomeDriverFragment;
import com.example.beecar.Fragment.SupportFragment;
import com.example.beecar.Fragment.ThongKeTaiXeFragment;
import com.example.beecar.Model.User;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerForDriver extends AppCompatActivity {
    DrawerLayout drawerLayoutDriver;
    Toolbar toolbarDriver;
    Intent intent;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_for_driver);
        toolbarDriver = findViewById(R.id.toolbarDrive);
        setSupportActionBar(toolbarDriver);
        NavigationView navDriver = findViewById(R.id.nav_view_driver);
        drawerLayoutDriver = findViewById(R.id.drawerLayoutForDriver);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayoutDriver, toolbarDriver, R.string.navigationdrawer_driver_open, R.string.navigationdrawer_driver_close);
        drawerLayoutDriver.addDrawerListener(toggle);
        toggle.syncState();

        User user = (User) getIntent().getSerializableExtra("obj");


        CongViecTaiXeFragment congViecTaiXeFragment = new CongViecTaiXeFragment();
        Bundle bunx = new Bundle();
        bunx.putSerializable("objx",user);
        congViecTaiXeFragment.setArguments(bunx);
        ganFragDriver(congViecTaiXeFragment);
        navDriver.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.driverHome:
                        HomeDriverFragment homeDriverFragment= new HomeDriverFragment();
                        ganFragDriver(homeDriverFragment);
                       break;
                    case R.id.driverWork:

                        CongViecTaiXeFragment congViecTaiXeFragment = new CongViecTaiXeFragment();
                        Bundle bunx = new Bundle();
                        bunx.putSerializable("objx",user);
                        congViecTaiXeFragment.setArguments(bunx);
                        ganFragDriver(congViecTaiXeFragment);
                        break;
//                    case R.id.driverActivity:
//                        ganFragDriver(new HoatDongTaiXeFragment());
//                        break;
//                    case R.id.driverThuNhap:
//                        ganFragDriver(new ThongKeTaiXeFragment());
//                        break;
                    case R.id.driverTroGiup:

                        GioiThieuTaiXeFragment fragmentH = new GioiThieuTaiXeFragment();
                        Bundle bun = new Bundle();
                        bun.putSerializable("obj",user);
                        fragmentH.setArguments(bun);
                        ganFragDriver(fragmentH);
                        break;

                    case R.id.driverThoat:
                        NavigationDrawerForDriver.this.finishAffinity();
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
    public void ganFragDriver(Fragment fg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.framerDrive, fg).commit();
        drawerLayoutDriver.close();
    }
}