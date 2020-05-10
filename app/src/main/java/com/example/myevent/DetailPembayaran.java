package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myevent.OrderActivity.ALAMAT;
import static com.example.myevent.OrderActivity.NAMA;
import static com.example.myevent.OrderActivity.STATUS;
import static com.example.myevent.OrderActivity.TANGGAL;
import static com.example.myevent.OrderActivity.TOTAL;

public class DetailPembayaran extends AppCompatActivity {
    private FirebaseDatabase refDatabase;
    TextView pname, statustxt, alamattxt, tanggaltxt, totaltxt;
    Query DataRef;
    ArrayList<Orders>List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembayaran);
        Intent intent = getIntent();
        final String nama = intent.getStringExtra(NAMA);
        String alamat = intent.getStringExtra(ALAMAT);
        String tanggal = intent.getStringExtra(TANGGAL);
        String status = intent.getStringExtra(STATUS);
        String total = intent.getStringExtra(TOTAL);
        //DatabaseReference refDatabase = FirebaseDatabase.getInstance().getReference();
        //final DatabaseReference DataRef = refDatabase.child("Orders").child(nama);
        pname = findViewById(R.id.txtNama);
        statustxt = findViewById(R.id.txtStatus);
        alamattxt = findViewById(R.id.txtLokasi);
        tanggaltxt = findViewById(R.id.txtDate);
        totaltxt = findViewById(R.id.txtAmount);

        pname.setText("Nama: " +nama);
        statustxt.setText("Status: "+status);
        alamattxt.setText("Alamat: "+alamat);
        tanggaltxt.setText("Tanggal: "+tanggal);
        totaltxt.setText("Total :" +total);



    }

    public void Button(View view) {
        Intent e = new Intent(getApplicationContext(),OrderActivity.class);
        startActivity(e);
    }

    public void Next(View view) {
        Intent e = new Intent(getApplicationContext(),metodePembayaran.class);
        startActivity(e);
    }
}
