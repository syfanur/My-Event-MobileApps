package com.example.myevent;

public class riwayatClass
{

    private String address, date, pending, pname, status, time, totalAmount;

    public riwayatClass() {
    }

    public riwayatClass(String address, String date, String pending, String pname, String status, String time, String totalAmount) {
        this.address = address;
        this.date = date;
        this.pending = pending;
        this.pname = pname;
        this.status = status;
        this.time = time;
        this.totalAmount = totalAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    //    private String judul, lokasi, status, poster, kategori;
//
//    public riwayatClass() {
//    }
//
//    public riwayatClass(String judul, String lokasi, String status, String poster, String kategori) {
//        this.judul = judul;
//        this.lokasi = lokasi;
//        this.status = status;
//        this.poster = poster;
//        this.kategori = kategori;
//    }
//
//    public String getJudul() {
//        return judul;
//    }
//
//    public void setJudul(String judul) {
//        this.judul = judul;
//    }
//
//    public String getLokasi() {
//        return lokasi;
//    }
//
//    public void setLokasi(String lokasi) {
//        this.lokasi = lokasi;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }
//
//    public String getKategori() {
//        return kategori;
//    }
//
//    public void setKategori(String kategori) {
//        this.kategori = kategori;
//    }
}
