/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.KhachHang;
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
public class KhachHangDao {
    // Xem danh sách khách hàng
    public ArrayList<KhachHang> getAll() {

        ArrayList<KhachHang> ds = new ArrayList<>();

        String sql = "SELECT * FROM KhachHang";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KhachHang kh = new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("sdt"),
                        rs.getString("diaChi")
                );

                ds.add(kh);
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy danh sách khách hàng", e);
        }
    }

    // Thêm khách hàng
    public boolean insert(KhachHang kh) {

        String sql = "INSERT INTO KhachHang VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi thêm khách hàng", e);
        }
    }

    // Sửa khách hàng
    public boolean update(KhachHang kh) {

        String sql = """
                     UPDATE KhachHang
                     SET tenKH = ?,
                         sdt = ?,
                         diaChi = ?
                     WHERE maKH = ?
                     """;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getMaKH());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy khách hàng: " + kh.getMaKH());
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi cập nhật khách hàng", e);
        }
    }

    // Xóa khách hàng
    public boolean delete(String maKH) {

        String sql = "DELETE FROM KhachHang WHERE maKH = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maKH);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy khách hàng: " + maKH);
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi xóa khách hàng", e);
        }
    }

    // Tìm khách hàng theo mã
    public KhachHang findByName(String tenKH) {

        String sql = "SELECT * FROM KhachHang WHERE tenKH LIKE ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + tenKH + "%");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("sdt"),
                        rs.getString("diaChi")
                );
            }
            throw new NotFoundException("Không tìm thấy khách hàng: " + tenKH);

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi tìm khách hàng theo tên", e);
        }
    }
}
