/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ThongKeDoanhThuDao;
import model.ThongKeDoanhThu;
import exception.DatabaseException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ThongKeDoanhThuService {
    private ThongKeDoanhThuDao thongKeDao = new ThongKeDoanhThuDao();

    // 1. Lấy danh sách thống kê doanh thu
    public ArrayList<ThongKeDoanhThu> getAll() {
        try {
            return thongKeDao.getAll();

        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy thống kê doanh thu: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // 2. Sắp xếp doanh thu tăng dần
    public ArrayList<ThongKeDoanhThu> sapXepDoanhThuTangDan() {
        try {
            return thongKeDao.sapXepDoanhThuTangDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp doanh thu tăng dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // 3. Sắp xếp doanh thu giảm dần
    public ArrayList<ThongKeDoanhThu> sapXepDoanhThuGiamDan() {
        try {
            return thongKeDao.sapXepDoanhThuGiamDan();

        } catch (DatabaseException e) {
            System.out.println("Lỗi sắp xếp doanh thu giảm dần: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
