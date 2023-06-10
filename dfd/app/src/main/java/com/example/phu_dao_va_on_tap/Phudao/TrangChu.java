package com.example.phu_dao_va_on_tap.Phudao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phu_dao_va_on_tap.R;

public class TrangChu extends AppCompatActivity {
    Button btnPhongBan, btnNhanVien,btnThoat;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        btnPhongBan = findViewById(R.id.btnPhongBan);
        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnThoat = findViewById(R.id.btnThoat);
        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this,QLNhanVien.class );
                startActivity(intent);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}