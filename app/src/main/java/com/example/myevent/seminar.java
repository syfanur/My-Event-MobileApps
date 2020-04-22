package com.example.myevent;


public class seminar {

    private String title;
    private String info;
    private String tanggal;
    private String tiket, penyelenggara, bulan, tanggaal, jam, fee;

    private int imageResource;

    public seminar(){

    }

    public seminar(String title, String info, String tanggal, String tiket, String penyelenggara,
                 String bulan, String tanggaal, String jam, String harga, int imageResource) {
        this.title = title;
        this.info = info;
        this.tanggal = tanggal;
        this.tiket = tiket;
        this.penyelenggara = penyelenggara;
        this.bulan = bulan;
        this.tanggaal = tanggaal;
        this.jam = jam;
        this.fee = harga;
        this.imageResource = imageResource;
    }


    String getTitle() {
        return title;
    }
    String getTanggal() {
        return tanggal;
    }
    String getBy() {
        return penyelenggara;
    }
    String getBulan() {
        return bulan;
    }
    String getTgl() {
        return tanggaal;
    }
    String getJam() {
        return jam;
    }
    String getHarga() {
        return fee;
    }
    String getTiket() { return tiket;
    }
    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
