package com.example.phu_dao_va_on_tap.Phudao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.phu_dao_va_on_tap.Data.TaiKhoan;
import com.example.phu_dao_va_on_tap.R;
import com.google.android.material.textfield.TextInputEditText;

public class Dangky extends AppCompatActivity {
    TextInputEditText edtUserDK,edtPassDK,edtConfirmPass;
    Button btnDangNhapDK,btnDangKyDk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        edtUserDK = findViewById(R.id.edtUserDK);
        edtPassDK = findViewById(R.id.edtPassDK);
        edtConfirmPass = findViewById(R.id.edtConfirmPass);
        btnDangKyDk = findViewById(R.id.btnDangKyDk);
        btnDangNhapDK = findViewById(R.id.btnDangNhapDK);
        btnDangNhapDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnDangKyDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = edtPassDK.getText().toString();
                String confirmPass = edtConfirmPass.getText().toString();
                if (!pass.equals(confirmPass)){
                    Toast.makeText(Dangky.this,"Mật khẩu không khớp!", Toast.LENGTH_LONG).show();
                    return;
                }
                TaiKhoan.pass =pass;
                TaiKhoan.user = edtUserDK.getText().toString();
                Toast.makeText(Dangky.this, "Đăng ký thành công!",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}