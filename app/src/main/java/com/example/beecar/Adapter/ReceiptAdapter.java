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

import com.example.beecar.DAO.ReceiptDAO;
import com.example.beecar.Model.Receipt;
import com.example.beecar.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReceiptAdapter extends BaseAdapter {
    Context context;
    ReceiptDAO receiptDAO;
    List<Receipt> list;
    ArrayList<HashMap<String,String>> listspinners;

    public ReceiptAdapter(Context context, List<Receipt> list,ArrayList<HashMap<String,String>>listspinners){
        this.context=context;
        receiptDAO= new ReceiptDAO(context);
        this.list=list;
        this.listspinners=listspinners;
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
    public static class ViewOfItem{
        TextView tvname_client,tvname_driver,tvoder,tvstart,tvend,tvstatus_driver,tvstatus,
        tvtotal,tvclient_id,tvdriver_id,tvvehicles_id
                ;
        ImageView imgxoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewOfItem viewOfItem;
        if(view==null){
            viewOfItem = new ViewOfItem();
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_receipt,null,false);
            viewOfItem.tvstart= view.findViewById(R.id.tvstart);
            viewOfItem.tvoder= view.findViewById(R.id.tvoder);
            viewOfItem.tvend= view.findViewById(R.id.tvend);
            viewOfItem.tvstatus= view.findViewById(R.id.tvstatus);
            viewOfItem.tvtotal= view.findViewById(R.id.tvtotal);
            view.setTag(viewOfItem);

        }else {
            viewOfItem=(ViewOfItem) view.getTag();
        }
        viewOfItem.tvstart.setText(list.get(i).getStart_time());
        viewOfItem.tvoder.setText(list.get(i).getOder_time());
        viewOfItem.tvend.setText(list.get(i).getEnd_time());
        viewOfItem.tvstatus.setText(list.get(i).getStatus());
        viewOfItem.tvtotal.setText(list.get(i).getTotal());
        viewOfItem.imgxoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                builder.setMessage("Xóa Receip");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int id= list.get(i).getId();
                        if(receiptDAO.delete(id)){
                            Toast.makeText(context,"Xóa Thành Công",Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(receiptDAO.selectAll());
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

    return view;
    }
}
