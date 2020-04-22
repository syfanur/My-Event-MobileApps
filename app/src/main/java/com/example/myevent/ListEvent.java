package com.example.myevent;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ListEvent extends AppCompatActivity {

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<Musik, MusikViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_event);
        setTitle("Daftar Perusahaan");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.recycler_view);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Musik>()
                .setQuery(query, Musik.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Musik, MusikViewHolder>(options) {
            @Override
            public MusikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new MusikViewHolder(inflater.inflate(R.layout.item_list, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull MusikViewHolder holder, int position, @NonNull final Musik model) {
                holder.bindToMusik(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(getApplicationContext(),desc_event.class);
                        startActivity(e);
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("Musik");
        return query;
    }
}


//        import androidx.appcompat.app.AppCompatActivity;
//        import androidx.recyclerview.widget.GridLayoutManager;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import android.content.Intent;
//        import android.content.res.TypedArray;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.ListView;
//        import android.widget.SimpleAdapter;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//
//public class ListEvent extends AppCompatActivity {
//    private RecyclerView mRecyclerView;
//    private ArrayList<Musik> mMusikData;
//    private ListAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_event);
//
//        // Initialize the RecyclerView.
//        mRecyclerView = findViewById(R.id.recycler_view);
//
//        // Get the appropriate column count.
//        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
//
//        // Set the Layout Manager.
//        mRecyclerView.setLayoutManager(new GridLayoutManager(
//                this, gridColumnCount));
//
//        // Initialize the ArrayList that will contain the data.
//        mMusikData = new ArrayList<>();
//
//        // Initialize the adapter and set it to the RecyclerView.
//        mAdapter = new ListAdapter(this, mMusikData);
//        mRecyclerView.setAdapter(mAdapter);
//
//        // Get the data.
//        initializeData();
//
////
//
//
//    }
//
//    private void initializeData() {
//        // Get the resources from the XML file.
//        String[] judul = getResources()
//                .getStringArray(R.array.music_judul);
//        String[] tempat = getResources()
//                .getStringArray(R.array.music_tempat);
//        String[] tanggal = getResources()
//                .getStringArray(R.array.music_tanggal);
//        String[] tiket = getResources()
//                .getStringArray(R.array.music_tiket);
//        String[] penyelenggara = getResources()
//                .getStringArray(R.array.music_penyelenggara);
//        String[] jam = getResources()
//                .getStringArray(R.array.music_jam);
//        String[] bulan = getResources()
//                .getStringArray(R.array.music_bulan);
//        String[] harga = getResources()
//                .getStringArray(R.array.music_harga);
//        String[] tgl = getResources()
//                .getStringArray(R.array.music_tgl);
//        TypedArray poster =
//                getResources().obtainTypedArray(R.array.music_poster);
//
//        // Clear the existing data (to avoid duplication).
//        mMusikData.clear();
//
//        // Create the ArrayList of Sports objects with the titles and
//        // information about each sport.
//        for (int i = 0; i < judul.length; i++) {
//            mMusikData.add(new Musik(judul[i], tempat[i],tanggal[i],tiket[i], penyelenggara[i],
//                    bulan[i], tgl[i], jam[i], harga[i],
//                    poster.getResourceId(i, 0)));
//        }
//
//        // Recycle the typed array.
//        poster.recycle();
//
//        // Notify the adapter of the change.
//        mAdapter.notifyDataSetChanged();
//    }
//
//
//
//}
//
//
