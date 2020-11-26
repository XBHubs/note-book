package com.example.mynoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;




public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input , pages_input;
    Button add_button;
    TextView ShowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        SharedPreferences.Editor editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        SharedPreferences pref =getSharedPreferences("data",MODE_PRIVATE);
        String s=pref.getString("author"," XB ");
        title_input = (EditText)findViewById(R.id.title_input);
        author_input=(EditText)findViewById(R.id.author_input);
        author_input.setText(s);
        pages_input=(EditText)findViewById(R.id.pages_input);
        add_button=(Button)findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString(),
                        author_input.getText().toString(),
                        pages_input.getText().toString());
                finish();
            }
        });





    }  String getTime() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}