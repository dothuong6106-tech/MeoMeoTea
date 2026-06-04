/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.HoaDonDao;
import model.HoaDon;
import exception.DatabaseException;
import exception.NotFoundException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class HoaDonService {
    private HoaDonDao hoaDonDao = new HoaDonDao();

    // 1. Lấy danh sách hóa đơn
    public ArrayList<HoaDon> getAllHoaDon() {
        try {
            return hoaDonDao.getAll();

        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy danh sách hóa đơn: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // 2. Tìm hóa đơn theo mã
    public HoaDon timTheoMa(String maHD) {
        try {
            return hoaDonDao.findById(maHD);

        } catch (NotFoundException e) {
            System.out.println("Không tìm thấy hóa đơn: " + maHD);
            return null;

        } catch (DatabaseException e) {
            System.out.println("Lỗi tìm hóa đơn: " + e.getMessage());
            return null;
        }
    }

    // 3. Sắp xếp tổng tiền tăng dần
    public ArrayList<HoaDon> sapXepTongTienTangDan() {
        try {
            return hoaDonDao.sapXepTongTienTangDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp tăng dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // 4. Sắp xếp tổng tiền giảm dần
    public ArrayList<HoaDon> sapXepTongTienGiamDan() {
        try {
            return hoaDonDao.sapXepTongTienGiamDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp giảm dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
