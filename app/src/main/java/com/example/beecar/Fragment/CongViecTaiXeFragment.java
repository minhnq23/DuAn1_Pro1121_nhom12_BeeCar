package com.example.beecar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.beecar.Adapter.WorkAdapter;
import com.example.beecar.DAO.DriverDAO;
import com.example.beecar.DAO.ScheduleDAO;
import com.example.beecar.Model.Driver;
import com.example.beecar.Model.User;
import com.example.beecar.R;


public class CongViecTaiXeFragment extends Fragment {
    RecyclerView recywork;
    WorkAdapter workAdapter;
    ScheduleDAO scheduleDAO;
    Driver objvc = null;

    public CongViecTaiXeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cong_viec_tai_xe, container, false);

        User objU = (User) getArguments().get("objx");
        DriverDAO driverDAO = new DriverDAO(getContext());

        for (Driver d: driverDAO.selectAll()){
            if (d.getUser_id() == objU.getId()){
                objvc = d ;
            }
        }
        recywork = view.findViewById(R.id.recy_work);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recywork.setLayoutManager(linearLayoutManager);
        scheduleDAO =  new ScheduleDAO(getContext());
        workAdapter = new WorkAdapter(scheduleDAO.selectOfDriver(objvc.getId()),getContext());
        recywork.setAdapter(workAdapter);
        workAdapter.notifyDataSetChanged();
        return view;

    }
}