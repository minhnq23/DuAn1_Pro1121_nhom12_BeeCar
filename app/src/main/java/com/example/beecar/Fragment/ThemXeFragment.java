package com.example.beecar.Fragment;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Vehicles;
import com.example.beecar.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ThemXeFragment  extends  Fragment {
    EditText ed_name_car, ed_bien_car, ed_price_date, ed_price_time, ed_date_kt, ed_date_bd;
    ImageView img_car;
    Button btn_add_xe;
    final int REQUEST_CODE_GALLERY = 999;
    MyDbHelper myDbHelper;
    VehiclesDAO vehiclesDAO;
    Vehicles vehicles;
    QuanLyXeFragment quanLyXeFragment;
//    DatePickerDialog.OnDateSetListener dateSetListener, mDateSetListerner;
    public static final int PICK_IMAGE = 1;


    public ThemXeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_them_xe, container, false);
        myDbHelper = new MyDbHelper(inflater.getContext());
        vehiclesDAO = new VehiclesDAO(inflater.getContext());

        ed_name_car = (EditText) view.findViewById(R.id.ed_name_car);
        ed_bien_car = (EditText) view.findViewById(R.id.ed_bien_car);
        ed_price_date = (EditText) view.findViewById(R.id.ed_price_date);
        ed_price_time = (EditText) view.findViewById(R.id.ed_price_time);
        ed_date_kt = (EditText) view.findViewById(R.id.ed_date_kt);
        ed_date_bd = (EditText) view.findViewById(R.id.ed_date_bd);
        img_car = (ImageView) view.findViewById(R.id.img_car);
        btn_add_xe = (Button) view.findViewById(R.id.btn_add_xe);
        img_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY

                );

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }


        });

        btn_add_xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicles = new Vehicles();
                vehicles.setImage(myDbHelper.getBytes(img_car));
                vehicles.setName_car(ed_name_car.getText().toString().trim());
                vehicles.setBien_ks(ed_bien_car.getText().toString().trim());
                vehicles.setPrice_date(Integer.parseInt(ed_price_date.getText().toString().trim()));
                vehicles.setPrice_time(Integer.parseInt(ed_price_time.getText().toString().trim()));
                vehicles.setDay_dk(ed_date_kt.getText().toString().trim());
                vehicles.setCount_muon(0);
                vehicles.setVehicles_status(0);
                vehicles.setDay_bd(ed_date_bd.getText().toString().trim());
                vehicles.setId_category(1);
//                if (ed_name_car.getText().toString().equals("")) {
//                    Toast.makeText(getActivity(), "Tên xe trống!", Toast.LENGTH_SHORT).show();
//                } if (ed_bien_car.getText().toString().equals("")) {
//                    Toast.makeText(getActivity(), "Biển số xe trống!", Toast.LENGTH_SHORT).show();
//                } if (ed_date_kt.getText().toString().equals("")) {
//                    Toast.makeText(getActivity(), "Ngày kiểm thử trống!", Toast.LENGTH_SHORT).show();
//                } if (ed_date_bd.getText().toString().equals("")) {
//                    Toast.makeText(getActivity(), "Ngày bảo dưỡng trống!", Toast.LENGTH_SHORT).show();
//                }
                if (vehiclesDAO.insert(vehicles)) {
                    Toast.makeText(getContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    quanLyXeFragment = new QuanLyXeFragment();
                    ganFragDriver(quanLyXeFragment);


                } else {
                    Toast.makeText(getContext(), "Thêm thất bại!", Toast.LENGTH_SHORT).show();
                }

            }
        });
//        ed_date_kt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        dateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker v, int year, int month, int dayOfMonth) {
//                Log.d(TAG, "onDateSet: dd/mm/yyyy" + dayOfMonth + "/" + month + "/" + year);
//                String date = dayOfMonth + "/" + month + "/" + year;
//                ed_date_kt.setText(date);
//            }
//        };
//        ed_date_bd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListerner, year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        mDateSetListerner = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker v, int year, int month, int dayOfMonth) {
//                Log.d(TAG, "onDateSet: dd/mm/yyyy" + dayOfMonth + "/" + month + "/" + year);
//                String date = dayOfMonth + "/" + month + "/" + year;
//                ed_date_bd.setText(date);
//            }
//        };
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            Uri uri = data.getData();


            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img_car.setImageBitmap(bitmap);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void ganFragDriver(Fragment fg) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.framerquanly, fg).commit();
    }
}






