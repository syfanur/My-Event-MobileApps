package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class ListWorkshop extends AppCompatActivity {
    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Musik> options;
    FirebaseRecyclerAdapter<Musik, MusikViewHolder> adapter;
    Query DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_workshop);

        DataRef = FirebaseDatabase.getInstance().getReference().child("Musik")
                .orderByChild("Kategori")
                .equalTo("Workshop");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
        recyclerView.setHasFixedSize(true);

        LoadData();
    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<Musik>().setQuery(DataRef, Musik.class).build();
        adapter = new FirebaseRecyclerAdapter<Musik, MusikViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MusikViewHolder holder, final int position, @NonNull final Musik model) {
                holder.mjudul.setText(model.getJudul());
                holder.malamat.setText(model.getAlamat());
                holder.mtanggal.setText(model.getTanggal());
                holder.mharga.setText("Rp. " + model.getHarga());
                Picasso.get().load(model.getPoster()).into(holder.mposter);

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(ListWorkshop.this, desc_event.class);
                        e.putExtra("pid", model.getId());
                        startActivity(e);
                    }
                });


            }



            @NonNull
            @Override
            public MusikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
                return new MusikViewHolder(v);
            }};


        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


}
