/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.ChiTietHoaDon;
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
public class ChiTietHoaDonDao {
    // Lấy danh sách chi tiết theo mã hóa đơn
    public ArrayList<ChiTietHoaDon> getByMaHD(String maHD) {

        ArrayList<ChiTietHoaDon> ds = new ArrayList<>();

        String sql = "SELECT * FROM ChiTietHoaDon WHERE maHD = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maHD);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ChiTietHoaDon ct = new ChiTietHoaDon(
                        rs.getString("maHD"),
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuong"),
                        rs.getDouble("donGia"),
                        rs.getDouble("thanhTien")
                );

                ds.add(ct);
            }
            if (ds.isEmpty()) {
                throw new NotFoundException("Không có chi tiết hóa đơn cho mã: " + maHD);
            }

            return ds;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy chi tiết hóa đơn", e);
        }
    }
}
