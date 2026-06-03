/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa sản phẩm
    public boolean delete(String maSP) {

        String sql = "DELETE FROM SanPham WHERE maSP = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maSP);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }
}

