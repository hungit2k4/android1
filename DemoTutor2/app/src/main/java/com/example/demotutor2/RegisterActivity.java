package com.example.demotutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtConfirmPassword;
    Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // quay về màn hình login
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this,
                            "Mật khẩu không khớp",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                // lưu vào database nhưng chưa có
                // lưu vào class UserModel
                UserModel.username = username;
                UserModel.password = password;
                Toast.makeText(RegisterActivity.this,
                        "Đăng ký thành công",
                        Toast.LENGTH_LONG).show();
                // đóng màn hình đăng ký
                finish();
            }
        });
    }
}