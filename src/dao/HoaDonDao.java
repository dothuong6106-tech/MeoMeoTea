/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.HoaDon;
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
public class HoaDonDao {
    // Xem tất cả hóa đơn
    public ArrayList<HoaDon> getAll() {

        ArrayList<HoaDon> ds = new ArrayList<>();

        String sql = "SELECT * FROM HoaDon";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                HoaDon hd = new HoaDon(
                        rs.getString("maHD"),
                        rs.getTimestamp("ngayLap"),
                        rs.getDouble("tongTien"),
                        rs.getString("maKH"),
                        rs.getString("maNV")
                );

                ds.add(hd);
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy danh sách hóa đơn", e);
        }
    }

    // Tìm hóa đơn theo mã
    public HoaDon findById(String maHD) {

        String sql = "SELECT * FROM HoaDon WHERE maHD = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maHD);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new HoaDon(
                        rs.getString("maHD"),
                        rs.getTimestamp("ngayLap"),
                        rs.getDouble("tongTien"),
                        rs.getString("maKH"),
                        rs.getString("maNV")
                );
            }
            throw new NotFoundException("Không tìm thấy hóa đơn: " + maHD);

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi tìm hóa đơn theo mã", e);
        }
    }

    // Sắp xếp tổng tiền tăng dần
    public ArrayList<HoaDon> sapXepTongTienTangDan() {

        ArrayList<HoaDon> ds = new ArrayList<>();

        String sql =
                "SELECT * FROM HoaDon ORDER BY tongTien ASC";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new HoaDon(
                        rs.getString("maHD"),
                        rs.getTimestamp("ngayLap"),
                        rs.getDouble("tongTien"),
                        rs.getString("maKH"),
                        rs.getString("maNV")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp hóa đơn tăng dần", e);
        }
    }

    // Sắp xếp tổng tiền giảm dần
    public ArrayList<HoaDon> sapXepTongTienGiamDan() {

        ArrayList<HoaDon> ds = new ArrayList<>();

        String sql =
                "SELECT * FROM HoaDon ORDER BY tongTien DESC";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new HoaDon(
                        rs.getString("maHD"),
                        rs.getTimestamp("ngayLap"),
                        rs.getDouble("tongTien"),
                        rs.getString("maKH"),
                        rs.getString("maNV")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp hóa đơn giảm dần", e);
        }
    }
}
