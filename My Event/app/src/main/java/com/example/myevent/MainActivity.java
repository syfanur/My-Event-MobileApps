package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.Query;

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
