/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.KhachHangDao;
import model.KhachHang;
import exception.DatabaseException;
import exception.NotFoundException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class KhachHangService {
    private KhachHangDao khachHangDao = new KhachHangDao();

    // Lấy danh sách khách hàng
    public ArrayList<KhachHang> getAllKhachHang() {
        try {
            return khachHangDao.getAll();

        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy danh sách khách hàng: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Thêm khách hàng
    public boolean themKhachHang(KhachHang kh) {
        try {

            // validate nghiệp vụ đơn giản
            if (kh.getMaKH() == null || kh.getMaKH().isEmpty()) {
                throw new IllegalArgumentException("Mã khách hàng không được rỗng");
            }

            if (kh.getSdt() == null || kh.getSdt().length() < 9) {
                throw new IllegalArgumentException("Số điện thoại không hợp lệ");
            }

            return khachHangDao.insert(kh);

        } catch (DatabaseException e) {
            System.out.println("Lỗi thêm khách hàng: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật khách hàng
    public boolean capNhatKhachHang(KhachHang kh) {
        try {

            if (kh.getMaKH() == null || kh.getMaKH().isEmpty()) {
                throw new IllegalArgumentException("Mã khách hàng không được rỗng");
            }

            return khachHangDao.update(kh);

        } catch (DatabaseException e) {
            System.out.println("Lỗi cập nhật khách hàng: " + e.getMessage());
            return false;
        }
    }

    // Xóa khách hàng
    public boolean xoaKhachHang(String maKH) {
        try {
            return khachHangDao.delete(maKH);

        } catch (DatabaseException e) {
            System.out.println("Lỗi xóa khách hàng: " + e.getMessage());
            return false;
        }
    }

    // Tìm theo mã
    public KhachHang timTheoMa(String maKH) {
        try {
            return khachHangDao.findById(maKH);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy khách hàng: " + maKH);
            return null;

        } catch (DatabaseException e) {
            System.out.println("Lỗi tìm khách hàng: " + e.getMessage());
            return null;
        }
    }
}
