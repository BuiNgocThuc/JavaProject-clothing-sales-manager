/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHUCNANG;

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
public class CHUCNANGDAO implements DAOInterface<CHUCNANG> {
	public static CHUCNANGDAO getInstance()
	{
		return new CHUCNANGDAO();
	}
	@Override
	public int insert(CHUCNANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO CHUCNANG(TENCN, MOTA) " +
			             " VALUES(?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenCN());
			pst.setString(2, t.getMoTa());
			
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
	public int delete(CHUCNANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM CHUCNANG " +
			             " WHERE TENCN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenCN());
			
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
	public int update(CHUCNANG t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE CHUCNANG " +
			             " SET MOTA=?" +
					     " WHERE TENCN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMoTa());
			pst.setString(2, t.getTenCN());
			
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
	public ArrayList<CHUCNANG> selectAll() {
		ArrayList<CHUCNANG> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			Statement st = c.createStatement(); 
			String sql = "SELECT * FROM CHUCNANG";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String tenCN = rs.getNString("TENCN");
				String moTa = rs.getNString("MOTA");
				
				CHUCNANG a = new CHUCNANG(tenCN, moTa);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public CHUCNANG selectById(CHUCNANG t) {
		CHUCNANG ketQua = null;
		try {
			Connection c = connec.getConnection();
			
			String sql = "SELECT * FROM CHUCNANG WHERE TENCN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenCN());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String tenCN = rs.getNString("TENCN");
				String moTa = rs.getNString("MOTA");
				
				ketQua = new CHUCNANG(tenCN, moTa);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<CHUCNANG> selectByCondition(String condition) {
		ArrayList<CHUCNANG> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			Statement st = c.createStatement(); 
			String sql = "SELECT * FROM CHUCNANG WHERE " + condition;
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String tenCN = rs.getNString("TENCN");
				String moTa = rs.getNString("MOTA");
				
				CHUCNANG a = new CHUCNANG(tenCN, moTa);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}
	

}
