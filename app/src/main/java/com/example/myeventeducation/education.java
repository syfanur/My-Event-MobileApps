package com.example.myeventeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
    }

    public void seminar(View view) {
        Intent a = new Intent(getApplicationContext(),seminar.class);
        startActivity(a);
    }

    public void workshop(View view) {
        Intent b = new Intent(getApplicationContext(),workshop.class);
        startActivity(b);
    }
}
