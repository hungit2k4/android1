package com.example.phu_dao_va_on_tap.Phudao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.phu_dao_va_on_tap.Adapter.SinhVienAdapter;
import com.example.phu_dao_va_on_tap.Models.SinhVien;
import com.example.phu_dao_va_on_tap.R;

import java.util.ArrayList;

public class QLNhanVien extends AppCompatActivity {
    Button btnThemNV;
    ListView lvNhanVien;
    ArrayList<SinhVien> list;
    SinhVienAdapter sinhVienAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlnhan_vien);
        btnThemNV = findViewById(R.id.btnThemNV);
        lvNhanVien = findViewById(R.id.lvNhanVien);

    }
}