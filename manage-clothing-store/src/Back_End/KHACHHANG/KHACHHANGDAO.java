/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KHACHHANG;

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
public class KHACHHANGDAO implements DAOInterface<KHACHHANG>{
	public static KHACHHANGDAO getInstance() {
		return new KHACHHANGDAO();
	}
	@Override
	public int insert(KHACHHANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "INSERT INTO KHACHHANG(MAKH, TENKH, SDTKH, DIACHIKH, TRANGTHAI) " +
			             " VALUES(?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKH());
			pst.setString(2, t.getTenKH());
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
	public int delete(KHACHHANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "DELETE FROM KHACHHANG " +
			             " WHERE MAKH=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKH());
						
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
	public int update(KHACHHANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "UPDATE KHACHHANG " +
			             " SET TENKH=?" +
					     ", SDTKH=?" +
			             ", DIACHIKH=?" +
					     ", TRANGTHAI=?" +
					     " WHERE MAKH=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenKH());
			pst.setString(2, t.getSdt());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getTrangThai());
			pst.setString(5, t.getMaKH());
			
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
	public ArrayList<KHACHHANG> selectAll() {
		ArrayList<KHACHHANG> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			 
			String sql = "SELECT * FROM KHACHHANG";
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getNString("TENKH");
				String sdt = rs.getString("SDTKH");
				String diaChi = rs.getNString("DIACHIKH");
				String trangThai = rs.getString("TRANGTHAI");
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi, trangThai);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KHACHHANG selectById(KHACHHANG t) {
		KHACHHANG ketQua = null;
		
		try {
			Connection c = connec.getConnection();
			
			String sql = "SELECT * FROM KHACHHANG WHERE MAKH=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKH());
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getNString("TENKH");
				String sdt = rs.getString("SDTKH");
				String diaChi = rs.getNString("DIACHIKH");
				String trangThai = rs.getString("TRANGTHAI");
				
				ketQua = new KHACHHANG(maKH, tenKH, sdt, diaChi, trangThai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KHACHHANG> selectByCondition(String condition) {
		ArrayList<KHACHHANG> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			 
			String sql = "SELECT * FROM KHACHHANG WHERE " + condition;
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getNString("TENKH");
				String sdt = rs.getString("SDTKH");
				String diaChi = rs.getNString("DIACHIKH");
				String trangThai = rs.getString("TRANGTHAI");
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi, trangThai);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        
        public ArrayList<KHACHHANG> selectByID(String id) {
		ArrayList<KHACHHANG> ketQua = new ArrayList<>();
		try {
			Connection conn = connec.getConnection();
			
			String sql = "SELECT * FROM KHACHHANG WHERE MAKH='" + id + "'";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getNString("TENKH");
				String sdt = rs.getString("SDTKH");
				String diaChi = rs.getNString("DIACHIKH");
				String trangThai = rs.getString("TRANGTHAI");
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi, trangThai);
				ketQua.add(a);
			}
			
			connec.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        
        public ArrayList<KHACHHANG> selectByName(String name) {
            ArrayList<KHACHHANG> ketQua = new ArrayList<>();
		try {
			Connection conn = connec.getConnection();
			
			String sql = "SELECT * FROM KHACHHANG WHERE TENKH='" + name + "'";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MAKH");
				String tenKH = rs.getNString("TENKH");
				String sdt = rs.getString("SDTKH");
				String diaChi = rs.getNString("DIACHIKH");
				String trangThai = rs.getString("TRANGTHAI");
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi, trangThai);
				ketQua.add(a);
			}
			
			connec.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
        }
}
