package com.example.myevent;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class AllEventActivity extends AppCompatActivity {

    LinearLayoutManager mLayoutManager;
    SharedPreferences mSharedPref;
    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Musik> options;
    FirebaseRecyclerAdapter<Musik, MusikViewHolder> adapter;
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
        mSharedPref = getSharedPreferences("SortSettings", MODE_PRIVATE);
        String mSorting = mSharedPref.getString("Sort","Newest");

        if (mSorting.equals("Newest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(true);
            mLayoutManager.setStackFromEnd(true);
        }else if (mSorting.equals("Oldest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(false);
            mLayoutManager.setStackFromEnd(false);
        }

        recyclerView.setLayoutManager(mLayoutManager);

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

        options=new FirebaseRecyclerOptions.Builder<Musik>().setQuery(query,Musik.class).build();
        adapter=new FirebaseRecyclerAdapter<Musik, MusikViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MusikViewHolder myViewHolder, final int position, @NonNull final Musik event) {
                myViewHolder.mjudul.setText(event.getJudul());
                myViewHolder.malamat.setText(event.getAlamat());
                myViewHolder.mtanggal.setText(event.getTanggal());
                myViewHolder.mharga.setText(event.getHarga());
                Picasso.get().load(event.getPoster()).into(myViewHolder.mposter);
                myViewHolder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AllEventActivity.this,desc_event.class);
                        intent.putExtra("pid",event.getId());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public MusikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
                return new MusikViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.bt_Filter){
                    showSortDialog();
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }

    private void showSortDialog() {
        String[] sortOptions = {"Newest","Oldest"};
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Filter By")
                .setIcon(R.drawable.ic_search)
                .setItems(sortOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if (which==0){
                            SharedPreferences.Editor editor = mSharedPref.edit();
                            editor.putString("Sort", "Newest");
                            editor.apply();
                            recreate();
                       }else if (which==1){{
                           SharedPreferences.Editor editor = mSharedPref.edit();
                           editor.putString("Sort", "Oldest");
                           editor.apply();
                           recreate();
                       }}
                    }
                });
        builder.show();
    }
}
