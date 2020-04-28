package com.example.listdata;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class AllEventActivity extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Event> options;
    FirebaseRecyclerAdapter<Event, MyViewHolder> adapter;
    DatabaseReference DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_event);

        DataRef = FirebaseDatabase.getInstance().getReference().child("Musik");
        inputSearch = findViewById(R.id.InputSearch);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        LoadData("");

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString()!=null){
                    LoadData(s.toString());
                }
                else {
                    LoadData("");
                }
            }
        });
    }


    private void LoadData(String data) {
        Query query=DataRef.orderByChild("Judul").startAt(data).endAt(data+"\uf8ff");

        options=new FirebaseRecyclerOptions.Builder<Event>().setQuery(query,Event.class).build();
        adapter=new FirebaseRecyclerAdapter<Event, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position, @NonNull Event event) {
                myViewHolder.tvJudul.setText(event.getJudul());
                myViewHolder.tvAlamat.setText(event.getAlamat());
                myViewHolder.tvTanggal.setText(event.getTanggal());
                myViewHolder.tvHarga.setText(event.getHarga());
                Picasso.get().load(event.getPoster()).into(myViewHolder.imageView);
                myViewHolder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AllEventActivity.this,Deskripsi.class);
                        intent.putExtra("pid",getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
