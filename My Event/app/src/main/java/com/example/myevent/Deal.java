package com.example.myevent;

public class Deal {
    private String Title;
    private String Lokasi;
    private String Tipe;
    private String image;
    private String Price;

    public Deal() {
    }

    public Deal(String title, String lokasi, String tipe, String image, String price) {
        Title = title;
        Lokasi = lokasi;
        Tipe = tipe;
        this.image = image;
        Price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public String getTipe() {
        return Tipe;
    }

    public void setTipe(String tipe) {
        Tipe = tipe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
