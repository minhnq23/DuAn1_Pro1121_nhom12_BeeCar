package com.example.beecar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.beecar.Fragment.CaNhanFragmet;
import com.example.beecar.Fragment.HomeClientFragment;
import com.example.beecar.Fragment.SupportFragment;
import com.example.beecar.Fragment.TripFragment;
import com.example.beecar.Model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeClient extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);
        bottomNavigationView = findViewById(R.id.bottom_nav_client);




        User user = (User) getIntent().getSerializableExtra("obj");
        Toast.makeText(this, user.getFull_name()+"", Toast.LENGTH_SHORT).show();

        HomeClientFragment fragmentHome = new HomeClientFragment();
        Bundle bun = new Bundle();
        bun.putSerializable("obj",user);
        fragmentHome.setArguments(bun);
        replaceFrg(fragmentHome);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.homeclient:
                            HomeClientFragment fragmentH = new HomeClientFragment();
                            Bundle bun = new Bundle();
                            bun.putSerializable("obj",user);
                            fragmentH.setArguments(bun);
                            replaceFrg(fragmentH);
                            break;
                        case R.id.trip_client:
                            TripFragment tfrg = new TripFragment();
                            Bundle bunT = new Bundle();
                            bunT.putSerializable("obj",user);
                            tfrg.setArguments(bunT);
                            replaceFrg(tfrg);
                            break;
                        case R.id.htClient:
                            SupportFragment frgS = new SupportFragment();
                            replaceFrg(frgS);
                            break;
                        case R.id.ca_nhan:
                            CaNhanFragmet frgC = new CaNhanFragmet();
                            Bundle bunCN = new Bundle();
                            bunCN.putSerializable("obj",user);
                            frgC.setArguments(bunCN);
                            replaceFrg(frgC);
                            break;

                    }
                return true;
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public  void replaceFrg(Fragment frg){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_main_home,frg).commit();
    }
}
