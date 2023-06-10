package com.example.thuchanhtrenlop.demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thuchanhtrenlop.Adapters.MayTinhAdapter;
import com.example.thuchanhtrenlop.MhThemMoiMayTinh;
import com.example.thuchanhtrenlop.Models.MayTinh;
import com.example.thuchanhtrenlop.R;

import java.util.ArrayList;

public class MHMayTinh extends AppCompatActivity {
    Button btnThemMT;
    ListView lvMayTinh;
    MayTinhAdapter mayTinhAdapter;
    ArrayList<MayTinh>list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhmay_tinh);
        btnThemMT = findViewById(R.id.btnThemMT);
        lvMayTinh = findViewById(R.id.lvMayTinh);
        list = new ArrayList<>();
        list.add(new MayTinh("MSI","100"));
        list.add(new MayTinh("DELL","150"));
        mayTinhAdapter=new MayTinhAdapter(list);
        lvMayTinh.setAdapter(mayTinhAdapter);
        btnThemMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MHMayTinh.this, MhThemMoiMayTinh.class);
                launcher.launch(intent);
            }
        });
    }
    ActivityResultLauncher <Intent> launcher =  registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String hang = intent.getStringExtra("hang");
                    String gia = intent.getStringExtra("gia");
                    list.add(new MayTinh(hang,gia));
                    lvMayTinh.deferNotifyDataSetChanged();
                }
            }
    );
}