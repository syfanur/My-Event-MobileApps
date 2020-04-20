package com.example.myeventeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class seminar extends AppCompatActivity {

    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Judul;
    String[] Alamat;
    String[] Tanggal;
    String[] Tiket;
    String[] Poster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);

        listView = (ListView)findViewById(R.id.list_seminar);
        Poster = new String[]{
                Integer.toString(R.drawable.seminar2),Integer.toString(R.drawable.seminar3),
                Integer.toString(R.drawable.pajak),
                Integer.toString(R.drawable.seminarjuga)};
        Judul = new String[]{
                "Seminar 1","Seminar 2","Seminar 3",
                "Seminar 4"};
        Alamat = new String[]{
                "Bandung","Bandung","Bojongsoang","Bandung"};
        Tanggal = new String[]{
                "1 Maret 2020","6 Maret 2020","20 April 2020","31 Agustus 2020"};
        Tiket = new String[]{
                "No Available","Ticket Left : 5","Ticket Left : 2","Ticket Left : 1"};

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<Judul.length; i++){
            map = new HashMap<String, String>();
            map.put("judul", Judul[i]);
            map.put("alamat", Alamat[i]);
            map.put("tanggal", Tanggal[i]);
            map.put("tiket", Tiket[i]);
            map.put("poster", Poster[i]);
            mylist.add(map);
        }
        adapter = new SimpleAdapter(this, mylist, R.layout.activity_item_list,
                new String[]{"judul", "alamat", "tanggal", "tiket", "poster"}, new int[]
                {R.id.judul,(R.id.alamat),(R.id.tanggal),(R.id.tiket),(R.id.poster)});
        listView.setAdapter(adapter);



    }
}
