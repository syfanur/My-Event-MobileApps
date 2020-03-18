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

    public void welcome(View view) {
        Intent b = new Intent(getApplicationContext(),Welcome.class);
        startActivity(b);
    }

    public void transaksi(View view) {
        Intent c = new Intent(getApplicationContext(),transaksi1.class);
        startActivity(c);
    }

    public void setting(View view) {
        Intent d = new Intent(getApplicationContext(),Setting.class);
        startActivity(d);
    }

    public void list(View view) {
        Intent e = new Intent(getApplicationContext(),ListEvent.class);
        startActivity(e);
    }


    public void desc(View view) {
        Intent e = new Intent(getApplicationContext(),desc_event.class);
        startActivity(e);
    }
}
