/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.HoaDonDao;
import dao.ChiTietHoaDonDao;
import dao.SanPhamDao;

import model.HoaDon;
import model.ChiTietHoaDon;
import model.SanPham;

import exception.DatabaseException;
import exception.NotFoundException;

import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class TaoDonHangService {
    private HoaDonDao hoaDonDao = new HoaDonDao();
    private ChiTietHoaDonDao chiTietDao = new ChiTietHoaDonDao();
    private SanPhamDao sanPhamDao = new SanPhamDao();
    
    // Tạo hóa đơn
    public boolean taoHoaDon(String maHD, String maKH, String maNV) {

        try {
            HoaDon hd = new HoaDon(
                    maHD,
                    new Timestamp(System.currentTimeMillis()),
                    0,
                    maKH,
                    maNV
            );

            return hoaDonDao.insert(hd);

        } catch (DatabaseException e) {
            System.out.println("Lỗi tạo hóa đơn: " + e.getMessage());
            return false;
        }
    }

    //Thêm sản phẩm vào hóa đơn
    public boolean themSanPhamVaoHoaDon(String maHD, String maSP, int soLuong) {

        try {
            // 1. lấy sản phẩm
            SanPham sp = sanPhamDao.findById(maSP);

            // 2. kiểm tra tồn kho
            if (sp.getSoLuongTonKho() < soLuong) {
                System.out.println("Không đủ hàng trong kho!");
                return false;
            }

            // 3. tính tiền
            double donGia = sp.getGiaBan();
            double thanhTien = donGia * soLuong;

            // 4. tạo chi tiết hóa đơn
            ChiTietHoaDon ct = new ChiTietHoaDon(
                    maHD,
                    maSP,
                    sp.getTenSP(),
                    soLuong,
                    donGia,
                    thanhTien
            );

            // 5. insert chi tiết hóa đơn
            boolean ok = chiTietDao.insert(ct);
            if (!ok) return false;

            // 6. trừ tồn kho
            sp.setSoLuongTonKho(sp.getSoLuongTonKho() - soLuong);
            sanPhamDao.update(sp);

            return true;

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy sản phẩm: " + maSP);
            return false;

        } catch (DatabaseException e) {
            System.out.println("Lỗi thêm sản phẩm vào hóa đơn: " + e.getMessage());
            return false;
        }
    }

    // Tính tổng tiền
    public double tinhTongTien(ArrayList<ChiTietHoaDon> ds) {

        double tong = 0;

        for (ChiTietHoaDon ct : ds) {
            tong += ct.getThanhTien();
        }

        return tong;
    }
    
    // Hoàn thành hóa đơn
     public boolean hoanThanhHoaDon(String maHD) {

        try {
            // lấy chi tiết hóa đơn
            ArrayList<ChiTietHoaDon> ds = chiTietDao.getByMaHD(maHD);

            // tính tổng tiền
            double tongTien = tinhTongTien(ds);

            // update hóa đơn
            HoaDon hd = hoaDonDao.findById(maHD);
            hd.setTongTien(tongTien);

            return hoaDonDao.update(hd);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy hóa đơn: " + maHD);
            return false;

        } catch (DatabaseException e) {
            System.out.println("Lỗi hoàn thành hóa đơn: " + e.getMessage());
            return false;
        }
    }
}
