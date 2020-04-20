package com.example.myevent;


public class Musik {

    private String title;
    private String info;
    private int imageResource;

    public Musik(){

    }

    public Musik(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }


    String getTitle() {
        return title;
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
