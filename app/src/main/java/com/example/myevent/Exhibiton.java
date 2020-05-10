package com.example.myevent;

import android.content.Intent;
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
import com.squareup.picasso.Picasso;

public class Exhibiton extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Event> options;
    FirebaseRecyclerAdapter<Event, ExhibitionViewHolder> adapter;
    DatabaseReference DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibiton);

        DataRef = FirebaseDatabase.getInstance().getReference().child("Exhibition");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
        recyclerView.setHasFixedSize(true);

        LoadData();
    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<Event>().setQuery(DataRef, Event.class).build();
        adapter = new FirebaseRecyclerAdapter<Event, ExhibitionViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ExhibitionViewHolder holder, final int position, @NonNull final Event model) {
                holder.mjudul.setText(model.getJudul());
                holder.malamat.setText(model.getAlamat());
                holder.mtanggal.setText(model.getTanggal());
                holder.mtiket.setText(model.getTiket());
                holder.mharga.setText(model.getHarga());
                Picasso.get().load(model.getPoster()).into(holder.mposter);

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(Exhibiton.this, DetailEvent.class);
                        e.putExtra("Key",getRef(position).getKey());
                        startActivity(e);
                    }
                });
            }

            @NonNull
            @Override
            public ExhibitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
                return new ExhibitionViewHolder(v);
            }};

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    public void ButtonBackHomepage(View view) {
        Intent intent = new Intent(Exhibiton.this, HomeActivity.class);
        startActivity(intent);
    }
}


