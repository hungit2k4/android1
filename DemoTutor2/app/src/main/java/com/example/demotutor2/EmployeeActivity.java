package com.example.demotutor2;

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

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    Button btnAddEmployee;
    ListView lvEmployee;

    ArrayList<NhanVien> list;
    NhanVienAdapter nhanVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        lvEmployee = findViewById(R.id.lvEmployee);

        list = new ArrayList<>();
        list.add(new NhanVien("NV01", "Nguyen Van A", "Hanh Chinh"));
        list.add(new NhanVien("NV02", "Nguyen Van C", "Nhan Su"));
        list.add(new NhanVien("NV03", "Nguyen Van D", "Ke Toan"));
        nhanVienAdapter = new NhanVienAdapter(list);
        lvEmployee.setAdapter(nhanVienAdapter);

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mở màn hình thêm mới
                // nhận thông tin đã nhập từ màn hình thêm mới
                Intent intent = new Intent(EmployeeActivity.this, AddNewActivity.class);
                launcher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // nhận thông tin từ màn hình thêm mới gửi về
                    Intent intent = result.getData();
                    String tenNV = intent.getStringExtra("tenNV");
                    String maNV = intent.getStringExtra("maNV");
                    String phongBan = intent.getStringExtra("phongBan");
                    if (result.getResultCode() == 5) {
                        // thêm mới
                        // tạo mới 1 nhân viên
                        NhanVien nhanVien = new NhanVien(maNV, tenNV, phongBan);
                        // thêm nhân viên vào danh sách
                        list.add(nhanVien);
                    }
                    else if(result.getResultCode() == 15) {
                        // cập nhật
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getMaNV().equals(maNV)){
                                list.get(i).setPhongBan(phongBan);
                                list.get(i).setHoTen(tenNV);
                                break;
                            }
                        }
                    }
                    // thông báo danh sách cập nhật
                    nhanVienAdapter.notifyDataSetChanged();
                }
            }
    );

    public void capNhatNhanVien(NhanVien nhanVien) {
        Intent intent = new Intent(EmployeeActivity.this, UpdateActivity.class);
        intent.putExtra("tenNV", nhanVien.getHoTen());
        intent.putExtra("maNV", nhanVien.getMaNV());
        intent.putExtra("phongBan", nhanVien.getPhongBan());
        launcher.launch(intent);
    }
}