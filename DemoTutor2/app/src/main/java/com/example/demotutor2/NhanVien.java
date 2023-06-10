package com.example.demotutor2;


// Model
public class NhanVien {
    private String maNV, hoTen, phongBan;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String phongBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
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
