/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTPhanQuyen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

/**
 *
 * @author NGOC THUC
 */
public class CTPhanQuyenDAO implements DAOInterface<CTPhanQuyen> {

    public static CTPhanQuyenDAO getInstance() {
        return new CTPhanQuyenDAO();
    }
    
    PreparedStatement pstm = null;

    public ArrayList<String> getListCTQByNQuyen(String nhomQuyen) {
        Connection con = connec.getConnection();
        ArrayList<String> dsctq = new ArrayList<>();//+
        try {
            String query = "select CTPQ_MACN from CHITIETPHANQUYEN where CTPQ_MAQUYEN = ?";//+
            pstm = con.prepareStatement(query);
            pstm.setString(1, nhomQuyen);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String maQuyen = rs.getString("CTPQ_MACN");//+ 
                dsctq.add(maQuyen);//+
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connec.closeConnection(con);
        }
        return dsctq;
    }

    @Override
    public int insert(CTPhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO CHITIETPHANQUYEN(CTPQ_MAQUYEN, CTPQ_MACN) "
                    + " VALUES(?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());
            pst.setString(2, t.getMaChucNang());

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
    public int delete(CTPhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "DELETE FROM CHITIETPHANQUYEN "
                    + " WHERE CTPQ_MAQUYEN=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());

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
    public int update(CTPhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE CHITIETPHANQUYEN "
                    + " SET CTPQ_TENCN=?"
                    + " WHERE CTPQ_MAQUYEN=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaChucNang());
            pst.setString(2, t.getMaQuyen());

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
    public ArrayList<CTPhanQuyen> selectAll() {
        ArrayList<CTPhanQuyen> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM CHITIETPHANQUYEN";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maQuyen = rs.getString("CTPQ_MAQUYEN");
                String tenChucNang = rs.getNString("CTPQ_TENCN");

                CTPhanQuyen a = new CTPhanQuyen(maQuyen, tenChucNang);
                ketQua.add(a);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public CTPhanQuyen selectById(CTPhanQuyen t) {
        CTPhanQuyen ketQua = null;
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM CHITIETPHANQUYEN WHERE CTPQ_MAQUYEN=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaQuyen());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maQuyen = rs.getString("CTPQ_MAQUYEN");
                String tenChucNang = rs.getNString("CTPQ_TENCN");

                ketQua = new CTPhanQuyen(maQuyen, tenChucNang);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<CTPhanQuyen> selectByCondition(String condition) {
        ArrayList<CTPhanQuyen> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM CHITIETPHANQUYEN WHERE " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maQuyen = rs.getString("CTPQ_MAQUYEN");
                String tenChucNang = rs.getNString("CTPQ_TENCN");

                CTPhanQuyen a = new CTPhanQuyen(maQuyen, tenChucNang);
                ketQua.add(a);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
}
