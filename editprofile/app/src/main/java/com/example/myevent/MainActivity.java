package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LaunchFilterActivity(View view) {
        Intent intent = new Intent(this, Filter.class);
        startActivity(intent);
    }

    public void LauchSearching(View view) {
        Intent intent = new Intent(this, Searching.class);
        startActivity(intent);
    }
}
