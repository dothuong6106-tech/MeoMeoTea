/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.TaiKhoan;
import exception.DatabaseException;
import exception.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class TaiKhoanDao {
    
    // Kiểm tra tài khoản có tồn tại không
     public boolean tonTaiTaiKhoan(String tenDangNhap) {

        String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tenDangNhap);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi kiểm tra tồn tại tài khoản", e);
        }
    }

    // Đăng nhập
    public TaiKhoan dangNhap(String tenDangNhap, String matKhau) {

        String sql = "SELECT * FROM TaiKhoan "
                   + "WHERE tenDangNhap = ? AND matKhau = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new TaiKhoan(
                        rs.getString("tenDangNhap"),
                        rs.getString("matKhau"),
                        rs.getString("vaiTro")
                );
            }
            throw new NotFoundException("Sai tên đăng nhập hoặc mật khẩu");
        
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi khi đăng nhập", e);
        }
    }

    // Lấy vai trò theo tên đăng nhập
    public String layVaiTro(String tenDangNhap) {

        String sql = "SELECT vaiTro FROM TaiKhoan "
                   + "WHERE tenDangNhap = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tenDangNhap);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("vaiTro");
            }
            throw new NotFoundException("Không tìm thấy tài khoản: " + tenDangNhap);

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy vai trò tài khoản", e);
        }
    }
}

