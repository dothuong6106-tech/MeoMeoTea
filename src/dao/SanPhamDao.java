/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.SanPham;
import exception.DatabaseException;
import exception.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class SanPhamDao {
    // Xem tất cả sản phẩm
    public ArrayList<SanPham> getAll() {

        ArrayList<SanPham> ds = new ArrayList<>();

        String sql = "SELECT * FROM SanPham";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SanPham sp = new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("giaBan"),
                        rs.getInt("soLuongTonKho")
                );

                ds.add(sp);
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy danh sách sản phẩm", e);
        }
    }

    // Thêm sản phẩm
    public boolean insert(SanPham sp) {

        String sql = "INSERT INTO SanPham VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setDouble(3, sp.getGiaBan());
            ps.setInt(4, sp.getSoLuongTonKho());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi thêm sản phẩm", e);
        }
    }

    // Sửa sản phẩm
    public boolean update(SanPham sp) {

        String sql = """
                     UPDATE SanPham
                     SET tenSP = ?,
                         giaBan = ?,
                         soLuongTonKho = ?
                     WHERE maSP = ?
                     """;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getGiaBan());
            ps.setInt(3, sp.getSoLuongTonKho());
            ps.setString(4, sp.getMaSP());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy sản phẩm để cập nhật: " + sp.getMaSP());
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi cập nhật sản phẩm", e);
        }
    }

    // Xóa sản phẩm
    public boolean delete(String maSP) {

        String sql = "DELETE FROM SanPham WHERE maSP = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maSP);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy sản phẩm để xóa: " + maSP);
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi xóa sản phẩm", e);
        }
    }

    // Tìm sản phẩm theo mã
    public SanPham findById(String maSP) {

        String sql = "SELECT * FROM SanPham WHERE maSP = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maSP);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("giaBan"),
                        rs.getInt("soLuongTonKho")
                );
            }
            throw new NotFoundException("Không tìm thấy sản phẩm: " + maSP);

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi tìm sản phẩm theo mã", e);
        }
    }

    // Sắp xếp giá tăng dần
    public ArrayList<SanPham> sapXepGiaTangDan() {

        ArrayList<SanPham> ds = new ArrayList<>();

        String sql = """
                     SELECT *
                     FROM SanPham
                     ORDER BY giaBan ASC
                     """;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("giaBan"),
                        rs.getInt("soLuongTonKho")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp giá tăng dần", e);
        }
    }

    // Sắp xếp giá giảm dần
    public ArrayList<SanPham> sapXepGiaGiamDan() {

        ArrayList<SanPham> ds = new ArrayList<>();

        String sql = """
                     SELECT *
                     FROM SanPham
                     ORDER BY giaBan DESC
                     """;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("giaBan"),
                        rs.getInt("soLuongTonKho")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp giá giảm dần", e);
        }
    }
}

