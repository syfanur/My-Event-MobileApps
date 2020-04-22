package com.example.myevent;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;


public class Musik {

    public String title, info, tanggal, tiket, penyelenggara, bulan, tanggaal, jam, fee;

    public int poster;

    public Musik(){

    }

    public Musik(String title, String info, String tanggal, String tiket, String penyelenggara,
                 String bulan, String tanggaal, String jam, String harga, int poster) {
        this.title = title;
        this.info = info;
        this.tanggal = tanggal;
        this.tiket = tiket;
        this.penyelenggara = penyelenggara;
        this.bulan = bulan;
        this.tanggaal = tanggaal;
        this.jam = jam;
        this.fee = harga;
        this.poster = poster;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("info", info);
        result.put("tanggal", tanggal);
        result.put("tiket", tiket);
        result.put("poster", poster);
        return result;
    }


}
