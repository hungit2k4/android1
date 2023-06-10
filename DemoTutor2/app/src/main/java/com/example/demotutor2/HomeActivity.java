package com.example.demotutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnNhanVien, btnPhongBan, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnPhongBan = findViewById(R.id.btnPhongBan);
        btnThoat = findViewById(R.id.btnThoat);

        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển sang màn hình nhân viên
                Intent intent = new Intent(HomeActivity.this,
                        EmployeeActivity.class);
                startActivity(intent);
            }
        });

        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển sang màn hình phòng ban
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // thoát ứng dụng
            }
        });
    }
}