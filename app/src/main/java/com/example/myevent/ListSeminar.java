package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSeminar extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<seminar> mSemData;
    private seminarAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recycler_view);

        // Get the appropriate column count.
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new GridLayoutManager(
                this, gridColumnCount));

        // Initialize the ArrayList that will contain the data.
        mSemData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new seminarAdapter(this, mSemData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

//


    }

    private void initializeData() {
        // Get the resources from the XML file.
        String[] judul = getResources()
                .getStringArray(R.array.sem_judul);
        String[] tempat = getResources()
                .getStringArray(R.array.sem_tempat);
        String[] tanggal = getResources()
                .getStringArray(R.array.sem_tanggal);
        String[] tiket = getResources()
                .getStringArray(R.array.sem_tiket);
        String[] penyelenggara = getResources()
                .getStringArray(R.array.sem_penyelenggara);
        String[] jam = getResources()
                .getStringArray(R.array.sem_jam);
        String[] bulan = getResources()
                .getStringArray(R.array.sem_bulan);
        String[] harga = getResources()
                .getStringArray(R.array.sem_harga);
        String[] tgl = getResources()
                .getStringArray(R.array.sem_tgl);
        TypedArray poster =
                getResources().obtainTypedArray(R.array.sem_poster);

        // Clear the existing data (to avoid duplication).
        mSemData.clear();

        // Create the ArrayList of Sports objects with the titles and
        // information about each sport.
        for (int i = 0; i < judul.length; i++) {
            mSemData.add(new seminar(judul[i], tempat[i],tanggal[i],tiket[i], penyelenggara[i],
                    bulan[i], tgl[i], jam[i], harga[i],
                    poster.getResourceId(i, 0)));
        }

        // Recycle the typed array.
        poster.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }



}


