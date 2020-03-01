package com.example.myevent;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class eventListAdapter extends BaseAdapter {
    private Integer[] poster;
    private String[] judul, alamat, tanggal, tiket;
    private LayoutInflater inflter;
    private Context context;
    private ImageView Poster;
    private TextView Judul, Alamat, Tanggal, Tiket;

    public eventListAdapter(Integer[] poster, String[] judul, String[] alamat,
                            String[] tanggal, String[] tiket, Context context) {
        this.poster = poster;
        this.judul = judul;
        this.alamat = alamat;
        this.tanggal = tanggal;
        this.tiket = tiket;
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return judul.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.eventmusic, null);
        Poster = view.findViewById(R.id.poster);
        Judul = view.findViewById(R.id.judul);
        Alamat = view.findViewById(R.id.alamat);
        Tanggal = view.findViewById(R.id.tanggal);
        Tiket = view.findViewById(R.id.tiket);
        Poster.setImageResource(poster[position]);
        Judul.setText(judul[position]);
        Alamat.setText(alamat[position]);
        Tanggal.setText(tanggal[position]);
        Tiket.setText(tiket[position]);

        return view;
    }}
