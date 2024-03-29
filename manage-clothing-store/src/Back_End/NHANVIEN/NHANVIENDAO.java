/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHANVIEN;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;
import javax.swing.JOptionPane;

/**
 *
 * @author NGOC THUC
 */
public class NHANVIENDAO implements DAOInterface<NHANVIEN> {

    public static NHANVIENDAO getInstance() {
        return new NHANVIENDAO();
    }

    @Override
    public int insert(NHANVIEN t) {
        int ketQua = 0;
        try {
            Connection conn = connec.getConnection();

            String sql = "INSERT INTO NHANVIEN (MANV, TENNV, NGAYSINH, SDTNV, DIACHINV, TRANGTHAI) "
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getTenNV());

            String ngay = t.getNgaySinh();
            Date date = Date.valueOf(ngay);
            pst.setDate(3, date);

            pst.setString(4, t.getSdt());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getTrangThai());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public int delete(NHANVIEN t) {
        int ketQua;
        try {
            Connection conn = connec.getConnection();

            String sql = "UPDATE NHANVIEN SET TRANGTHAI = ('Đã Xóa') "
                    + " WHERE MANV=? ";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, t.getMaNV());
            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(conn);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    @Override
    public int update(NHANVIEN t) {
        int ketQua = 0;
        try {
            Connection conn = connec.getConnection();

            String sql = "UPDATE NHANVIEN "
                    + " SET TENNV=?"
                    + ", NGAYSINH=?"
                    + ", SDTNV=?"
                    + ", DIACHINV=?"
                    + ", TRANGTHAI=?"
                    + " WHERE MANV=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, t.getTenNV());

            String ngay = t.getNgaySinh();
            Date date = Date.valueOf(ngay);
            pst.setDate(2, date);

            pst.setString(3, t.getSdt());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getTrangThai());
            pst.setString(6, t.getMaNV());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(conn);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public boolean insertArray(ArrayList<NHANVIEN> listNV) {
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO  NHANVIEN(MANV, TENNV, NGAYSINH, SDTNV, DIACHINV, TRANGTHAI) "
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            for (NHANVIEN t : listNV) {
                pst.setString(1, t.getMaNV());
                pst.setString(2, t.getTenNV());

                String ngay = t.getNgaySinh();
                Date date = Date.valueOf(ngay);
                pst.setDate(3, date);

                pst.setString(4, t.getSdt());
                pst.setString(5, t.getDiaChi());
                pst.setString(6, t.getTrangThai());

                pst.executeUpdate();
            }

            connec.closeConnection(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu xuống bảng NHANVIEN");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<NHANVIEN> selectAll() {
        ArrayList<NHANVIEN> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            Statement st = conn.createStatement();

            String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI NOT IN ('Đã Xóa')";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("MANV");
                String tenNV = rs.getNString("TENNV");
                String ngaySinh = String.valueOf(rs.getDate("NGAYSINH"));
                String diaChi = rs.getNString("DIACHINV");
                String sdt = rs.getString("SDTNV");
                String trangThai = rs.getString("TRANGTHAI");

                NHANVIEN a = new NHANVIEN(maNV, tenNV, ngaySinh, sdt, diaChi, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NHANVIEN selectById(NHANVIEN t) {
        NHANVIEN ketQua = null;
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHANVIEN "
                    + " WHERE MANV=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNV());

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("MANV");
                String tenNV = rs.getNString("TENNV");
                String ngaySinh = String.valueOf(rs.getDate("NGAYSINH"));
                String diaChi = rs.getNString("DIACHINV");
                String sdt = rs.getString("SDTNV");
                String trangThai = rs.getString("TRANGTHAI");

                ketQua = new NHANVIEN(maNV, tenNV, ngaySinh, sdt, diaChi, trangThai);
            }

            connec.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NHANVIEN> selectByCondition(String condition) {
        ArrayList<NHANVIEN> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHANVIEN WHERE " + condition;

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("MANV");
                String tenNV = rs.getNString("TENNV");
                String ngaySinh = String.valueOf(rs.getDate("NGAYSINH"));
                String diaChi = rs.getNString("DIACHINV");
                String sdt = rs.getString("SDTNV");
                String trangThai = rs.getString("TRANGTHAI");

                NHANVIEN a = new NHANVIEN(maNV, tenNV, ngaySinh, sdt, diaChi, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<NHANVIEN> selectByID(String id) {
        ArrayList<NHANVIEN> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHANVIEN WHERE MANV LIKE '%" + id + "%'";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("MANV");
                String tenNV = rs.getNString("TENNV");
                String ngaySinh = String.valueOf(rs.getDate("NGAYSINH"));
                String diaChi = rs.getNString("DIACHINV");
                String sdt = rs.getString("SDTNV");
                String trangThai = rs.getString("TRANGTHAI");

                NHANVIEN a = new NHANVIEN(maNV, tenNV, ngaySinh, sdt, diaChi, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<NHANVIEN> selectByName(String name) {
        ArrayList<NHANVIEN> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHANVIEN WHERE TENNV LIKE '%" + name + "%'";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("MANV");
                String tenNV = rs.getNString("TENNV");
                String ngaySinh = String.valueOf(rs.getDate("NGAYSINH"));
                String diaChi = rs.getNString("DIACHINV");
                String sdt = rs.getString("SDTNV");
                String trangThai = rs.getString("TRANGTHAI");

                NHANVIEN a = new NHANVIEN(maNV, tenNV, ngaySinh, sdt, diaChi, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
