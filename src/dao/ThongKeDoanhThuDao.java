/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.ThongKeDoanhThu;
import exception.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ThongKeDoanhThuDao {
    // Xem danh sách thống kê theo ngày
    public ArrayList<ThongKeDoanhThu> getAll() {

        ArrayList<ThongKeDoanhThu> ds = new ArrayList<>();

        String sql = """
            SELECT
                hd.Ngay,
                ct.SoLuongSanPham,
                hd.SoHoaDon,
                hd.DoanhThu
            FROM
            (
                SELECT
                    CAST(NgayLap AS DATE) AS Ngay,
                    COUNT(*) AS SoHoaDon,
                    SUM(TongTien) AS DoanhThu
                FROM HoaDon
                GROUP BY CAST(NgayLap AS DATE)
            ) hd
            JOIN
            (
                SELECT
                    CAST(h.NgayLap AS DATE) AS Ngay,
                    SUM(ct.SoLuong) AS SoLuongSanPham
                FROM HoaDon h
                JOIN ChiTietHoaDon ct
                    ON h.MaHD = ct.MaHD
                GROUP BY CAST(h.NgayLap AS DATE)
            ) ct
            ON hd.Ngay = ct.Ngay
            ORDER BY hd.Ngay DESC
            """;

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeDoanhThu tk = new ThongKeDoanhThu(
                        rs.getDate("Ngay"),
                        rs.getInt("SoLuongSanPham"),
                        rs.getInt("SoHoaDon"),
                        rs.getDouble("DoanhThu")
                );

                ds.add(tk);
            }
            return ds;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy thống kê doanh thu", e);
        }
    }

    // Sắp xếp doanh thu tăng dần
    public ArrayList<ThongKeDoanhThu> sapXepDoanhThuTangDan() {

        ArrayList<ThongKeDoanhThu> ds = new ArrayList<>();

        String sql = """
            SELECT
                hd.Ngay,
                ct.SoLuongSanPham,
                hd.SoHoaDon,
                hd.DoanhThu
            FROM
            (
                SELECT
                    CAST(NgayLap AS DATE) AS Ngay,
                    COUNT(*) AS SoHoaDon,
                    SUM(TongTien) AS DoanhThu
                FROM HoaDon
                GROUP BY CAST(NgayLap AS DATE)
            ) hd
            JOIN
            (
                SELECT
                    CAST(h.NgayLap AS DATE) AS Ngay,
                    SUM(ct.SoLuong) AS SoLuongSanPham
                FROM HoaDon h
                JOIN ChiTietHoaDon ct
                    ON h.MaHD = ct.MaHD
                GROUP BY CAST(h.NgayLap AS DATE)
            ) ct
            ON hd.Ngay = ct.Ngay
            ORDER BY hd.DoanhThu ASC
            """;

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeDoanhThu tk = new ThongKeDoanhThu(
                        rs.getDate("Ngay"),
                        rs.getInt("SoLuongSanPham"),
                        rs.getInt("SoHoaDon"),
                        rs.getDouble("DoanhThu")
                );

                ds.add(tk);
            }
            return ds;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp doanh thu tăng dần", e);
        }
    }

    // Sắp xếp doanh thu giảm dần
    public ArrayList<ThongKeDoanhThu> sapXepDoanhThuGiamDan() {

        ArrayList<ThongKeDoanhThu> ds = new ArrayList<>();

        String sql = """
            SELECT
                hd.Ngay,
                ct.SoLuongSanPham,
                hd.SoHoaDon,
                hd.DoanhThu
            FROM
            (
                SELECT
                    CAST(NgayLap AS DATE) AS Ngay,
                    COUNT(*) AS SoHoaDon,
                    SUM(TongTien) AS DoanhThu
                FROM HoaDon
                GROUP BY CAST(NgayLap AS DATE)
            ) hd
            JOIN
            (
                SELECT
                    CAST(h.NgayLap AS DATE) AS Ngay,
                    SUM(ct.SoLuong) AS SoLuongSanPham
                FROM HoaDon h
                JOIN ChiTietHoaDon ct
                    ON h.MaHD = ct.MaHD
                GROUP BY CAST(h.NgayLap AS DATE)
            ) ct
            ON hd.Ngay = ct.Ngay
            ORDER BY hd.DoanhThu DESC
            """;

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ThongKeDoanhThu tk = new ThongKeDoanhThu(
                        rs.getDate("Ngay"),
                        rs.getInt("SoLuongSanPham"),
                        rs.getInt("SoHoaDon"),
                        rs.getDouble("DoanhThu")
                );

                ds.add(tk);
            }
            return ds;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp doanh thu giảm dần", e);
        }
    }
}
