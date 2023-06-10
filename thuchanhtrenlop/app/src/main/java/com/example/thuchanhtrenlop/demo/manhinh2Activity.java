package com.example.thuchanhtrenlop.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanhtrenlop.R;

public class manhinh2Activity extends AppCompatActivity {
    Button bt2, btn;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);
        Intent intent= getIntent();
//      String s = intent.getStringExtra("message");
        String s = intent.getStringExtra("1to2");

        Log.d(">>>>>>","onCreate running");
        bt2 = findViewById(R.id.btn2);
        tv2 = findViewById(R.id.text2);
        btn = findViewById(R.id.btn);
        tv2.setText(s);
    bt2.setOnClickListener(v -> finish());
      btn.setOnClickListener(v -> {
          Intent intent1 = new Intent();
           intent1.putExtra("2to1","chao, ban tm g?");
        setResult(1000, intent1);
     finish();
    });

    }
}