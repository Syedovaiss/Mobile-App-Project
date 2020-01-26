package com.ovais.khareedaari;

public class Wallets {
    String image;
    String title;
    String price;
    String description;

    public Wallets(String image, String title, String price,String description) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.description=description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
