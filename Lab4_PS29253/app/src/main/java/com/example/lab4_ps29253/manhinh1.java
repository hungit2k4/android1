package com.example.lab4_ps29253;

import static android.nfc.NfcAdapter.EXTRA_DATA;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class manhinh1 extends AppCompatActivity {
    TextView txtNoidung;
    EditText edtNoidung;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh1);
        txtNoidung = findViewById(R.id.noidungmh1);
        edtNoidung = findViewById(R.id.edtmh1);
        btnGui = findViewById(R.id.mh1gui);

        // Sự kiện khi bấm nút "gui"
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nd = edtNoidung.getText().toString();

                // Khởi tạo intent để mở màn hình 2
                Intent intent = new Intent(manhinh1.this, manhinh2.class);

                // Truyền nội dung của EditText từ màn hình 1 sang màn hình 2
                intent.putExtra("1to2", nd);

                // Khởi động màn hình 2 và chờ kết quả trả về
                startActivityForResult(intent, 1);
            }
        });
    }

    // Nhận kết quả trả về từ màn hình 2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra requestCode và resultCode để đảm bảo rằng kết quả trả về đúng
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Lấy dữ liệu từ intent trả về và hiển thị trên TextView trên màn hình 1
            String nd = data.getStringExtra("2to1");
            txtNoidung.setText(nd);
        }
    }
}
