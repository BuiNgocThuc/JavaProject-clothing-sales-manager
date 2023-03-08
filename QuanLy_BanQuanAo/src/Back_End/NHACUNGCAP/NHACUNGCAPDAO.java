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

/**
 *
 * @author NGOC THUC
 */
public class NHACUNGCAPDAO implements DAOInterface<NHACUNGCAP> {
	public static NHACUNGCAPDAO getInstance() {
		return new NHACUNGCAPDAO();
	}

	@Override
	public int insert(NHACUNGCAP t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO NHACUNGCAP(MANCC, TENNCC, SDTNCC, DIACHINCC) " +
			             " VALUES(?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaNCC());
			pst.setString(2, t.getTenNCC());
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
	public int delete(NHACUNGCAP t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM NHACUNGCAP " +
			             " WHERE MANCC=?";
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
			String sql = "UPDATE NHACUNGCAP " +
			             " SET TENNCC=?" +
					     ", SDTNCC=?" +
			             ", DIACHINCC=?" +
					     " WHERE MANCC=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenNCC());
			pst.setString(2, t.getSdt());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getMaNCC());
			
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
			String sql = "SELECT * FROM NHACUNGCAP";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maNCC = rs.getString("MANCC");
				String tenNCC = rs.getNString("TENNCC");
				String sdtNCC = rs.getString("SDTNCC");
				String diachiNCC = rs.getNString("DIACHINCC");
				
				NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC);
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
				
				ketQua = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC);
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
				
				NHACUNGCAP a = new NHACUNGCAP(maNCC, tenNCC, sdtNCC, diachiNCC);
				ketQua.add(a);
			}
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
