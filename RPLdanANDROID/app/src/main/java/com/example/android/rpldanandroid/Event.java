package com.example.android.rpldanandroid;


public class Event {

    private String Id, Judul, Alamat, Tanggal, Jam, Penyelenggara, Tiket, Harga, Deskripsi, Poster;

    public Event(String id, String judul, String alamat, String tanggal, String jam, String penyelenggara, String tiket, String harga, String deskripsi, String poster) {
        Id = id;
        Judul = judul;
        Alamat = alamat;
        Tanggal = tanggal;
        Jam = jam;
        Penyelenggara = penyelenggara;
        Tiket = tiket;
        Harga = harga;
        Deskripsi = deskripsi;
        Poster = poster;
    }

    public Event() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getJudul() {
        return Judul;
    }

    public void setTitle(String judul) {
        Judul = judul;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getPenyelenggara() {
        return Penyelenggara;
    }

    public void setPenyelenggara(String penyelenggara) {
        Penyelenggara = penyelenggara;
    }

    public String getTiket() {
        return Tiket;
    }

    public void setTiket(String tiket) {
        Tiket = tiket;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}

