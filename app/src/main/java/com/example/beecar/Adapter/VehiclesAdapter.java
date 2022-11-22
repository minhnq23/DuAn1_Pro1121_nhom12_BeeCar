package com.example.beecar.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Model.Vehicles;
import com.example.beecar.R;

import java.util.List;

public class VehiclesAdapter extends BaseAdapter {
    List<Vehicles> list;
    VehiclesDAO vehiclesDAO;
    Context context;

    public VehiclesAdapter(List<Vehicles> list, Context context) {
        this.list = list;
        vehiclesDAO = new VehiclesDAO(context);
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewOfItems{
        TextView tvnamecar,tvdate,tvlanthue;
        ImageView imaxoa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewOfItems viewOfItems;
       if(view==null){
           viewOfItems = new ViewOfItems();
           view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vehicels,null,false);
               viewOfItems.tvnamecar= view.findViewById(R.id.tvnamecar);
               viewOfItems.tvdate= view.findViewById(R.id.tvdate);
               viewOfItems.tvlanthue= view.findViewById(R.id.tvlanthue);
               view.setTag(viewOfItems);

           }else{
               viewOfItems=(ViewOfItems) view.getTag();
           }
       viewOfItems.tvnamecar.setText(list.get(i).getName_car());
        viewOfItems.tvdate.setText(list.get(i).getDay_bd());
        viewOfItems.tvlanthue.setText(list.get(i).getId_category());
        viewOfItems.imaxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                builder.setMessage("Xóa Vehicles");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int id= list.get(i).getId();
                        if(vehiclesDAO.delete(id)){
                            Toast.makeText(context,"Xóa Thành Công",Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(vehiclesDAO.selectAll());
                            notifyDataSetInvalidated();
                        }
                    }

                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }});
                AlertDialog dialog= builder.create();
                dialog.show();
            }


        });


        return null;
    }
}
