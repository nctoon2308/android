package com.example.tonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity3 extends AppCompatActivity {

    Button btnSuaTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login3);
        Anhxa();
        Event();
    }
    private void Event(){
        btnSuaTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(LoginActivity3.this,LoginActivity2.class);
                startActivity(s);
            }
        });
    }
    private void Anhxa(){
        btnSuaTT=(Button) findViewById(R.id.btnSuaTT);
    }
}