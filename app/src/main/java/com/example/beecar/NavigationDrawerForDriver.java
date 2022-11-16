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

import com.example.beecar.Fragment.CongViecTaiXeFragment;
import com.example.beecar.Fragment.GioiThieuTaiXeFragment;
import com.example.beecar.Fragment.HoatDongTaiXeFragment;
import com.example.beecar.Fragment.ThongKeTaiXeFragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerForDriver extends AppCompatActivity {
    DrawerLayout drawerLayoutDriver;
    Toolbar toolbarDriver;
    Intent intent;

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
        ganFragDriver(new CongViecTaiXeFragment());
        navDriver.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.driverHome:
                        intent = new Intent(NavigationDrawerForDriver.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.driverWork:
                        ganFragDriver(new CongViecTaiXeFragment());
                        break;
                    case R.id.driverActivity:
                        ganFragDriver(new HoatDongTaiXeFragment());
                        break;
                    case R.id.driverThongKe:
                        ganFragDriver(new ThongKeTaiXeFragment());
                        break;
                    case R.id.driverGioiThieu:
                        ganFragDriver(new GioiThieuTaiXeFragment());
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
    }
}