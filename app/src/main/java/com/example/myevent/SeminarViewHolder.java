package com.example.myevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeminarViewHolder extends RecyclerView.ViewHolder {
    TextView mjudul, malamat, mtanggal, mharga;
    ImageView mposter;
    View v;

    public SeminarViewHolder(@NonNull View itemView) {
        super(itemView);
        mjudul = itemView.findViewById(R.id.judul);
        malamat = itemView.findViewById(R.id.alamat);
        mtanggal = itemView.findViewById(R.id.tanggal);
        mharga = itemView.findViewById(R.id.harga);
        mposter = itemView.findViewById(R.id.poster);
        v = itemView;

    }

}
