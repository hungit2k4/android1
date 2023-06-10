package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asm1_ps29253.R;

public class CapNhatNV extends AppCompatActivity {
    EditText edtMaNVUpdate,edtTenNVUpdate,edtPhongBanUpdate;
    Button btnCapNhat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_nv);
        edtMaNVUpdate = findViewById(R.id.edtMaNVUpdate);
        edtTenNVUpdate= findViewById(R.id.edtTenNVUpdate);
        edtPhongBanUpdate = findViewById(R.id.edtPhongBanUpdate);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        Intent intent = getIntent();
        String maNV=intent.getStringExtra("maNV");
        edtMaNVUpdate.setText(maNV);
        edtMaNVUpdate.setEnabled(false);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNVUpdate.getText().toString();
                String tenNV = edtTenNVUpdate.getText().toString();
                String phongban= edtPhongBanUpdate.getText().toString();
                Intent intent =new Intent();
                intent.putExtra("maNV",maNV);
                intent.putExtra("tenNV",tenNV);
                intent.putExtra("phongBan",phongban);
                setResult(2,intent);
                finish();
            }
        });
    }
}