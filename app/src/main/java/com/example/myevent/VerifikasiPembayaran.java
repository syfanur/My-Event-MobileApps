package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerifikasiPembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_pembayaran);


        setTitle("Metode Pembayaran");
    }
    public void clickList(View view) {
        startActivity(new Intent(this, metodePembayaran.class));


    }
}
