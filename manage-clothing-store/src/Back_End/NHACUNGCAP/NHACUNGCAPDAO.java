/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHACUNGCAP;

import java.sql.Connection;
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
public class NHACUNGCAPDAO implements DAOInterface<NHACUNGCAP> {

    public static NHACUNGCAPDAO getInstance() {
        return new NHACUNGCAPDAO();
    }
    
     public boolean insertArray(ArrayList<NHACUNGCAP> listNV) {
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO  NHACUNGCAP(MANCC, TENNCC,  SDTNCC, DIACHINCC, TRANGTHAI) "
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            for (NHACUNGCAP t : listNV) {
                pst.setString(1, t.getMaNCC());
                pst.setString(2, t.getTenNCC());

                pst.setString(3, t.getSdt());
                pst.setString(4, t.getDiaChi());
                pst.setString(5, t.getTrangThai());

                pst.executeUpdate();
            }

            connec.closeConnection(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu xuống bảng NHACUNGCAP");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int insert(NHACUNGCAP t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO NHACUNGCAP(MANCC, TENNCC, SDTNCC, DIACHINCC, TRANGTHAI) "
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            pst.setString(2, t.getTenNCC());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getTrangThai());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(NHACUNGCAP t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE FROM NHACUNGCAP SET TRANGTHAI =( 'Đã Xóa')"
                    + " WHERE MANCC=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(NHACUNGCAP t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE NHACUNGCAP "
                    + " SET TENNCC=?"
                    + ", SDTNCC=?"
                    + ", DIACHINCC=?"
                    + ", TRANGTHAI=?"
                    + " WHERE MANCC=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getTenNCC());
            pst.setString(2, t.getSdt());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getTrangThai());
            pst.setString(5, t.getMaNCC());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<NHACUNGCAP> selectAll() {
        ArrayList<NHACUNGCAP> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM NHACUNGCAP WHERE  TRANGTHAI NOT IN ( 'Đã Xóa')";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getNString("TENNCC");
                String sdtNCC = rs.getString("SDTNCC");
                String diachiNCC = rs.getNString("DIACHINCC");
                String trangThai = rs.getString("TRANGTHAI");

                NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NHACUNGCAP selectById(NHACUNGCAP t) {
        NHACUNGCAP ketQua = null;
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getNString("TENNCC");
                String sdtNCC = rs.getString("SDTNCC");
                String diachiNCC = rs.getNString("DIACHINCC");
                String trangThai = rs.getString("TRANGTHAI");

                ketQua = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC, trangThai);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NHACUNGCAP> selectByCondition(String condition) {
        ArrayList<NHACUNGCAP> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM NHACUNGCAP WHERE " + condition;
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getNString("TENNCC");
                String sdtNCC = rs.getString("SDTNCC");
                String diachiNCC = rs.getNString("DIACHINCC");
                String trangThai = rs.getString("TRANGTHAI");

                NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<NHACUNGCAP> selectByID(String id) {
        ArrayList<NHACUNGCAP> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC LIKE '%" + id + "%'";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getNString("TENNCC");
                String sdtNCC = rs.getString("SDTNCC");
                String diachiNCC = rs.getNString("DIACHINCC");
                String trangThai = rs.getString("TRANGTHAI");

                NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<NHACUNGCAP> selectByName(String name) {
        ArrayList<NHACUNGCAP> ketQua = new ArrayList<>();
        try {
            Connection conn = connec.getConnection();

            String sql = "SELECT * FROM NHACUNGCAP WHERE TENNCC LIKE '%" + name + "%'";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getNString("TENNCC");
                String sdtNCC = rs.getString("SDTNCC");
                String diachiNCC = rs.getNString("DIACHINCC");
                String trangThai = rs.getString("TRANGTHAI");

                NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC, trangThai);
                ketQua.add(a);
            }

            connec.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
