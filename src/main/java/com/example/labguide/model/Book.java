package com.example.labguide.model;

public class Book {
    int id;
    String title;
    String code;
    String image;
    double price;
    public Book(int id, String title, String code, String image, double price) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.image = image;
        this.price = price;
    }
    public Book() {
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
