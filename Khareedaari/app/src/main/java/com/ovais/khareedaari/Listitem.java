package com.ovais.khareedaari;

public class Listitem {

    String Image;
    String title;

    public Listitem(String image, String title)
    {
        this.Image=image;
        this.title = title;

    }
    public String getImage (){return Image;}
    public String getTitle (){return title;}

}