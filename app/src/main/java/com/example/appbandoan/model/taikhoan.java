package com.example.appbandoan.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class taikhoan {
    public int id;
    public String email,gioitinh,diachi,sodienthoai,username,password,mota,chucvi,tuoi;

    public taikhoan() {
    }

    public taikhoan(int id, String email, String gioitinh, String diachi, String sodienthoai, String username, String password, String mota, String chucvi, String tuoi) {
        this.id = id;
        this.email =email;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.username = username;
        this.password = password;
        this.mota = mota;
        this.chucvi = chucvi;
        this.tuoi = tuoi;
    }

    public taikhoan(String email, String gioitinh, String diachi, String sodienthoai, String username, String password, String mota, String chucvi, String tuoi) {
        this.email = email;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.username = username;
        this.password = password;
        this.mota = mota;
        this.chucvi = chucvi;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getChucvi() {
        return chucvi;
    }

    public void setChucvi(String chucvi) {
        this.chucvi = chucvi;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "taikhoan{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sodienthoai='" + sodienthoai + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mota='" + mota + '\'' +
                ", chucvi='" + chucvi + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
