package com.example.roomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {

    RadioButton rb, rb1;
    CheckBox telugu, hindi, english;
    StringBuilder s1;
    EditText et1, et2, et3, et4;
    Spinner sp;
    String dept, gender, uid, uname, umail, unum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        //tablegroup = findViewById(R.id.tablegroup);

        rb = findViewById(R.id.male);
        rb1 = findViewById(R.id.female);


        telugu = findViewById(R.id.telugu);
        english = findViewById(R.id.english);
        hindi = findViewById(R.id.hindi);


        et1 = findViewById(R.id.userID);
        et2 = findViewById(R.id.username);
        et3 = findViewById(R.id.usermail);
        et4 = findViewById(R.id.userphone);

        sp = findViewById(R.id.dept);

    }

    public void submit(View view) {
        uid = et1.getText().toString();
        uname = et2.getText().toString();
        umail = et3.getText().toString();
        unum = et4.getText().toString();

        if (rb.isChecked()) {
            gender = rb.getText().toString();
        }
        if (rb1.isChecked()) {
            gender = rb1.getText().toString();
        }

        dept = sp.getSelectedItem().toString();
        s1 = new StringBuilder();
        if (telugu.isChecked()) {
            s1.append(telugu.getText().toString());
        }
        if (english.isChecked()) {
            s1.append(english.getText().toString());
        }
        if (hindi.isChecked()) {
            s1.append(hindi.getText().toString());
        }
        Student student = new Student();
        student.setName(uname);
        student.setStudentID(uid);
        student.setMailID(umail);
        student.setPhoneNumber(unum);
        student.setGender(gender);
        student.setDepertment(dept);
        student.setLanguage(s1.toString());
        MainActivity.myViewModel1.insertStudent(student);
        finish();
    }
}