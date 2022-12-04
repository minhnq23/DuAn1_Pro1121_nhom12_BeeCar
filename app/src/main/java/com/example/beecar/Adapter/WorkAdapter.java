package com.example.beecar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beecar.DAO.ReceiptDAO;
import com.example.beecar.Model.Receipt;
import com.example.beecar.Model.Schedule;
import com.example.beecar.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.viewholder>{
    List<Schedule> list ;
    Context context;
    ReceiptDAO receiptDAO ;
    Receipt receipt =null;



    public WorkAdapter(List<Schedule> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorkAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_work,null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkAdapter.viewholder holder, int position) {
        final Schedule schedule = list.get(position);
        receiptDAO= new ReceiptDAO(context);
        for (Receipt obj: receiptDAO.selectAll() ){
            if(obj.getId() == schedule.getReceipt_id()){
                receipt = obj;

            }
        }
        holder.tvDiaDiemDon.setText(schedule.getDia_diem());
        holder.tvStart.setText(schedule.getStart_time());
        holder.tvEnd.setText(schedule.getEnd_time());
        holder.tvNameKH.setText(receipt.getName_client());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView tvDiaDiemDon;
        TextView tvStart;
        TextView tvEnd;
        TextView tvNameKH;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tvDiaDiemDon= itemView.findViewById(R.id.tv_dia_diem_don);
            tvNameKH= itemView.findViewById(R.id.tv_name_khach);
            tvStart= itemView.findViewById(R.id.tv_day_di);
            tvEnd= itemView.findViewById(R.id.tv_day_ketthuc);



        }
    }
    private String getToday(){
        return  new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
    }
}
