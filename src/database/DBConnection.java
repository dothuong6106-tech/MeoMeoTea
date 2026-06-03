/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class DBConnection {
    private static final String URL =
            "jdbc:sqlserver://DOTHITHUONG123\\SQLEXPRESS:1433;"
            + "databaseName=MeoMeoTea;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASSWORD = "123456789";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("Kết nối SQL Server thành công!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

