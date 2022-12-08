package com.example.tonapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ListView lv;
    OrderAdapter adapter;
    ArrayList<DonHang> dsDH = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        lv = findViewById(R.id.lvDonHang);
        dsDH = DonHangDAO.getAll(OrderActivity.this);

        adapter = new OrderAdapter(OrderActivity.this,R.layout.list_order, dsDH);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                showDialogUpdate(position);
            }
        });

    }


    private void showDialogInsert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_addorder, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText edtCode = view.findViewById(R.id.edt_orderCode);
        Button btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = edtCode.getText().toString();
                int adminId = 1;
                long timeIn = timestamp.getTime();
                if (DonHangDAO.insert(OrderActivity.this,adminId, code, timeIn)){
                    Toast.makeText(OrderActivity.this, "Success",Toast.LENGTH_LONG).show();
                    dsDH.clear();
                    dsDH.addAll(DonHangDAO.getAll(OrderActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(OrderActivity.this, "Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void showDialogUpdate(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_updateorder, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText edtCode = view.findViewById(R.id.edt_orderCode);

        Button btnOut = view.findViewById(R.id.btnOut);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        DonHang dh = dsDH.get(position);
        edtCode.setText(dh.getOrderCode());

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DonHangDAO.out(OrderActivity.this, dh)){
                    Toast.makeText(OrderActivity.this, "Xe ra thành công",Toast.LENGTH_LONG).show();
                    dsDH.clear();
                    dsDH.addAll(DonHangDAO.getAll(OrderActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(OrderActivity.this, "Lỗi",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dh.setOrderCode(edtCode.getText().toString());
                if (DonHangDAO.update(OrderActivity.this, dh)){
                    Toast.makeText(OrderActivity.this, "Update Success",Toast.LENGTH_LONG).show();
                    dsDH.clear();
                    dsDH.addAll(DonHangDAO.getAll(OrderActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(OrderActivity.this, "Update Error",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DonHangDAO.delete(OrderActivity.this, dh.getOrderId())){
                    Toast.makeText(OrderActivity.this, "Delete Success",Toast.LENGTH_LONG).show();
                    dsDH.clear();
                    dsDH.addAll(DonHangDAO.getAll(OrderActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(OrderActivity.this, "Delete Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}