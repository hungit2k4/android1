package com.example.asm1_ps29253.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asm1_ps29253.Account;
import com.example.asm1_ps29253.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Dangky extends AppCompatActivity {
    TextInputEditText edtConfirmPass,edtPassDK,edtUserDK;
    Button btnDangNhapDK,btnBack;

 public static   ArrayList<Account> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        edtConfirmPass = findViewById(R.id.edtConfirmPass);
        edtPassDK = findViewById(R.id.edtPassDK);
        edtUserDK = findViewById(R.id.edtUserDK);
        btnDangNhapDK = findViewById(R.id.btnDangNhapDK);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnDangNhapDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean check= false;
                String user = edtUserDK.getText().toString();
                String ktUserAndPass ="^(?=.*\\w)(?=.*\\d)[A-Za-z\\d]{8,}$";
                if(user.matches(ktUserAndPass)==false){
                    edtUserDK.setError("Username không hợp lệ!");
                    return;
                }
                String pass = edtPassDK.getText().toString();
                if(pass.matches(ktUserAndPass)==false){
                    edtPassDK.setError("Password không hợp lệ!");
                    return;
                }
                if (!pass.equals(edtConfirmPass.getText().toString())){
                    Toast.makeText(Dangky.this,"Mật khẩu không khớp!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(list.size()>0) {
                    for (Account x: list) {
                        if (x.getUser().equals(user)) {
                            Toast.makeText(Dangky.this, "Username đã tồn tại!", Toast.LENGTH_LONG).show();
                            check=true;
                            break;
                        }else {
                            check=false;
                        }
                    }
                }
                if (check==false){
                    list.add(new Account(user,pass));
                Toast.makeText(Dangky.this,"Đăng ký thành công!", Toast.LENGTH_LONG).show();
                finish();
                }
            }
        });
    }
}