package com.example.android.rpldanandroid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ExhibitionViewHolder extends RecyclerView.ViewHolder {

    TextView mtitle, malamat, mtanggal, mtersedia, mbiaya;
    ImageView mimageview;
    View v;

    public ExhibitionViewHolder(@NonNull View view) {
        super(view);
        mtitle = view.findViewById(R.id.title_art);
        malamat = view.findViewById(R.id.alamat_art);
        mtanggal = view.findViewById(R.id.tanggal_art);
        mtersedia = view.findViewById(R.id.tersedia_art);
        mbiaya = view.findViewById(R.id.biaya_art);
        mimageview = view.findViewById(R.id.image_art);
        v = itemView;
    }
}


