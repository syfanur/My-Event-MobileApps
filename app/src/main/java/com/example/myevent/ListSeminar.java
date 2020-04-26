package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ListSeminar extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Musik> options;
    FirebaseRecyclerAdapter<Musik,MusikViewHolder>adapter;
    DatabaseReference DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);


        DataRef = FirebaseDatabase.getInstance().getReference().child("Seminar");
        inputSearch = findViewById(R.id.inputSearch);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
        recyclerView.setHasFixedSize(true);

        LoadData();
    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<Musik>().setQuery(DataRef, Musik.class).build();
        adapter = new FirebaseRecyclerAdapter<Musik, MusikViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MusikViewHolder holder, final int position, @NonNull Musik model) {
                holder.mjudul.setText(model.getJudul());
                holder.malamat.setText(model.getAlamat());
                holder.mtanggal.setText(model.getTanggal());
                holder.mharga.setText("Rp. "+model.getHarga());
                Picasso.get().load(model.getPoster()).into(holder.mposter);

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(ListSeminar.this,desc_event.class);
                        e.putExtra("SeminarKey", getRef(position).getKey());
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
