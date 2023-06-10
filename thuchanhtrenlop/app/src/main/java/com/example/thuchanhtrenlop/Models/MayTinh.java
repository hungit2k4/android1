package com.example.thuchanhtrenlop.Models;

public class MayTinh {
    private String hang,gia;

    public MayTinh() {
    }

    public MayTinh(String hang, String gia) {
        this.hang = hang;
        this.gia = gia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
