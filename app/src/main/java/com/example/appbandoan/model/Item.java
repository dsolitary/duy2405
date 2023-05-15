package com.example.appbandoan.model;

import java.io.Serializable;
import java.util.Date;

public class Item  {
    private int id,img;
    private String username,title,category,price,diachi,mota,date;

    public Item() {
    }

    public Item(int id,int img,String username, String title, String category, String price,String diachi,String mota,String date) {
        this.id = id;
        this.img = img;
        this.username=username;
        this.title = title;
        this.category = category;
        this.price = price;
        this.diachi = diachi;
        this.mota =mota;
        this.date = date;
    }

    public Item(int img,String username, String title, String category, String price, String diachi, String mota, String date) {
        this.img = img;
        this.username=username;
        this.title = title;
        this.category = category;
        this.price = price;
        this.diachi = diachi;
        this.mota = mota;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", img=" + img +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", diachi='" + diachi + '\'' +
                ", mota='" + mota + '\'' +
                ", date=" + date +
                '}';
    }
}
