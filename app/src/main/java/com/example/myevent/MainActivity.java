package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private Integer[] Poster = new Integer[]{
            R.drawable.playlistlove,R.drawable.archatala,
            R.drawable.naif,R.drawable.iconic};
    private String[] Judul = new String[]{
            "Playlist Love Festival","Archatala","NAIF",
            "ICONIC"};
    private String[] Alamat = new String[]{
            "Bandung","Bandung","Bojongsoang","Bandung"};
    private String[] Tanggal = new String[]{
            "1 Maret 2020","6 Maret 2020","20 April 2020","31 Agustus 2020"};
    private String[] Tiket = new String[]{
            "No Available","Ticket Left : 5","Ticket Left : 2","Ticket Left : 1"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Movies List");
        listView = findViewById(R.id.listMusic);
        eventListAdapter eventListAdapter = new eventListAdapter(
                Poster, Judul, Alamat, Tanggal, Tiket,this);
        listView.setAdapter(eventListAdapter);
    }

    public void desc(View view) {
        Intent iLogin = new Intent(getApplicationContext(),desc_event.class);
        startActivity(iLogin);
    }

    public void welcome(View view) {
        Intent b = new Intent(getApplicationContext(),Welcome.class);
        startActivity(b);
    }

    public void eventlist(View view) {
        Intent c = new Intent(getApplicationContext(),eventListAdapter.class);
        startActivity(c);
    }

    public void transaksi(View view) {
        Intent d = new Intent(getApplicationContext(),transaksi1.class);
        startActivity(d);
    }
}
