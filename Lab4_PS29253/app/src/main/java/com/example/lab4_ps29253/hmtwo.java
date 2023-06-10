package com.example.lab4_ps29253;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class hmtwo extends AppCompatActivity {
    EditText txtTenMon;
    EditText edtGiaTien;
    Button btnBaoGia;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmtwo);
        txtTenMon= findViewById(R.id.txtTenMon);
        edtGiaTien = findViewById(R.id.edtGiaTien);
        btnBaoGia = findViewById(R.id.btnBaoGia);
        Intent intent=getIntent();
        String tenMon = intent.getStringExtra("tenMon");
        txtTenMon.setText(tenMon);
        btnBaoGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Integer giaTien= Integer.parseInt(edtGiaTien.getText().toString()) ;
            }
        });

    }
}