package com.example.beecar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.beecar.Model.User;
import com.example.beecar.MyHDon_Activity;
import com.example.beecar.R;

public class CaNhanFragmet extends Fragment {
    LinearLayout linearLayoutmyHD;
    TextView tv_tentk;
    public CaNhanFragmet() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_canhan, container, false);
        User obj = (User) getArguments().get("obj");
        tv_tentk = view.findViewById(R.id.tv_tkcanhan);
        tv_tentk.setText(obj.getFull_name());
        linearLayoutmyHD = view.findViewById(R.id.hd_myHD);
        linearLayoutmyHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MyHDon_Activity.class);
                intent.putExtra("obj",obj);
                startActivity(intent);
            }
        });

        return view;
    }

}
