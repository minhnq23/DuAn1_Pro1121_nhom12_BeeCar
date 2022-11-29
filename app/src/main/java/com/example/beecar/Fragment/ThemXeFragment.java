package com.example.beecar.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Database.MyDbHelper;
import com.example.beecar.Model.Vehicles;
import com.example.beecar.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ThemXeFragment  extends  Fragment {
    EditText ed_name_car, ed_bien_car, ed_price_date, ed_price_time, ed_date_kt, ed_date_bd;
    ImageView img_car;
    Button btn_add_xe;
    final int REQUEST_CODE_GALLERY = 999;
    MyDbHelper myDbHelper;
    VehiclesDAO vehiclesDAO;
    Vehicles vehicles;
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
                if (vehiclesDAO.insert(vehicles)) {
                    Toast.makeText(getContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Thêm thất bại!", Toast.LENGTH_SHORT).show();
                }

            }
        });
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
}






