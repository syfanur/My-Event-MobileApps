package com.example.android.tubesbagianiyan;

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

    public void ButtonArt(View view) {
        Intent art = new Intent(MainActivity.this, Exhibiton.class);
        startActivity(art);
    }
}
