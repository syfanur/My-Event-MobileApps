package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerifikasiPembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_pembayaran);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new DialogInterface.OnClickListener() {
            public void onClick(View v) {


    }
}
