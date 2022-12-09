package com.example.tonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<DonHang> donHangList;

    public OrderAdapter(Context context, int layout, List<DonHang> donHangList){
        this.context = context;
        this.layout = layout;
        this.donHangList = donHangList;
    }

    @Override
    public int getCount() {
        return donHangList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtCode = convertView.findViewById(R.id.txtCode);
        TextView txtTime = convertView.findViewById(R.id.txtTime);


        DonHang DonHang = donHangList.get(position);

        txtCode.setText("Biển số: "+DonHang.getOrderCode());
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm dd/MM/yy");
        String time = sdf.format(DonHang.getTimeIn()) ;
        txtTime.setText("Thời gian vào: "+time);

        return convertView;

    }

}
