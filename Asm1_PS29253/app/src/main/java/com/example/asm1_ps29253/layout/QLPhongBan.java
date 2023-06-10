package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.asm1_ps29253.Adapter.PhongBanAdapter;
import com.example.asm1_ps29253.Models.PhongBan;
import com.example.asm1_ps29253.R;

import java.util.ArrayList;

public class QLPhongBan extends AppCompatActivity {
    ListView lvPhongBan;
    ArrayList <PhongBan> list = new ArrayList<>();
    PhongBanAdapter phongBanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlphongban);
        lvPhongBan = findViewById(R.id.lvPhongBan);
        list.add(new PhongBan("Nhân sự"));
        list.add(new PhongBan("Hành chính"));
        list.add(new PhongBan("Đào tạo"));
        phongBanAdapter = new PhongBanAdapter(list);
        lvPhongBan.setAdapter(phongBanAdapter);
    }
}