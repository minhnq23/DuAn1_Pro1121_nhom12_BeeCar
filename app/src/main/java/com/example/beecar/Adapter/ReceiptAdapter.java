package com.example.beecar.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beecar.DAO.ReceiptDAO;
import com.example.beecar.Model.Receipt;
import com.example.beecar.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.viewholder> {
    List<Receipt> list;
    Context context;

    public ReceiptAdapter(Context context, List<Receipt> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ReceiptAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_receipt, null);
        return new ReceiptAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final Receipt receipt = list.get(position);
        holder.tvStart.setText("Ngày bắt đầu: " + receipt.getStart_time());
        holder.tvOder.setText("Ngày đặt xe: " + receipt.getOder_time());
        holder.tvEnd.setText("Ngày trả xe: " + receipt.getEnd_time());
        holder.tvStatus.setText("Trạng thái: " + receipt.getStatus()+"");
        holder.tvTotal.setText("Tổng cộng: " + receipt.getStatus()+"");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        LinearLayout item;
        TextView tvStart;
        TextView tvOder;
        TextView tvEnd;
        TextView tvStatus;
        TextView tvTotal;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item_receipt);
            tvStart = itemView.findViewById(R.id.tvstart);
            tvOder = itemView.findViewById(R.id.tvoder);
            tvEnd = itemView.findViewById(R.id.tvend);
            tvStatus = itemView.findViewById(R.id.tvstatusreceipt);
            tvTotal = itemView.findViewById(R.id.tvtotal);
        }
    }
}
