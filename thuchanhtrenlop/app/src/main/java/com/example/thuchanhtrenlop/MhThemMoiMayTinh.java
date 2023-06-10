package com.example.thuchanhtrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MhThemMoiMayTinh extends AppCompatActivity {
    EditText edtHang,edtGia;
    Button btnLuu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_them_moi_may_tinh);
        edtHang = findViewById(R.id.edtHang);
        edtGia = findViewById(R.id.edtGia);
        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hang = edtHang.getText().toString();
                String gia = edtGia.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("hang",hang);
                intent.putExtra("gia",gia);
                setResult(1, intent);
                finish();
            }
        });
    }
}