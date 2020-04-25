package com.example.myevent;

public class Musik {

    private String Judul, Alamat, Tanggal, Harga, Poster;

    public Musik(String judul, String alamat, String tanggal, String harga, String poster) {
        Judul = judul;
        Alamat = alamat;
        Tanggal = tanggal;
        Harga = harga;
        Poster = poster;
    }

    public Musik() {
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
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

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}