package com.example.appbandoan.model;

public class thongbao {
    private int id;
    private String tieude,noidung,mota,date;

    public thongbao() {
    }

    public thongbao(int id, String tieude, String noidung, String mota, String date) {
        this.id = id;
        this.tieude = tieude;
        this.noidung = noidung;
        this.mota = mota;
        this.date = date;
    }

    public thongbao(String tieude, String noidung, String mota, String date) {
        this.tieude = tieude;
        this.noidung = noidung;
        this.mota = mota;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
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
        return "thongbao{" +
                "id=" + id +
                ", tieude='" + tieude + '\'' +
                ", noidung='" + noidung + '\'' +
                ", mota='" + mota + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
