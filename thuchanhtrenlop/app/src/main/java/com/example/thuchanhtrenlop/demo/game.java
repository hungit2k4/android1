package com.example.thuchanhtrenlop.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.thuchanhtrenlop.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class game extends AppCompatActivity {
    TextView score, best, soCau, question;
    Button dapAn1, dapAn2,dapAn3;
    Integer diem, markMax, soCauNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        score = findViewById(R.id.score);
        best = findViewById(R.id.best);
        soCau = findViewById(R.id.socau);
        question= findViewById(R.id.question);
        dapAn1 = findViewById(R.id.dapan1);
        dapAn2 = findViewById(R.id.dapan2);
        dapAn3 = findViewById(R.id.dapan3);
        diem=0;
        soCauNow=0;
        score.setText("Score: "+diem);
        best.setText("Best: "+markMax);
        soCau.setText(soCauNow+" ");
        initGame();
    }
    public void initGame(){
        Long number1 = Math.round(Math.random() * 5)+1;
        Long number2 = Math.round(Math.random() * 5)+1;
        Long KQ= number1+number2;
        Long fakeKQ1 = Math.round(Math.random() * 10);
        while (KQ==fakeKQ1){
            fakeKQ1 = Math.round(Math.random() * 10);
        }
        Long fakeKQ2 = Math.round(Math.random() * 10);
        while (fakeKQ2==fakeKQ1||fakeKQ2==KQ){
            fakeKQ2 = Math.round(Math.random() * 10);
        }
        question.setText(number1+"+"+number2+"= ?");
        ArrayList<Long> list = new ArrayList<>();
        list.add(KQ);
        list.add(fakeKQ1);
        list.add(fakeKQ2);
        Collections.shuffle(list);
    }
}