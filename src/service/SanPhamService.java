/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.SanPhamDao;
import model.SanPham;
import exception.DatabaseException;
import exception.NotFoundException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class SanPhamService {
    private SanPhamDao sanPhamDao = new SanPhamDao();

    // Lấy tất cả sản phẩm
    public ArrayList<SanPham> getAllSanPham() {
        try {
            return sanPhamDao.getAll();
        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy danh sách sản phẩm: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Thêm sản phẩm
    public boolean themSanPham(SanPham sp) {
        try {

            // validate đơn giản (logic nghiệp vụ)
            if (sp.getGiaBan() < 0) {
                throw new IllegalArgumentException("Giá bán không hợp lệ");
            }

            if (sp.getSoLuongTonKho() < 0) {
                throw new IllegalArgumentException("Số lượng tồn kho không hợp lệ");
            }

            return sanPhamDao.insert(sp);

        } catch (DatabaseException e) {
            System.out.println("Lỗi thêm sản phẩm: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật sản phẩm
    public boolean capNhatSanPham(SanPham sp) {
        try {

            if (sp.getGiaBan() < 0) {
                throw new IllegalArgumentException("Giá bán không hợp lệ");
            }

            if (sp.getSoLuongTonKho() < 0) {
                throw new IllegalArgumentException("Số lượng tồn kho không hợp lệ");
            }

            return sanPhamDao.update(sp);

        } catch (DatabaseException e) {
            System.out.println("Lỗi cập nhật sản phẩm: " + e.getMessage());
            return false;
        }
    }

    // Xóa sản phẩm
    public boolean xoaSanPham(String maSP) {
        try {
            return sanPhamDao.delete(maSP);

        } catch (DatabaseException e) {
            System.out.println("Lỗi xóa sản phẩm: " + e.getMessage());
            return false;
        }
    }

    // Tìm theo mã
    public SanPham timTheoMa(String maSP) {
        try {
            return sanPhamDao.findById(maSP);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy sản phẩm: " + maSP);
            return null;

        } catch (DatabaseException e) {
            System.out.println("Lỗi tìm sản phẩm: " + e.getMessage());
            return null;
        }
    }

    // Sắp xếp giá tăng dần
    public ArrayList<SanPham> sapXepGiaTangDan() {
        try {
            return sanPhamDao.sapXepGiaTangDan();
        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp tăng dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Sắp xếp giá giảm dần
    public ArrayList<SanPham> sapXepGiaGiamDan() {
        try {
            return sanPhamDao.sapXepGiaGiamDan();
        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp giảm dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
