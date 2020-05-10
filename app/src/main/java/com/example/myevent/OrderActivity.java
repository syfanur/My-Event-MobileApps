package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class OrderActivity extends AppCompatActivity {
    public static final String NAMA = "com.example.myevent.nama";
    public static final String ALAMAT = "com.example.myevent.alamat";
    public static final String TANGGAL = "com.example.myevent.tanggal";
    public static final String STATUS = "com.example.myevent.status";
    public static final String TOTAL = "com.example.myevent.total";
    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Orders> options;
    FirebaseRecyclerAdapter<Orders,OrderViewHolder> adapter;
    Query DataRef;
    private Button detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_order);

        DataRef = FirebaseDatabase.getInstance().getReference().child("Orders");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
        recyclerView.setHasFixedSize(true);


        LoadData();
    }


    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<Orders>().setQuery(DataRef, Orders.class).build();
        adapter = new FirebaseRecyclerAdapter<Orders, OrderViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder holder, final int position, @NonNull final Orders model) {
                holder.mpname.setText(model.getPname());
                final String address = model.getAddress().toString();
                final String date = model.getDate().toString();
                final String status = model.getStatus().toString();
                final String total = model.getTotalAmount().toString();
                final String nama  = model.getPname().toString();
                holder.mdate.setText(model.getDate());
                holder.mstatus.setText(model.getStatus());
                holder.mtotal.setText("Rp. " + model.getTotalAmount());
                holder.btDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(OrderActivity.this, DetailPembayaran.class);
                        intent.putExtra(NAMA, nama);
                        intent.putExtra(ALAMAT, address);
                        intent.putExtra(TANGGAL, date);
                        intent.putExtra(STATUS, status);
                        intent.putExtra(TOTAL, total);



                        startActivity(intent);
                    }
                });
            }



            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderitem,parent,false);
                return new OrderViewHolder(v);
            }};


        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


}
