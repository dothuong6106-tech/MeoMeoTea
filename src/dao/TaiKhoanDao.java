/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.TaiKhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

