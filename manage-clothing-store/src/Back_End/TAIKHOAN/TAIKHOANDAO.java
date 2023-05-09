/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.TAIKHOAN;

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
public class TAIKHOANDAO {

    PreparedStatement pstm = null;

    public static TAIKHOANDAO getInstance() {
        return new TAIKHOANDAO();
    }

    public String getNameByUsername(String Username) {
        String name = new String();
        Connection con = connec.getConnection();
        try {
            String query = "select * from NHANVIEN where MANV = ?";//+
            pstm = con.prepareStatement(query);
            pstm.setString(1, Username);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                name = rs.getString("TENNV");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connec.closeConnection(con);
        }
        return name;
    }

    public TAIKHOAN getByUserName(String username) {
        Connection con = connec.getConnection();
        try {
            String query = "select * from TAIKHOAN where Username = ?";//+
            pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String tenTaiKhoan = rs.getString("Username");//+
                String matKhau = rs.getString("matKhau");//+
                String maNhomQuyen = rs.getString("maQuyen");//+
                TAIKHOAN tk = new TAIKHOAN(tenTaiKhoan, matKhau, maNhomQuyen);
                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connec.closeConnection(con);
        }
        return null;
    }

    public String getTrangThaiByMaTk(String Username) {
        Connection con = connec.getConnection();
        try {
            String query = "select TRANGTHAI from TAIKHOAN where Username = ?";//+
            pstm = con.prepareStatement(query);
            pstm.setString(1, Username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String trangThai = rs.getString("TRANGTHAI");
                TAIKHOAN tk = new TAIKHOAN(trangThai);
                return tk.getTrangthai();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connec.closeConnection(con);
        }
        return null;
    }

    public int insert(TAIKHOAN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();

            String sql = "INSERT INTO TAIKHOAN(Username, matKhau, MaQuyen, TRANGTHAI) "
                    + " VALUES(?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getUserName());
            pst.setString(2, t.getPassWord());
            pst.setString(3, t.getMaQuyen());
            pst.setString(4, t.getTrangthai());

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

    public int delete(TAIKHOAN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();

            String sql = "UPDATE TAIKHOAN "
                    + "SET TRANGTHAI = 'Đã Xóa' "
                    + "WHERE Username=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getUserName());

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

    public int update(TAIKHOAN t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();

            String sql = "UPDATE TAIKHOAN "
                    + " SET matKhau=?"
                    + ", MaQuyen=?"
                    + ", TRANGTHAI=?"
                    + " WHERE Username=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getPassWord());
            pst.setString(2, t.getMaQuyen());
            pst.setString(3, t.getTrangthai());
            pst.setString(4, t.getUserName());

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

    public ArrayList<TAIKHOAN> selectAll() {
        ArrayList<TAIKHOAN> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM TAIKHOAN WHERE TRANGTHAI NOT IN ('Đã Xóa')";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String userName = rs.getString("Username");
                String passWord = rs.getString("matKhau");
                String maQuyen = rs.getString("MaQuyen");
                String trangthai = rs.getString("TRANGTHAI");

                TAIKHOAN a = new TAIKHOAN(userName, passWord, maQuyen);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public TAIKHOAN selectById(TAIKHOAN t) {
        TAIKHOAN ketQua = null;
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM TAIKHOAN WHERE Username=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getUserName());

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("Username");
                String passWord = rs.getString("matKhau");
                String maQuyen = rs.getString("MaQuyen");
                String trangthai = rs.getString("TRANGTHAI");

                ketQua = new TAIKHOAN(userName, passWord, maQuyen);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public ArrayList<TAIKHOAN> selectByCondition(String condition) {
        ArrayList<TAIKHOAN> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM TAIKHOAN WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String userName = rs.getString("Username");
                String passWord = rs.getString("matKhau");
                String maQuyen = rs.getString("MaQuyen");
                String trangthai = rs.getString("TRANGTHAI");

                TAIKHOAN a = new TAIKHOAN(userName, passWord, maQuyen);
                ketQua.add(a);
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
