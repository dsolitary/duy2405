package com.example.appbandoan.model;

public class Donhang {
    int id;
    String username,idmonan,nammonan,giamonan ,soluongmonan,diachinhan,ghichu,date;

    public Donhang() {
    }

    public Donhang(int id, String username, String idmonan, String nammonan, String giamonan, String soluongmonan, String diachinhan, String ghichu, String date) {
        this.id = id;
        this.username = username;
        this.idmonan = idmonan;
        this.nammonan = nammonan;
        this.giamonan = giamonan;
        this.soluongmonan = soluongmonan;
        this.diachinhan = diachinhan;
        this.ghichu = ghichu;
        this.date = date;
    }

    public Donhang(String username, String idmonan, String nammonan, String giamonan, String soluongmonan, String diachinhan, String ghichu, String date) {
        this.username = username;
        this.idmonan = idmonan;
        this.nammonan = nammonan;
        this.giamonan = giamonan;
        this.soluongmonan = soluongmonan;
        this.diachinhan = diachinhan;
        this.ghichu = ghichu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(String idmonan) {
        this.idmonan = idmonan;
    }

    public String getNammonan() {
        return nammonan;
    }

    public void setNammonan(String nammonan) {
        this.nammonan = nammonan;
    }

    public String getGiamonan() {
        return giamonan;
    }

    public void setGiamonan(String giamonan) {
        this.giamonan = giamonan;
    }

    public String getSoluongmonan() {
        return soluongmonan;
    }

    public void setSoluongmonan(String soluongmonan) {
        this.soluongmonan = soluongmonan;
    }

    public String getDiachinhan() {
        return diachinhan;
    }

    public void setDiachinhan(String diachinhan) {
        this.diachinhan = diachinhan;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
