package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class riwayatPembayaran extends AppCompatActivity {

    private RecyclerView refList;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pembayaran);

        ref = FirebaseDatabase.getInstance().getReference().child("Orders");


        refList = findViewById(R.id.recycler_view1);
        refList.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<riwayatClass> options =
                new FirebaseRecyclerOptions.Builder<riwayatClass>()
                        .setQuery(ref, riwayatClass.class)
                        .build();

        FirebaseRecyclerAdapter<riwayatClass, riwayatOrdersView> adapter =
                new FirebaseRecyclerAdapter<riwayatClass, riwayatOrdersView>(options) {

                    @Override
                    protected void onBindViewHolder(@NonNull riwayatOrdersView views, int i, @NonNull riwayatClass riwayatClass)
                    {
                        views.txtname.setText("Pemesan: " +riwayatClass.getPname());
                        views.txtdate.setText("Tanggal: " +riwayatClass.getDate());
                        views.txtstatus.setText("Status: " +riwayatClass.getStatus());
                        views.txtTotalAmount.setText("Total Harga" +riwayatClass.getTotalAmount());


                    }
                    @NonNull
                    @Override
                    public riwayatOrdersView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                       View view = LayoutInflater.from(parent.getContext()) .inflate(R.layout.list_riwayat, parent, false);
                       return new riwayatOrdersView(view);

                    }
                };
        adapter.startListening();
        refList.setAdapter(adapter);



    }

    public static class riwayatOrdersView extends RecyclerView.ViewHolder
    {
        public TextView txtname, txtdate, txtstatus, txtTotalAmount;
        public Button showDetails;


        public riwayatOrdersView(@NonNull View itemView) {
            super(itemView);

            txtname =itemView.findViewById(R.id.judul);
            txtstatus =itemView.findViewById(R.id.kategori);
            txtdate =itemView.findViewById(R.id.status);
            txtTotalAmount =itemView.findViewById(R.id.alamat);
            showDetails = itemView.findViewById(R.id.bt_detail);
        }
    }




    public void detail(View view) {
        Intent e = new Intent(getApplicationContext(), DetailPembayaran.class);
        startActivity(e);

    }

}
