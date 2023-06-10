package com.example.thuchanhtrenlop.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thuchanhtrenlop.Adapters.ContactAdater;
import com.example.thuchanhtrenlop.Adapters.CourseAdapter;
import com.example.thuchanhtrenlop.Models.Contact;
import com.example.thuchanhtrenlop.R;
import com.example.thuchanhtrenlop.Models.Course;

import java.util.ArrayList;

public class demo27_5selection extends AppCompatActivity {
    Spinner spCourses;
    ArrayList <Course>list;
    CourseAdapter courseAdapter;

    ListView lvContact;
    ArrayList<Contact> list1;
    ContactAdater contactAdater;

    Button btnSave;
    EditText edtTen, edtSdt;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo275selection);
        spCourses= findViewById(R.id.spCourse);
        lvContact= findViewById(R.id.lvContact);
        btnSave = findViewById(R.id.btnSave);
        edtSdt= findViewById(R.id.edtSdt);
        edtTen = findViewById(R.id.edtTen);
    }
    @Override
    protected void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list.add(new Course(1, "Lập trình Android 1","AND101"));
        list.add(new Course(2, "Nhập môm lập trình ","COM104"));
        list.add(new Course(3, "Kỹ năng học tập","PDP1"));
        list.add(new Course(4, "Lập trình Java 1","MOB104"));
        list.add(new Course(5, "Lập trình Java 2","MOB1023"));
        courseAdapter = new CourseAdapter(list);
        spCourses.setAdapter(courseAdapter);
        spCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Course course = (Course) parent.getSelectedItem();
                Toast.makeText(demo27_5selection.this, "Bạn chọn: "+course.getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        list1 = new ArrayList<>();
        list1.add(new Contact(1,"hung","043493402"));
        list1.add(new Contact(2,"gfsd","04349322434"));
        contactAdater = new ContactAdater(list1);
        lvContact.setAdapter(contactAdater);

    }
}