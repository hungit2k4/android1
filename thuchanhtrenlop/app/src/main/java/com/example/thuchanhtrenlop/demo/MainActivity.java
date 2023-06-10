package com.example.thuchanhtrenlop.demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thuchanhtrenlop.R;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    TextView kq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(">>>>>>","onCreate running");
//        btn1 = findViewById(R.id.bnt1);
//        btn2 = findViewById(R.id.bnt2);
//        kq = findViewById(R.id.kq);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Intent intent = new Intent(MainActivity.this, manhinh2Activity.class);
//               intent.putExtra("message","chơi game bị điểm danh vắng");
//               startActivity(intent);
//            }
//        });
//       btn2.setOnClickListener(new View.OnClickListener() {
//           @Override
//          public void onClick(View v) {
//           Intent intent = new Intent(MainActivity.this, manhinh2Activity.class);
//            intent.putExtra("1to2","chao, ban ten gi?");
//           launcher.launch(intent);
//           }
//       });
    }
  ActivityResultLauncher<Intent> launcher = registerForActivityResult(
         new ActivityResultContracts.StartActivityForResult(),
         new ActivityResultCallback<ActivityResult>() {
    @Override
       public void onActivityResult(ActivityResult result) {
         Intent intent = result.getData();
        String mess = intent.getStringExtra("2to1");
          kq.setText(mess);
    }
   });
}