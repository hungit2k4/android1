package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm1_ps29253.Models.NhanVien;
import com.example.asm1_ps29253.R;

import java.util.ArrayList;

public class ThemNhanVien extends AppCompatActivity {
    EditText edtMaNV,edtTenNV,edtPhongBan;
    Button btnThemNV;
    ArrayList <NhanVien> list=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        edtMaNV = findViewById(R.id.edtMaNV);
        edtTenNV = findViewById(R.id.edtTenNV);
        edtPhongBan = findViewById(R.id.edtPhongBan);
        btnThemNV = findViewById(R.id.btnThemNV);

        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ktMaNV ="NV+\\d{3}";
                String maNV = edtMaNV.getText().toString();
                if(maNV.matches(ktMaNV)==false){
                    edtMaNV.setError("Mã nhân viên không hợp lệ!");
                    return;
                }
                String tenNV = edtTenNV.getText().toString();

                String phongban= edtPhongBan.getText().toString();
                Intent intent =new Intent();
                intent.putExtra("maNV",maNV);
                intent.putExtra("tenNV",tenNV);
                intent.putExtra("phongBan",phongban);
                setResult(1,intent);
                finish();
            }
        });
    }
}