/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ChiTietHoaDonDao;
import model.ChiTietHoaDon;
import exception.DatabaseException;
import exception.NotFoundException;

import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ChiTietHoaDonService {
    private ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();

    // Lấy danh sách chi tiết hóa đơn theo mã hóa đơn
    public ArrayList<ChiTietHoaDon> getByMaHoaDon(String maHD) {
        try {
            return chiTietHoaDonDao.getByMaHD(maHD);

        } catch (NotFoundException e) {
            System.out.println("Không có chi tiết hóa đơn: " + maHD);
            return new ArrayList<>();

        } catch (DatabaseException e) {
            System.out.println("Lỗi lấy chi tiết hóa đơn: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
