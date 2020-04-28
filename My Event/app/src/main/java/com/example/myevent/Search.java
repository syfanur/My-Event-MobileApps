package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Deal> list;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ref = FirebaseDatabase.getInstance().getReference().child("Seminar");
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (ref != null) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(Deal.class));
                        }
                        AdapterClass adapterclass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterclass);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Search.this, databaseError.getMessage());
                }
            });
        }
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return false;
                }
            });
        }
    }
    private void search(String str){
        ArrayList<Deal> myList = new ArrayList<>();
        for (Deal object : list){
            if (object.getLokasi().toLowerCase().contains(str.toLowerCase())){
               myList.add(object);
            }
        }
        AdapterClass adapterClass = new AdapterClass(myList);
        recyclerView.setAdapter(adapterClass);
    }
    }


