package com.example.listdata;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvJudul;
    TextView tvAlamat;
    TextView tvTanggal;
    TextView tvHarga;
    View v;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.poster);
        tvJudul=itemView.findViewById(R.id.judul);
        tvAlamat=itemView.findViewById(R.id.alamat);
        tvTanggal=itemView.findViewById(R.id.tanggal);
        tvHarga=itemView.findViewById(R.id.harga);
        v=itemView;
    }
}
