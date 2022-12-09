package com.example.tonapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity2 extends AppCompatActivity {

    EditText edtUsername, edtNewUsername, edtOldPw, edtNewPw;
    Button btnSua, btnTiepTuc;
    String Username,NewUsn,NewPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        Anhxa();
        Event();
    }
    private void Event(){
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity2.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                Dialog sua = new Dialog(LoginActivity2.this, android.R.style.Theme_DeviceDefault_Dialog);
                sua.setTitle("Màn hình sửa thông tin");
                sua.setCancelable(false);
                sua.setContentView(R.layout.editor);
                EditText edtNewUsn=(EditText)sua.findViewById(R.id.edtNewUsn);
                EditText edtNewTk=(EditText) sua.findViewById(R.id.edtNewTk);
                EditText edtNewMk=(EditText) sua.findViewById(R.id.edtNewMk);
                Button btnDongY2=(Button) sua.findViewById(R.id.btnDongY2);
                Button btnHuy2=(Button) sua.findViewById(R.id.btnHuy2);
                Username=edtUsername.getText().toString().trim();
                NewUsn=edtNewUsername.getText().toString().trim();
                NewPw=edtNewPw.getText().toString().trim();
                edtNewUsn.setText(Username);
                edtNewTk.setText(NewUsn);
                edtNewMk.setText(NewPw);
                btnDongY2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sua.cancel();
                    }
                });
                sua.show();
            }
        });
    }
    private void Anhxa(){
        edtUsername=(EditText)findViewById(R.id.edtUsername);
        edtNewUsername=(EditText) findViewById(R.id.edtNewUsername);
        edtOldPw=(EditText) findViewById(R.id.edtOldPw);
        edtNewPw=(EditText) findViewById(R.id.edtNewPw);
        btnSua=(Button) findViewById(R.id.btnSua);
        btnTiepTuc=(Button) findViewById(R.id.btnTiepTuc);
    }
}