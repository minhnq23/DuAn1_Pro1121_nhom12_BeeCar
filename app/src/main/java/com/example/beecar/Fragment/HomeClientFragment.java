package com.example.beecar.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.beecar.Model.User;
import com.example.beecar.R;
import com.example.beecar.SearchVehiclesTuLai;


public class HomeClientFragment extends Fragment {
    LinearLayout btn_tu_lai;
    TextView tvFullName;


    public HomeClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home_client, container, false);
        User obj = (User) getArguments().get("obj");
        tvFullName = v.findViewById(R.id.tv_full_name);
        tvFullName.setText(obj.getFull_name());

        btn_tu_lai = v.findViewById(R.id.layout_tu_lai);
        btn_tu_lai.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), SearchVehiclesTuLai.class);
            i.putExtra("obj",obj);
            startActivity(i);
        });



        return v;
    }
}