package com.example.myevent;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailEvent extends AppCompatActivity {

    Dialog mDialog;
    ImageView mposter;
    TextView mjudul,malamat, mtanggal, mharga, mjam, mpenyelenggara, mdeskripsi;
    ImageButton attend;

    FirebaseRecyclerOptions<Event> options;
    FirebaseRecyclerAdapter<Event, ExhibitionViewHolder> adapter;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        mjudul = findViewById(R.id.text_pameran);
        malamat = findViewById(R.id.text_lokasi);
        mtanggal = findViewById(R.id.text_bulan);
        mharga = findViewById(R.id.harga);
        mposter = findViewById(R.id.view_bigevent);
        mjam = findViewById(R.id.text_jam);
        mpenyelenggara = findViewById(R.id.text_author);
        mdeskripsi = findViewById(R.id.text_deskripsi1);
        attend = findViewById(R.id.attend);

        mDialog = new Dialog(this);

        ref = FirebaseDatabase.getInstance().getReference().child("Exhibition");

        String Key = getIntent().getStringExtra("Key");

        ref.child(Key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String Judul = dataSnapshot.child("Judul").getValue().toString();
                    String Alamat = dataSnapshot.child("Alamat").getValue().toString();
                    String Tanggal = dataSnapshot.child("Tanggal").getValue().toString();
                    String Jam = dataSnapshot.child("Jam").getValue().toString();
                    String Harga = dataSnapshot.child("Harga").getValue().toString();
                    String Penyelenggara = dataSnapshot.child("Penyelenggara").getValue().toString();
                    String Deskripsi = dataSnapshot.child("Deskripsi").getValue().toString();
                    String Poster = dataSnapshot.child("Poster").getValue().toString();

                    mjudul.setText(Judul);
                    malamat.setText(Alamat);
                    mtanggal.setText(Tanggal);
                    mjam.setText(Jam + "| Available");
                    mharga.setText(Harga);
                    mpenyelenggara.setText(Penyelenggara);
                    mdeskripsi.setText(Deskripsi);
                    Picasso.get().load(Poster).into(mposter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


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


    public void ButtonHome(View view) {
        startActivity(new Intent(DetailEvent.this, Exhibiton.class));
    }

    public void ButtonYes(View view) {
        Intent e = new Intent(DetailEvent.this, Exhibiton.class);
        startActivity(e);
        Toast.makeText(DetailEvent.this, "You Attend This Event", Toast.LENGTH_SHORT).show();
        }

    public void ButtonNo(View view) {
        Intent n = new Intent(DetailEvent.this, Exhibiton.class);
        startActivity(n);
        Toast.makeText(DetailEvent.this, "You Cancel This Event", Toast.LENGTH_SHORT).show();
    }
}

