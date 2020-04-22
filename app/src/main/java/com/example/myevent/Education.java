package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_education);
    }


    public void seminar(View view) {
        Intent sem = new Intent(getApplicationContext(),ListSeminar.class);
        startActivity(sem);
    }


    public void workshop(View view) {
        Intent sem = new Intent(getApplicationContext(),ListWorkshop.class);
        startActivity(sem);
    }
}
