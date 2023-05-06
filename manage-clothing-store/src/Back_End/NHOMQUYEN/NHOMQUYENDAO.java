/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHOMQUYEN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

/**
 *
 * @author NGOC THUC
 */
public class NHOMQUYENDAO implements DAOInterface<NHOMQUYEN> {

    public static NHOMQUYENDAO getInstance() {
        return new NHOMQUYENDAO();
    }

    @Override
    public int insert(NHOMQUYEN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO NHOMQUYEN(MAQUYEN, TENQUYEN, MOTAQUYEN, TRANGTHAI) "
                    + " VALUES(?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());
            pst.setString(2, t.getTenQuyen());
            pst.setString(3, t.getMoTaQuyen());
            pst.setString(4, t.getTrangThai());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCount() {
        int count = 0;
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "select COUNT(*) as count from NHOMQUYEN";
            ResultSet rs = st.executeQuery(sql);
            
             while (rs.next()) {
               count = rs.getInt("count");
            }
            
            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(NHOMQUYEN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE NHOMQUYEN "
                    + "SET TRANGTHAI = 'Đã Xóa' "
                    + "WHERE MAQUYEN=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(NHOMQUYEN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE NHOMQUYEN "
                    + " SET TENQUYEN=?"
                    + ", MOTAQUYEN=?"
                    + ", TRANGTHAI=?"
                    + " WHERE MAQUYEN=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getTenQuyen());
            pst.setString(2, t.getMoTaQuyen());
            pst.setString(3, t.getTrangThai());
            pst.setString(4, t.getMaQuyen());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public ArrayList<NHOMQUYEN> selectAll() {
        ArrayList<NHOMQUYEN> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "select * from NHOMQUYEN where TRANGTHAI NOT IN ('Đã Xóa')";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maQuyen = rs.getString("MAQUYEN");
                String tenQuyen = rs.getNString("TENQUYEN");
                String moTaQuyen = rs.getNString("MOTAQUYEN");
                String trangThai = rs.getNString("TRANGTHAI");

                NHOMQUYEN a = new NHOMQUYEN(maQuyen, tenQuyen, moTaQuyen, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public NHOMQUYEN selectById(NHOMQUYEN t) {
        NHOMQUYEN ketQua = null;
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM NHOMQUYEN WHERE MAQUYEN=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maQuyen = rs.getString("MAQUYEN");
                String tenQuyen = rs.getNString("TENQUYEN");
                String moTaQuyen = rs.getNString("MOTAQUYEN");
                String trangThai = rs.getNString("TRANGTHAI");

                ketQua = new NHOMQUYEN(maQuyen, tenQuyen, moTaQuyen, trangThai);
            }

            connec.closeConnection(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NHOMQUYEN> selectByCondition(String condition) {
        ArrayList<NHOMQUYEN> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM NHOMQUYEN WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maQuyen = rs.getString("MAQUYEN");
                String tenQuyen = rs.getNString("TENQUYEN");
                String moTaQuyen = rs.getNString("MOTAQUYEN");
                String trangThai = rs.getString("TRANGTHAI");

                NHOMQUYEN a = new NHOMQUYEN(maQuyen, tenQuyen, moTaQuyen, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

}
