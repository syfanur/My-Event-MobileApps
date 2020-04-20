package com.example.android.tubesbagianiyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Exhibiton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibiton);
        ImageButton button = findViewById(R.id.bt_next3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exhibiton.this, DetailEvent.class);
                startActivity(intent);
            }
        });
    }

    public void ButtonClose(View view) {
        startActivity(new Intent(Exhibiton.this, MainActivity.class));
    }
}
