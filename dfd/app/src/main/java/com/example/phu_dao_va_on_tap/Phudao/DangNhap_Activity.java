package com.example.phu_dao_va_on_tap.Phudao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.phu_dao_va_on_tap.Data.TaiKhoan;
import com.example.phu_dao_va_on_tap.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;

public class DangNhap_Activity extends AppCompatActivity {
    TextInputEditText edtUser, edtPass;
    CheckBox chkRemember;
    Button btnDangNhap, btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_activity);
        edtUser = findViewById(R.id.edtUserDN);
        edtPass = findViewById(R.id.edtPassDN);
        btnDangNhap = findViewById(R.id.btnDangNhapDN);
        btnDangKy = findViewById(R.id.btnDangKyDN);
        chkRemember = findViewById(R.id.chkRemember);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap_Activity.this, Dangky.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (user.equals(TaiKhoan.user) && pass.equals(TaiKhoan.pass)){
                    Toast.makeText(DangNhap_Activity.this,"Đăng nhập thành công!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DangNhap_Activity.this,TrangChu.class );
                    if (chkRemember.isChecked()){
                        Toast.makeText(DangNhap_Activity.this,"Mật khẩu đã được ghi nhớ!", Toast.LENGTH_LONG).show();
                    }
                    startActivity(intent);
                    return;
                }
                Toast.makeText(DangNhap_Activity.this,"Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_LONG).show();
            }
        });
    }
}