package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Searching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
    }

    public void LaunchHasilSearching(View view) {
        Intent intent = new Intent(this, HasilSearching.class);
        startActivity(intent);
    }
}