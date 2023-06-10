package com.example.lab5_ps29253;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MhDienThoai extends AppCompatActivity {
    ListView lvDienThoai;
    DienThoaiAdapter dienThoaiAdapter;
    ArrayList<DienThoai> list;
    EditText edtTenDT,edtGia,edtSoLuong;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_dien_thoai);
        lvDienThoai = findViewById(R.id.lvDienThoai);
        edtTenDT = findViewById(R.id.edtTenDT);
        edtGia = findViewById(R.id.edtGia);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        btnLuu = findViewById(R.id.btnLuu);
    }
    @Override
    protected void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list.add(new DienThoai(2,"Samsung","20000","30"));
        list.add(new DienThoai(2,"Oppo","40000","60"));
        list.add(new DienThoai(2,"Samsung s9","10000","90"));
        dienThoaiAdapter = new DienThoaiAdapter(list);
        lvDienThoai.setAdapter(dienThoaiAdapter);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenDT = edtTenDT.getText().toString();
                String gia = edtGia.getText().toString();
                String soLuong = edtSoLuong.getText().toString();
                list.add(new DienThoai(list.size()+1,tenDT,gia,soLuong));
                dienThoaiAdapter.notifyDataSetChanged();
            }
        });
    }
}