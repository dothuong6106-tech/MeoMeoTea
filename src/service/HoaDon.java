/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
/**
 *
 * @author DELL
 */
public class HoaDon {
    private String maHD;
    private Timestamp ngayLap;
    private double tongTien;
    private String maKH;
    private String maNV; 
    
    public HoaDon(){}

    public HoaDon(String maHD, Timestamp ngayLap, double tongTien, String maKH, String maNV) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maKH = maKH;
        this.maNV = maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD='" + maHD + '\'' +
                ", ngayLap=" + ngayLap +
                ", tongTien=" + tongTien +
                ", maKH='" + maKH + '\'' +
                ", maNV='" + maNV + '\'' +
                '}';
    }
}
