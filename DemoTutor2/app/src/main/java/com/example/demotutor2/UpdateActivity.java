package com.example.demotutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText edtMaNhanVienCapNhat, edtTenNhanVienCapNhat, edtPhongBanCapNhat;
    Button btnLuuCapNhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edtMaNhanVienCapNhat = findViewById(R.id.edtMaNhanVienCapNhat);
        edtTenNhanVienCapNhat = findViewById(R.id.edtTenNhanVienCapNhat);
        edtPhongBanCapNhat = findViewById(R.id.edtPhongBanCapNhat);
        btnLuuCapNhat = findViewById(R.id.btnLuuCapNhat);

        // nhận thông tin từ màn hình danh sách gửi qua
        Intent intent = getIntent();
        String maNV = intent.getStringExtra("maNV");
        String tenNV = intent.getStringExtra("tenNV");
        String phongBan = intent.getStringExtra("phongBan");
        // hiển thị lên màn hình
        edtMaNhanVienCapNhat.setText(maNV);
        edtTenNhanVienCapNhat.setText(tenNV);
        edtPhongBanCapNhat.setText(phongBan);
        // không cho sửa mã nhân viên
        edtMaNhanVienCapNhat.setEnabled(false);
        // sự kiện cập nhật
        btnLuuCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đọc dữ liệu đã nhap
                String tenNV = edtTenNhanVienCapNhat.getText().toString();
                String maNV = edtMaNhanVienCapNhat.getText().toString();
                String phongBan = edtPhongBanCapNhat.getText().toString();
                // gửi dữ liệu về màn hình danh sách
                Intent intent = new Intent();
                intent.putExtra("maNV", maNV);
                intent.putExtra("tenNV", tenNV);
                intent.putExtra("phongBan", phongBan);
                // code 15: cập nhật
                setResult(15, intent);
                // đóng màn hình thêm mới
                finish();
            }
        });
    }
}