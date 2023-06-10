package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asm1_ps29253.R;

public class trangchu extends AppCompatActivity {
    Button btnThoat,btnNhanVien,btnPhongBan;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnThoat = findViewById(R.id.btnThoat);
        btnPhongBan = findViewById(R.id.btnPhongBan);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(trangchu.this, QLPhongBan.class);
                startActivity(intent);
            }
        });
        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(trangchu.this, QLNhanVien.class);
                startActivity(intent);
            }
        });
    }
}