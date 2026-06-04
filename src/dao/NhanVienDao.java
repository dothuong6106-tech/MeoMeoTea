/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import model.NhanVien;
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
public class NhanVienDao {
    // Xem danh sách nhân viên
    public ArrayList<NhanVien> getAll() {

        ArrayList<NhanVien> ds = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                NhanVien nv = new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("sdt"),
                        rs.getString("chucVu"),
                        rs.getDouble("luong")
                );

                ds.add(nv);
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi lấy danh sách nhân viên", e);
        }
    }

    // Thêm nhân viên
    public boolean insert(NhanVien nv) {

        String sql = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getSdt());
            ps.setString(4, nv.getChucVu());
            ps.setDouble(5, nv.getLuong());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi thêm nhân viên", e);
        }
    }

    // Sửa nhân viên
    public boolean update(NhanVien nv) {

        String sql = """
                     UPDATE NhanVien
                     SET tenNV = ?,
                         sdt = ?,
                         chucVu = ?,
                         luong = ?
                     WHERE maNV = ?
                     """;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getChucVu());
            ps.setDouble(4, nv.getLuong());
            ps.setString(5, nv.getMaNV());

             int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy nhân viên: " + nv.getMaNV());
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi cập nhật nhân viên", e);
        }
    }

    // Xóa nhân viên
    public boolean delete(String maNV) {

        String sql = "DELETE FROM NhanVien WHERE maNV = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maNV);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new NotFoundException("Không tìm thấy nhân viên: " + maNV);
            }

            return true;

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi xóa nhân viên", e);
        }
    }

    // Tìm nhân viên theo mã
    public NhanVien findById(String maNV) {

        String sql = "SELECT * FROM NhanVien WHERE maNV = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, maNV);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("sdt"),
                        rs.getString("chucVu"),
                        rs.getDouble("luong")
                );
            }
            throw new NotFoundException("Không tìm thấy nhân viên: " + maNV);

        } catch (SQLException e) {
            throw new DatabaseException("Lỗi tìm nhân viên theo mã", e);
        }
    }

    // Sắp xếp lương tăng dần
    public ArrayList<NhanVien> sapXepLuongTangDan() {

        ArrayList<NhanVien> ds = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien ORDER BY luong ASC";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("sdt"),
                        rs.getString("chucVu"),
                        rs.getDouble("luong")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp lương tăng dần", e);
        }
    }

    // Sắp xếp lương giảm dần
    public ArrayList<NhanVien> sapXepLuongGiamDan() {

        ArrayList<NhanVien> ds = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien ORDER BY luong DESC";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ds.add(new NhanVien(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("sdt"),
                        rs.getString("chucVu"),
                        rs.getDouble("luong")
                ));
            }
            return ds;
        } catch (SQLException e) {
            throw new DatabaseException("Lỗi sắp xếp lương giảm dần", e);
        }
    }
}
