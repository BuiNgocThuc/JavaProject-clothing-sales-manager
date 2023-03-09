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
			
			String sql = "INSERT INTO KHACHHANG(MAKH, TENKH, SDTKH, DIACHIKH) " +
			             " VALUES(?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKH());
			pst.setString(2, t.getTenKH());
			pst.setString(3, t.getSdt());
			pst.setString(4, t.getDiaChi());
			
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
					     " WHERE MAKH=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenKH());
			pst.setString(2, t.getSdt());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getMaKH());
			
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
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi);
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
				
				ketQua = new KHACHHANG(maKH, tenKH, sdt, diaChi);
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
				
				KHACHHANG a = new KHACHHANG(maKH, tenKH, sdt, diaChi);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
