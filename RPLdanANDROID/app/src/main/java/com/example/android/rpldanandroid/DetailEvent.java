package com.example.android.rpldanandroid;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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

public class DetailEvent extends AppCompatActivity {

    Dialog mDialog;
    private ImageView mposter;
    TextView mjudul,malamat, mtanggal, mharga, mjam, mpenyelenggara, mdeskripsi;
    DatabaseReference ref, DataRef;
    public String id = "";
    private ImageButton attend;
    private static final  String TAG = "Detail Event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        Log.d(TAG, "onCreate: started.");

        mDialog = new Dialog(this);

        id = getIntent().getStringExtra("pid");
        mjudul = findViewById(R.id.text_pameran);
        malamat = findViewById(R.id.text_lokasi);
        mtanggal = findViewById(R.id.text_bulan);
        mharga = findViewById(R.id.harga);
        mposter = findViewById(R.id.view_bigevent);
        mjam = findViewById(R.id.text_jam);
        mpenyelenggara = findViewById(R.id.text_author);
        mdeskripsi = findViewById(R.id.text_deskripsi1);
        attend = findViewById(R.id.attend);

        getProductDetails(id);

        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CancelDetailEvent();
            }
        });
    }

    private void CancelDetailEvent() {
        mDialog.setContentView(R.layout.activity_popup_going_event);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    private void getProductDetails(String id) {
        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Exhibition");

        productsRef.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Event exhibition = dataSnapshot.getValue(Event.class);

                    Picasso.get().load(exhibition.getPoster()).into(mposter);
                    mjudul.setText(exhibition.getJudul());
                    malamat.setText(exhibition.getAlamat());
                    mtanggal.setText(exhibition.getTanggal());
                    mjam.setText(exhibition.getJam());
                    mpenyelenggara.setText(exhibition.getPenyelenggara());
                    mdeskripsi.setText(exhibition.getDeskripsi());
                    mharga.setText(exhibition.getHarga());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ButtonHome(View view) {
        startActivity(new Intent(DetailEvent.this, Exhibiton.class));
    }

    public void ButtonYes(View view) {
        Intent y = new Intent(DetailEvent.this, DetailEventTwo.class);
        startActivity(y);
    }

    public void ButtonNo(View view) {
        Intent n = new Intent(DetailEvent.this, Exhibiton.class);
        startActivity(n);
    }
}

