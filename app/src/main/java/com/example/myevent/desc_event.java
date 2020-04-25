package com.example.myevent;

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


public class desc_event extends AppCompatActivity {


    /*Deklarasi variable*/
    Button btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String bandung = "-6.973700, 107.629233"; // koordinat


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_event);

        // Initialize the views.
        TextView Judul = findViewById(R.id.text_pameran);
        ImageView Poster = findViewById(R.id.view_bigevent);
        TextView Penyelenggara = findViewById(R.id.text_author);
        TextView Bulan = findViewById(R.id.text_bulan);
        TextView Tanggal = findViewById(R.id.text_tanggal);
        TextView Jam = findViewById(R.id.text_jam);
        TextView Harga = findViewById(R.id.harga);
        Button Alamat = findViewById(R.id.btn_navigasi);

        // Set the text from the Intent extra.
        Judul.setText(getIntent().getStringExtra("title"));
        Penyelenggara.setText(getIntent().getStringExtra("penyelenggara"));
        Tanggal.setText(getIntent().getStringExtra("tgl"));
        Bulan.setText(getIntent().getStringExtra("bulan"));
        Jam.setText(getIntent().getStringExtra("jam"));
        Alamat.setText(getIntent().getStringExtra("tempat"));
        Harga.setText(getIntent().getStringExtra("harga"));
        // Load the image using the Glide library and the Intent extra.
        Glide.with(this)
                .load(getIntent()
                        .getIntExtra("image_resource",0))
                .into(Poster);


        // menyamakan variable pada layout activity_main.xml
        btn_navigasi    = (Button) findViewById(R.id.btn_navigasi);

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
