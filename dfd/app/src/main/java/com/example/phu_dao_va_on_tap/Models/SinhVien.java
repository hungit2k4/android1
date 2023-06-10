package com.example.phu_dao_va_on_tap.Models;

public class SinhVien {
    public Integer id;
    public String maNV, hoTen ,phongBan;

    public SinhVien() {
    }

    public SinhVien(Integer id, String maNV, String hoTen, String phongBan) {
        this.id = id;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
