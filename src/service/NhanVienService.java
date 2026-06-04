/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.NhanVienDao;
import model.NhanVien;
import exception.DatabaseException;
import exception.NotFoundException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class NhanVienService {
    private NhanVienDao nhanVienDao = new NhanVienDao();

    // Lấy danh sách nhân viên
    public ArrayList<NhanVien> getAllNhanVien() {
        try {
            return nhanVienDao.getAll();

        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy danh sách nhân viên: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Thêm nhân viên
    public boolean themNhanVien(NhanVien nv) {
        try {

            // validate nghiệp vụ
            if (nv.getMaNV() == null || nv.getMaNV().isEmpty()) {
                throw new IllegalArgumentException("Mã nhân viên không được rỗng");
            }

            if (nv.getLuong() < 0) {
                throw new IllegalArgumentException("Lương không hợp lệ");
            }

            if (nv.getSdt() == null || nv.getSdt().length() < 9) {
                throw new IllegalArgumentException("Số điện thoại không hợp lệ");
            }

            return nhanVienDao.insert(nv);

        } catch (DatabaseException e) {
            System.out.println("Lỗi thêm nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật nhân viên
    public boolean capNhatNhanVien(NhanVien nv) {
        try {

            if (nv.getMaNV() == null || nv.getMaNV().isEmpty()) {
                throw new IllegalArgumentException("Mã nhân viên không được rỗng");
            }

            return nhanVienDao.update(nv);

        } catch (DatabaseException e) {
            System.out.println("Lỗi cập nhật nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Xóa nhân viên
    public boolean xoaNhanVien(String maNV) {
        try {
            return nhanVienDao.delete(maNV);

        } catch (DatabaseException e) {
            System.out.println("Lỗi xóa nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Tìm theo mã
    public NhanVien timTheoMa(String maNV) {
        try {
            return nhanVienDao.findById(maNV);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy nhân viên: " + maNV);
            return null;

        } catch (DatabaseException e) {
            System.out.println("Lỗi tìm nhân viên: " + e.getMessage());
            return null;
        }
    }

    // Sắp xếp lương tăng dần
    public ArrayList<NhanVien> sapXepLuongTangDan() {
        try {
            return nhanVienDao.sapXepLuongTangDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp lương tăng dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Sắp xếp lương giảm dần
    public ArrayList<NhanVien> sapXepLuongGiamDan() {
        try {
            return nhanVienDao.sapXepLuongGiamDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp lương giảm dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
