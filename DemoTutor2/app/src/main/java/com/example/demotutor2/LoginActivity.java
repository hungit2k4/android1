package com.example.demotutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    CheckBox chkRemember;
    Button btnRegister, btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        chkRemember = findViewById(R.id.chkRemember);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển sang màn hình đăng ký
                Intent intent = new Intent(LoginActivity.this,
                        RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // thực hiện đăng nhập
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                Boolean remember = chkRemember.isChecked();
                if (username.equals(UserModel.username) &&
                password.equals(UserModel.password)){
                    // thông báo đăng nhập thành công
                    Toast.makeText(LoginActivity.this,
                            "Đăng nhập thành công",
                            Toast.LENGTH_LONG).show();
                    // chuyển sang màn hình home
                    Intent intent = new Intent(LoginActivity.this,
                            HomeActivity.class);
                    startActivity(intent);
                    // tắt màn hình login
                    finish();
                } else {
                    // thông báo đăng nhập không thành công
                    Toast.makeText(LoginActivity.this,
                            "Đăng nhập không thành công",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}