package com.example.myevent;


public class seminar {

    private String Judul, Alamat, Tanggal, Harga, Poster, Id, Jam, Penyelenggara, Deskripsi;

    public seminar() {
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public seminar(String judul, String alamat, String tanggal, String harga, String poster, String id, String jam, String penyelenggara, String deskripsi) {
        Judul = judul;
        Alamat = alamat;
        Tanggal = tanggal;
        Harga = harga;
        Poster = poster;
        Id = id;
        Jam = jam;
        Penyelenggara = penyelenggara;
        Deskripsi = deskripsi;


    }
}