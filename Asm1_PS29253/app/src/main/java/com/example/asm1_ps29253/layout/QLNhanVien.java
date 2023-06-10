package com.example.asm1_ps29253.layout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asm1_ps29253.Adapter.NhanVienAdapter;
import com.example.asm1_ps29253.Models.NhanVien;
import com.example.asm1_ps29253.R;

import java.util.ArrayList;

public class QLNhanVien extends AppCompatActivity {
    Button btnThem;
    ListView lvNhanVien;
    NhanVienAdapter nhanVienAdapter;
    ArrayList<NhanVien> listNV =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlnhanvien);
        btnThem = findViewById(R.id.btnThem);
        lvNhanVien = findViewById(R.id.lvNhanVien);
        listNV.add(new NhanVien("NV001", "Nguyễn Văn B", "Hành chính"));
        listNV.add(new NhanVien("NV002","Nguyễn Văn C","Nhân sự"));
        nhanVienAdapter=new NhanVienAdapter(listNV);
        lvNhanVien.setAdapter(nhanVienAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLNhanVien.this, ThemNhanVien.class);
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
                    String maNV = intent.getStringExtra("maNV");
                    String tenNV = intent.getStringExtra("tenNV");
                    String phongBan = intent.getStringExtra("phongBan");
                    if (result.getResultCode()==1) {
                        listNV.add(new NhanVien(maNV, tenNV, phongBan));
                    }
                    if (result.getResultCode()==2){
                        for (NhanVien nv: listNV){
                            if (nv.getMaNV().equals(maNV)){
                                nv.setMaNV(maNV);
                                nv.setTenNV(tenNV);
                                nv.setPhongBan(phongBan);
                            }
                        }
                    }
                    nhanVienAdapter.notifyDataSetChanged();
                }
            }
    );
    public void UpdateNhanVien(NhanVien nhanVien){
        Intent intent =new Intent(QLNhanVien.this, CapNhatNV.class);
        intent.putExtra("maNV",nhanVien.getMaNV());
        intent.putExtra("tenNV",nhanVien.getTenNV());
        intent.putExtra("phongBan",nhanVien.getPhongBan());
        launcher.launch(intent);
    }
}