package com.example.myevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MusikViewHolder  extends RecyclerView.ViewHolder {

    public TextView judul, tempat, tanggal, tiket, harga;
    private ImageView poster;

    public MusikViewHolder(View itemView) {
        super(itemView);
        judul = itemView.findViewById(R.id.judul);
        tempat = itemView.findViewById(R.id.alamat);
        poster = itemView.findViewById(R.id.poster);
        tanggal = itemView.findViewById(R.id.tanggal);
        tiket = itemView.findViewById(R.id.tiket);

    }

    public void bindToMusik(Musik musik, View.OnClickListener onClickListener){
        judul.setText(musik.title);
        tempat.setText(musik.info);
        tanggal.setText(musik.tanggal);
        tiket.setText(musik.tiket);
        poster.setImageResource(musik.poster);
    }
}