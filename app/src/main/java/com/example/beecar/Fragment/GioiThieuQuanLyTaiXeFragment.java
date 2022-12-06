package com.example.beecar.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.beecar.MainActivity;
import com.example.beecar.Model.User;
import com.example.beecar.R;

public class GioiThieuQuanLyTaiXeFragment extends Fragment {
    TextView tvnamequanly;
    LinearLayout btn_dang_xuat;


    public GioiThieuQuanLyTaiXeFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gioi_thieu_quan_ly_tai_xe, container, false);
        tvnamequanly = (TextView) view.findViewById(R.id.tv_name_quanly);
        tvnamequanly.setText("ADMIN");
        btn_dang_xuat = view.findViewById(R.id.btn_dang_xuat_quanly);
        btn_dang_xuat.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Đăng xuất");
            builder.setMessage("Bạn có muốn đăng xuất ? ");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getActivity().finish();
                    startActivity(new Intent(getContext(), MainActivity.class));


                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            // tao dialog
            AlertDialog dialog = builder.create();
            dialog.show();


        });
        return view;
    }
}