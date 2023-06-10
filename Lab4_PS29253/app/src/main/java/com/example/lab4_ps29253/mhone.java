package com.example.lab4_ps29253;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mhone extends AppCompatActivity {
    EditText edtMonAn;
    Button btnGui;
    TextView txtGia ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhone);
        edtMonAn = findViewById(R.id.edtMonAn);
        btnGui = findViewById(R.id.btnGui);
        txtGia = findViewById(R.id.txtGia);
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenMon = edtMonAn.getText().toString();
                Intent intent = new Intent(mhone.this, hmtwo.class);
                intent.putExtra("tenMon",tenMon);
                launcher.launch(intent);

            }
        });
    }
    ActivityResultLauncher<Intent> launcher= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    Integer giaTien = intent.getIntExtra("giaTien",0);
                    txtGia.setText(giaTien.toString());
                }
            }
    );
}