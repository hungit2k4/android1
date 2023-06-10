package com.example.demotutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {
    EditText edtMaNhanVien, edtTenNhanVien, edtPhongBan;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        edtPhongBan = findViewById(R.id.edtPhongBan);
        edtTenNhanVien = findViewById(R.id.edtTenNhanVien);
        edtMaNhanVien = findViewById(R.id.edtMaNhanVien);
        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đọc dữ liệu đã nhap
                String tenNV = edtTenNhanVien.getText().toString();
                String maNV = edtMaNhanVien.getText().toString();
                String phongBan = edtPhongBan.getText().toString();
                // gửi dữ liệu về màn hình danh sách
                Intent intent = new Intent();
                intent.putExtra("maNV", maNV);
                intent.putExtra("tenNV", tenNV);
                intent.putExtra("phongBan", phongBan);
                setResult(5, intent);
                // đóng màn hình thêm mới
                finish();
            }
        });
    }
}