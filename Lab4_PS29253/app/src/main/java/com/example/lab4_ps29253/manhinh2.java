package com.example.lab4_ps29253;

import static android.nfc.NfcAdapter.EXTRA_DATA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class manhinh2 extends AppCompatActivity {
    TextView txtNoidung;
    EditText edtNoidung;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);

        txtNoidung = findViewById(R.id.noidungmh2);
        edtNoidung = findViewById(R.id.edtmh2);
        btnGui = findViewById(R.id.mh2gui);

        // Nhận nội dung từ màn hình 1
        Intent intent = getIntent();
        String nd = intent.getStringExtra("1to2");
        txtNoidung.setText(nd);

        // Sự kiện khi bấm nút "gui"
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nd = edtNoidung.getText().toString();

                // Khởi tạo intent để trả kết quả về cho màn hình 1
                Intent intent = new Intent();
                intent.putExtra("2to1", nd);

                // Đặt kết quả là RESULT_OK và trả về intent chứa kết quả cho màn hình 1
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
