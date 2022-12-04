package com.example.beecar.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beecar.DAO.VehiclesDAO;
import com.example.beecar.Model.Vehicles;
import com.example.beecar.R;

import java.util.List;

public class VehiclesManagerAdapter extends RecyclerView.Adapter<VehiclesManagerAdapter.viewholder> {
    List<Vehicles> list;
    VehiclesDAO vehiclesDAO;
    Context context;

    public VehiclesManagerAdapter(Context context, List<Vehicles> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VehiclesManagerAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vehicels, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesManagerAdapter.viewholder holder, int position) {
        final  Vehicles obj = list.get(position);
        Bitmap bitmap = BitmapFactory.decodeByteArray(obj.getImage(),0,obj.getImage().length);
        holder.img.setImageBitmap(bitmap);
        holder.tvName.setText(obj.getName_car());
        holder.tvPrice.setText(obj.getPrice_date()+"/ngày");
        holder.tvDayBd.setText(obj.getDay_bd());
        holder.tvCountThue.setText(obj.getCount_muon()+" chuyến");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        LinearLayout item;
        ImageView img;
        TextView tvName;
        TextView tvPrice;
        TextView tvDayBd;
        TextView tvCountThue;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            img = itemView.findViewById(R.id.img_vehicles);
            tvName = itemView.findViewById(R.id.tv_name_car);
            tvPrice = itemView.findViewById(R.id.tv_price_date);
            tvDayBd = itemView.findViewById(R.id.tv_date_bd);
            tvCountThue = itemView.findViewById(R.id.tv_lan_thue);
        }
    }
}
