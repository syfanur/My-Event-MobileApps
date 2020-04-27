package com.example.android.rpldanandroid;



public class Event {

    private String Title, Alamat, Tanggal, Tersedia, Biaya, Image;

    public Event(String title, String alamat, String tanggal, String tersedia, String biaya, String image) {
        Title = title;
        Alamat = alamat;
        Tanggal = tanggal;
        Tersedia = tersedia;
        Biaya = biaya;
        Image = image;
    }

    public Event(){

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public String getTersedia() {
        return Tersedia;
    }

    public void setTersedia(String tersedia) {
        Tersedia = tersedia;
    }

    public String getBiaya() {
        return Biaya;
    }

    public void setBiaya(String biaya) {
        Biaya = biaya;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
