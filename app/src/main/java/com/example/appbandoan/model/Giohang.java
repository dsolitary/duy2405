package com.example.appbandoan.model;

public class Giohang {
    int id,imgsp;
    String idsp,tensp,giasp,soluongsp;

    public Giohang() {
    }

    public Giohang(int id, int imgsp, String idsp, String tensp, String giasp, String soluongsp) {
        this.id = id;
        this.imgsp = imgsp;
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluongsp = soluongsp;
    }

    public Giohang(int imgsp, String idsp, String tensp, String giasp, String soluongsp) {
        this.imgsp = imgsp;
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluongsp = soluongsp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgsp() {
        return imgsp;
    }

    public void setImgsp(int imgsp) {
        this.imgsp = imgsp;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(String soluongsp) {
        this.soluongsp = soluongsp;
    }

    @Override
    public String toString() {
        return "Giohang{" +
                "id=" + id +
                ", imgsp=" + imgsp +
                ", idsp='" + idsp + '\'' +
                ", tensp='" + tensp + '\'' +
                ", giasp='" + giasp + '\'' +
                ", soluongsp='" + soluongsp + '\'' +
                '}';
    }
}
