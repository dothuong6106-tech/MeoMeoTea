/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.TaiKhoanDao;
import model.TaiKhoan;
import exception.DatabaseException;
import exception.NotFoundException;
/**
 *
 * @author DELL
 */
public class DangNhapService {
    private TaiKhoanDao taiKhoanDao = new TaiKhoanDao();

    // Đăng nhập
    public TaiKhoan login(String tenDangNhap, String matKhau) {

        try {
            // 1. Gọi DAO login (DAO đã tự check username + password)
            TaiKhoan tk = taiKhoanDao.dangNhap(tenDangNhap, matKhau);

            return tk;

        } catch (NotFoundException e) {
            // Sai tài khoản hoặc mật khẩu (DAO throw ra)
            System.out.println("Login lỗi: " + e.getMessage());
            return null;

        } catch (DatabaseException e) {
            // Lỗi SQL / hệ thống
            System.out.println("Lỗi hệ thống: " + e.getMessage());
            return null;
        }
    }

    // Kiểm tra tồn tại tài khoản (nếu UI cần check trước)
    public boolean isExist(String tenDangNhap) {

        try {
            return taiKhoanDao.tonTaiTaiKhoan(tenDangNhap);

        } catch (DatabaseException e) {
            System.out.println("Lỗi kiểm tra tài khoản: " + e.getMessage());
            return false;
        }
    }

    // Lấy vai trò để phân quyền
    public String getVaiTro(String tenDangNhap) {

        try {
            return taiKhoanDao.layVaiTro(tenDangNhap);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy tài khoản: " + tenDangNhap);
            return null;

        } catch (DatabaseException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
            return null;
        }
    }
}
