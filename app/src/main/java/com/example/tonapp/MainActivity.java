package com.example.tonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Timestamp;


public class MainActivity extends AppCompatActivity {

    private Button btnOrder;
    private Button btnAddOrder;
    private Button btnAdmin;
    private Button btnAddMoney;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnAddOrder = (Button) findViewById(R.id.btnAddOrder);
        btnAdmin = (Button) findViewById(R.id.btnAdmin);
        btnAddMoney = (Button) findViewById(R.id.btnAddMoney);

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity2.class);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NapTienActivity.class);
                startActivity(intent);
            }
        });
        btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInsert();
            }
        });

    }

    private void showDialogInsert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
                if (DonHangDAO.insert(MainActivity.this,adminId, code, timeIn)){
                    Toast.makeText(MainActivity.this, "Thêm xe thành công",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }else {
                    Toast.makeText(MainActivity.this, "Xảy ra lỗi, vui lòng thử lại!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}