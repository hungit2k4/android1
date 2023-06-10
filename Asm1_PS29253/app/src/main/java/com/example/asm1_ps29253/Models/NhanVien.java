package com.example.asm1_ps29253.Models;

public class NhanVien {
    String maNV, tenNV,PhongBan;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        PhongBan = phongBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String phongBan) {
        PhongBan = phongBan;
    }
}
