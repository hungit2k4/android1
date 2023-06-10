package com.example.lab2_ps29253;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        TextView txtThongTin = findViewById(R.id.txtThongTin);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtMaSo = findViewById(R.id.edtMaSo);
        EditText edtTuoi = findViewById(R.id.edtTuoi);
        RadioButton rdoMale = findViewById(R.id.rdoMale);
        RadioButton rdoFemale = findViewById(R.id.rdoFemale);
        CheckBox chkDaBong = findViewById(R.id.chkDabong);
        CheckBox chkGame = findViewById(R.id.chkGame);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String nameRegex ="^[a-zA-z ]+$";
                if(!name.matches(nameRegex)){
                    Toast.makeText(Bai2Activity.this,"Họ ten không đúng",Toast.LENGTH_LONG).show();
                    return;
                }
                String idRegex ="^PS+\\d{5}$";
                String id = edtMaSo.getText().toString();
                if(!id.matches(idRegex)){
                    Toast.makeText(Bai2Activity.this,"Mã sinh viên không đúng",Toast.LENGTH_LONG).show();
                    return;
                }

                Integer age = Integer.valueOf(edtTuoi.getText().toString());

                String gender = rdoMale.isChecked()
                        ? rdoMale.getText().toString()
                        :rdoFemale.isChecked()
                        ?rdoFemale.getText().toString()
                        :"Chưa lựa chọn giới tính";
                String soThich = chkDaBong.isChecked() && chkGame.isChecked()
                        ?"Đá bóng và chơi game"
                        :chkDaBong.isChecked()
                        ? "Đá bóng"
                        :chkGame.isChecked()
                        ?"Game"
                        :"Không thích gì cả";
                txtThongTin.setText("Tôi tên: "+name+"\n"
                                    +"MSSV: "+id+"\n"
                                    +"Tuổi: "+age+"\n"
                                    +"Giới tính: "+gender+"\n"
                                    +"Sở thích: "+soThich);
            }
        });
        }

}