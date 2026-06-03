/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa khách hàng
    public boolean delete(String maKH) {

        String sql = "DELETE FROM KhachHang WHERE maKH = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maKH);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Tìm khách hàng theo mã
    public KhachHang findById(String maKH) {

        String sql = "SELECT * FROM KhachHang WHERE maKH = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maKH);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("sdt"),
                        rs.getString("diaChi")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
