package com.example.myevent;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailEventTwo extends AppCompatActivity {

    Dialog mDialog;
    ImageView mposter;
    TextView mjudul, malamat, mtanggal, mharga, mjam, mpenyelenggara, mdeskripsi;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event_two);

        mDialog = new Dialog(this);

        mjudul = findViewById(R.id.text_pameran2);
        malamat = findViewById(R.id.text_lokasi2);
        mtanggal = findViewById(R.id.text_bulan2);
        mharga = findViewById(R.id.harga2);
        mposter = findViewById(R.id.view_bigevent2);
        mjam = findViewById(R.id.text_jam2);
        mpenyelenggara = findViewById(R.id.text_author2);
        mdeskripsi = findViewById(R.id.text_deskripsi2);

        ref = FirebaseDatabase.getInstance().getReference().child("Exhibition");

        String Key = getIntent().getStringExtra("Key");

        ref.child(Key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String Judul = dataSnapshot.child("Judul").getValue().toString();


                    String Poster = dataSnapshot.child("Poster").getValue().toString();

                    mjudul.setText(Judul);
                    Picasso.get().load(Poster).into(mposter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void ButtonCancel(View view) {
        mDialog.setContentView(R.layout.activity_popup_cancel_event);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    public void ButtonYesCancel(View view) {
        Intent yc = new Intent(DetailEventTwo.this, Exhibiton.class);
        startActivity(yc);
    }

    public void ButtonNoCancel(View view) {
        mDialog.cancel();
    }

    public void ButtonBack(View view) {
        Intent bck = new Intent(DetailEventTwo.this, Exhibiton.class);
        startActivity(bck);
    }

}
