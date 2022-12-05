package com.example.beecar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beecar.R;

public class GioiThieuQuanLyTaiXeFragment extends Fragment {




    public GioiThieuQuanLyTaiXeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gioi_thieu_quan_ly_tai_xe, container, false);
    }
}