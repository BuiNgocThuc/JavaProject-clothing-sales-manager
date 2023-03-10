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
public class TAIKHOANDAO implements DAOInterface<TAIKHOAN>{
	public static TAIKHOANDAO getInstance() {
		return new TAIKHOANDAO();
	}
	@Override
	public int insert(TAIKHOAN t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "INSERT INTO TAIKHOAN(Username, matKhau, MaQuyen) " +
			             " VALUES(?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getUserName());
			pst.setString(2, t.getPassWord());
			pst.setString(3, t.getMaQuyen());
			
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
	public int delete(TAIKHOAN t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "DELETE FROM TAIKHOAN " +
			             " WHERE Username=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getUserName());
			
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
	public int update(TAIKHOAN t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			
			String sql = "UPDATE TAIKHOAN " +
			             " SET matKhau=?" +
					     ", MaQuyen=?" +
			             " WHERE Username=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getMaQuyen());
			pst.setString(3, t.getUserName());
			
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
	public ArrayList<TAIKHOAN> selectAll() {
		ArrayList<TAIKHOAN> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			Statement st = c.createStatement();
			String sql = "SELECT * FROM TAIKHOAN";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String userName = rs.getString("Username");
				String passWord = rs.getString("matKhau");
				String maQuyen = rs.getString("MaQuyen");
				
				TAIKHOAN a = new TAIKHOAN(userName, passWord, maQuyen);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
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
				
				ketQua = new TAIKHOAN(userName, passWord, maQuyen);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
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
