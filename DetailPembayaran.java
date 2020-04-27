package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detailPembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembayaran);
    }

    public void Button(View view) {
    }

    public void Next(View view) {
        Intent e = new Intent(getApplicationContext(),uploadBukti.class);
        startActivity(e);
    }
}
