/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
/**
 *
 * @author DELL
 */
public class ThongKeDoanhThu {
    private Date ngay;
    private int soLuongSanPham;
    private int soHoaDon;
    private double doanhThu;
    
    public ThongKeDoanhThu(){}

    public ThongKeDoanhThu(Date ngay, int soLuongSanPham, int soHoaDon, double doanhThu) {
        this.ngay = ngay;
        this.soLuongSanPham = soLuongSanPham;
        this.soHoaDon = soHoaDon;
        this.doanhThu = doanhThu;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
    @Override
    public String toString() {
        return "ThongKeDoanhThu{" +
                "ngay='" + ngay + '\'' +
                ", soLuongSanPham=" + soLuongSanPham +
                ", soHoaDon=" + soHoaDon +
                ", doanhThu=" + doanhThu +
                '}';
    }
}
