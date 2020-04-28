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

public class DetailEventTwo extends AppCompatActivity {

    Dialog mDialog;
    private ImageView mposter;
    TextView mjudul,malamat, mtanggal, mharga, mjam, mpenyelenggara, mdeskripsi;
    DatabaseReference ref, DataRef;
    public String id = "";
    private ImageButton cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event_two);

        mDialog = new Dialog(this);
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

