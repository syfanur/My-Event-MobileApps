package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class desc_event extends AppCompatActivity {

    private ImageView mposter;
    TextView mjudul, mtanggal, mharga, malamat, mjam, mpenyelenggara, mdeskripsi;
    DatabaseReference ref;


    /*Deklarasi variable*/
    TextView btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String bandung = "-6.973700, 107.629233"; // koordinat


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_event);

        mjudul = findViewById(R.id.text_pameran);
        malamat = findViewById(R.id.btn_navigasi);
        mtanggal = findViewById(R.id.text_bulan);
        mharga = findViewById(R.id.harga);
        mposter = findViewById(R.id.view_bigevent);
        mjam = findViewById(R.id.text_jam);
        mpenyelenggara = findViewById(R.id.text_author);
        mdeskripsi = findViewById(R.id.text_deskripsi);
        ref = FirebaseDatabase.getInstance().getReference().child("Musik");

        String MusikKey = getIntent().getStringExtra("MusikKey");

        ref.child(MusikKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String judul = dataSnapshot.child("Judul").getValue().toString();
                    String alamat = dataSnapshot.child("Alamat").getValue().toString();
                    String tanggal = dataSnapshot.child("Tanggal").getValue().toString();
                    String harga = dataSnapshot.child("Harga").getValue().toString();
                    String jam = dataSnapshot.child("Jam").getValue().toString();
                    String penyelenggara = dataSnapshot.child("Penyelenggara").getValue().toString();
                    String deskripsi = dataSnapshot.child("Deskripsi").getValue().toString();
                    String poster = dataSnapshot.child("Poster").getValue().toString();


                    Picasso.get().load(poster).into(mposter);
                    mjudul.setText(judul);
                    malamat.setText(alamat);
                    mtanggal.setText(tanggal);
                    mjam.setText(jam);
                    mpenyelenggara.setText("By "+penyelenggara);
                    mdeskripsi.setText(deskripsi);
                    mharga.setText("Rp. "+harga);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // menyamakan variable pada layout activity_main.xml
        btn_navigasi    = (TextView) findViewById(R.id.btn_navigasi);

        // tombol untuk menjalankan navigasi goolge maps intents
        btn_navigasi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + bandung);

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(goolgeMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(desc_event.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public void attend(View view) {
        Intent a = new Intent(getApplicationContext(),transaksi1.class);
        startActivity(a);
    }



}
