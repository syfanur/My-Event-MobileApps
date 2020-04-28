package com.example.listdata;

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

//import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.listdata.Event;
import com.example.listdata.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class Deskripsi extends AppCompatActivity {

    private ImageView mposter;
    TextView mjudul, mtanggal, mharga, malamat, mjam, mpenyelenggara, mdeskripsi;
    private ElegantNumberButton numberButton;
    DatabaseReference ref, DataRef;
    private String id = "";
    private Button addcart;


    /*Deklarasi variable*/
    TextView btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String bandung = "-6.973700, 107.629233"; // koordinat




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        id = getIntent().getStringExtra("pid");

        mjudul = findViewById(R.id.text_pameran);
        malamat = findViewById(R.id.btn_navigasi);
        mtanggal = findViewById(R.id.text_bulan);
        mharga = findViewById(R.id.harga);
        mposter = findViewById(R.id.view_bigevent);
        mjam = findViewById(R.id.text_jam);
        mpenyelenggara = findViewById(R.id.text_author);
        mdeskripsi = findViewById(R.id.text_deskripsi);
        addcart = findViewById(R.id.addcart);
        numberButton = findViewById(R.id.number_btn);

        getProductDetails(id);


        addcart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addingToCartList();
            }
        });


        // menyamakan variable pada layout activity_main.xml
        btn_navigasi = (TextView) findViewById(R.id.btn_navigasi);

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
                    Toast.makeText(Deskripsi.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    private void getProductDetails(String id) {
        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Event");

        productsRef.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Event musik = dataSnapshot.getValue(Event.class);

                    Picasso.get().load(musik.getPoster()).into(mposter);
                    mjudul.setText(musik.getJudul());
                    malamat.setText(musik.getAlamat());
                    mtanggal.setText(musik.getTanggal());
                    mjam.setText(musik.getJam());
                    mpenyelenggara.setText("By " + musik.getPenyelenggara());
                    mdeskripsi.setText(musik.getDeskripsi());
                    mharga.setText(musik.getHarga());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentTime = currentDate.format(calForDate.getTime());

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("CartList");
        final HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("pid", id);
        cartMap.put("pname", mjudul.getText().toString());
        cartMap.put("price", mharga.getText().toString());
        cartMap.put("date", saveCurrentDate);
        cartMap.put("time", saveCurrentTime);
        cartMap.put("quantity", numberButton.getNumber());

//        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone()).child("Products").child(id)
//                .updateChildren(cartMap);
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(Deskripsi.this, "add to cart", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent (Deskripsi.this, HomeActivity.class);
//                            startActivity(intent);
//
//                        }
//                    }
//                });


    }
}
