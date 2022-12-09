package com.example.tonapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtDangNhap, edtPassword;
    Button btnDangNhap, btnDangKy, btnThoat;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        edtDangNhap=(EditText) findViewById(R.id.edtDangNhap);
        edtPassword=(EditText) findViewById(R.id.edtPassword);
        btnDangNhap=(Button) findViewById(R.id.btnDangNhap);
        btnDangKy=(Button) findViewById(R.id.btnDangKy);
        btnThoat=(Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Bạn có chắc chắn muốn thoát khỏi app không ?");
                builder.setMessage("Hãy lựa chọn để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(LoginActivity.this, android.R.style.Theme_DeviceDefault_Dialog);
                dialog.setTitle("Màn hình đăng ký");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
                Button btnDongY = (Button) dialog.findViewById(R.id.btnDongY);
                btnDongY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtDangNhap.setText(ten);
                        edtPassword.setText(mk);
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtDangNhap.getText().length()!=0&&edtPassword.getText().length()!=0)
                {
                    if (edtDangNhap.getText().toString().equals(ten) && edtPassword.getText().toString().equals(mk)) {
                        Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                    }else if(edtDangNhap.getText().toString().equals("admin")&&edtPassword.getText().toString().equals(123)){
                        Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}