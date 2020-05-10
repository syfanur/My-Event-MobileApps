package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        TextView alamat = findViewById(R.id.alamat);
        TextView email = findViewById(R.id.editText11);
        CircleImageView pp = findViewById(R.id.imageView3);
        TextView nohp = findViewById(R.id.editText10);
        TextView namalengkap = findViewById(R.id.editText9);

        namalengkap.setText(Prevalent.currentOnlineUser.getName());
        alamat.setText(Prevalent.currentOnlineUser.getAddress());
        email.setText(Prevalent.currentOnlineUser.getEmail());
        nohp.setText(Prevalent.currentOnlineUser.getPhone());
        Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.b).into(pp);

    }

    public void editprofile(View view) {
        Intent ep = new Intent(Profil.this, Editprofile.class);
        startActivity(ep);
    }
}
