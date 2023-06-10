package com.example.lab5_ps29253;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSinhVien;
    SinhVienAdapter sinhVienAdapter;
    ArrayList<SinhVien> list;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSinhVien = findViewById(R.id.lvSinhVien);
        btnLuu =findViewById(R.id.btnLuu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list.add(new SinhVien(1,"fgsdhj","gfjsg","gfjd"));
        list.add(new SinhVien(2,"fgsdhj","gfjsg","gfjd"));
        list.add(new SinhVien(3,"fgsdhj","gfjsg","gfjd"));
        sinhVienAdapter = new SinhVienAdapter(list);
        lvSinhVien.setAdapter(sinhVienAdapter);
    }
}