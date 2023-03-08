/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHANVIEN;

import connectDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NGOC THUC
 */
public class NHANVIENDAO {

    Connection con = ConnectionDB.getConnection();

    public NHANVIENDAO() {

    }

    public ArrayList<NHANVIEN> get() {
        ArrayList<NHANVIEN> dsnv = new ArrayList<>();
        try {
            String query = "select * from NHANVIEN";//+
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("maNV");//+
                String tenNV = rs.getString("tenNV");//+
                String diaChi = rs.getString("diaChi");//+
                String sdt = rs.getString("sdt");
                String thuongHieu = rs.getString("thuongHieu");
                NHANVIEN nv = new NHANVIEN(maNV, tenNV, diaChi, sdt, thuongHieu);//+
                dsnv.add(nv);//+
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con);
        }
        return dsnv;
    }
    
    public void add(NHANVIEN nv) {
        try {
            String query = "INSERT INTO NHANVIEN VALUES (?,?,?,?);";//++
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, nv.getMaNV());//+
            st.setString(2, nv.getTenNV());//+
            st.setString(3, nv.getDiaChi());//+
            st.setString(4, nv.getSdt());//+
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }
    
    public void update(String maNV, NHANVIEN nv) {
        try {
            String query = "UPDATE NHANVIEN SET maNV = ?, tenNV = ?, diaChi = ?, sdt = ? WHERE maNV=?";//+
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, nv.getMaNV());//+
            st.setString(2, nv.getTenNV());//+
            st.setString(3, nv.getDiaChi());//+
            st.setString(4, nv.getSdt());//+
            st.setString(5,maNV);//+
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }
    
    public void delete(String maNV) {
        try {
            String query = "DELETE FROM NHANVIEN WHERE maNV=?;";//+
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, maNV);//+
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }
}
