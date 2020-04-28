package com.example.listdata;

public class Event {
    private String Poster;
    private String Judul;
    private String Alamat;
    private String Tanggal;
    private String Harga;
    private String Jam;
    private String Penyelenggara;
    private String Deskripsi;

    public Event(String poster, String judul, String alamat, String tanggal, String harga, String jam, String penyelenggara, String deskripsi) {
        Poster = poster;
        Judul = judul;
        Alamat = alamat;
        Tanggal = tanggal;
        Harga = harga;
        Jam = jam;
        Penyelenggara = penyelenggara;
        Deskripsi = deskripsi;
    }

    public Event() {
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
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

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }
}