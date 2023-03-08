/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NGOC THUC
 */
public class ConnectionDB {

    static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBQA";
    static String userName = "sa";
    static String password = "123456";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
        }
    }
}
