package com.example.lab5_ps29253;

public class SinhVien {
    private Integer id;
    private String coSo;
    private String ten;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(Integer id, String coSo, String ten, String diaChi) {
        this.id = id;
        this.coSo = coSo;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
