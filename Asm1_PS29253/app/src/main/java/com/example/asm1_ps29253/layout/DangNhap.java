package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.asm1_ps29253.Account;
import com.example.asm1_ps29253.R;
import com.google.android.material.textfield.TextInputEditText;

public class DangNhap extends AppCompatActivity {
    TextInputEditText edtUser,edtPass;
    CheckBox checkBox ;
    Button btnDangNhap,btnDngKy;
    Account account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        edtPass = findViewById(R.id.edtPass);
        edtUser = findViewById(R.id.edtUser);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDngKy = findViewById(R.id.btnDngKy);
        checkBox = findViewById(R.id.checkBox);
        Boolean remember = checkBox.isChecked();
        btnDngKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, Dangky.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean check=false;
                String ktUserAndPass ="^(?=.*\\w)(?=.*\\d)[A-Za-z\\d]{8,}$";
                for (Account x: Dangky.list) {
                    if(edtUser.getText().toString().matches(ktUserAndPass)==false){
                        edtUser.setError("Username không hợp lệ!");
                        return;
                    }
                    if(edtPass.getText().toString().matches(ktUserAndPass)==false){
                        edtPass.setError("Password không hợp lệ!");
                        return;
                    }
                    if(remember){

                    }
                    if (x.getUser().equals(edtUser.getText().toString())
                            && x.getPass().equals(edtPass.getText().toString())){
                        Toast.makeText(DangNhap.this,"Đăng nhập thành công!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DangNhap.this, trangchu.class);
                        startActivity(intent);
                        check=true;
                        break;
                    }
                }
                if (check==false) {
                    Toast.makeText(DangNhap.this, "User hoặc password không đúng!", Toast.LENGTH_LONG).show();
                }
                }
        });
    }
}