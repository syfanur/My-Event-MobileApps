package com.example.android.rpldanandroid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ExhibitionViewHolder extends RecyclerView.ViewHolder {

    TextView mjudul, malamat, mtanggal, mtiket, mharga;
    ImageView mposter;
    View v;

    public ExhibitionViewHolder(@NonNull View view) {
        super(view);
        mjudul = view.findViewById(R.id.title_art);
        malamat = view.findViewById(R.id.alamat_art);
        mtanggal = view.findViewById(R.id.tanggal_art);
        mtiket = view.findViewById(R.id.tersedia_art);
        mharga = view.findViewById(R.id.biaya_art);
        mposter = view.findViewById(R.id.image_art);
        v = itemView;
    }
}


