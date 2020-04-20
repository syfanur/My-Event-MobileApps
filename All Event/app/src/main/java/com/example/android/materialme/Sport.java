package com.example.android.materialme;

class Sport {

    private String judul;
    private String ticket;
    private String jenis;
    private String title;
    private String info;
    private final int imageResource;

    public Sport(String judul, String ticket, String jenis, String title, String info, int imageResource) {
        this.judul = judul;
        this.ticket = ticket;
        this.jenis = jenis;
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }
    String getJudul() { return judul;}
    String getTicket() { return ticket;}
    String getJenis() { return jenis;}
    String getTitle() {
        return title;
    }
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

}
