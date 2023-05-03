/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.PHIEUNHAP;

import java.sql.Connection;
import java.sql.Date;
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
public class PHIEUNHAPDAO implements DAOInterface<PHIEUNHAP> {
	public static PHIEUNHAPDAO getInstance() {
		return new PHIEUNHAPDAO();
	}
	@Override
	public int insert(PHIEUNHAP t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO PHIEUNHAP(MAPN, PN_MNCC, PN_MANV, NGAYNHAP, PN_TONGTIEN) " +
			             " VALUES(?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaPN());
			pst.setString(2, t.getMaNCC());
			pst.setString(3, t.getMaNV());
			String ngayString = t.getNgayNhap();
			Date date = Date.valueOf(ngayString);
			pst.setDate(4, date);
			pst.setFloat(5, t.getTongTien());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(PHIEUNHAP t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM PHIEUNHAP " +
			             " WHERE MAPN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaPN());
			
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
	public int update(PHIEUNHAP t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE PHIEUNHAP " +
			             " SET PN_MNCC=?" +
					     ", PN_MANV=?" +
			             ", NGAYNHAP=?" +
					     ", PN_TONGTIEN=?" +
			             " WHERE MAPN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getMaNCC());
			pst.setString(2, t.getMaNV());
			String ngayString = t.getNgayNhap();
			Date date = Date.valueOf(ngayString);
			pst.setDate(3, date);
			pst.setFloat(4, t.getTongTien());
			pst.setString(5, t.getMaPN());
			
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
	public ArrayList<PHIEUNHAP> selectAll() {
		ArrayList< PHIEUNHAP> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM PHIEUNHAP";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("MAPN");
				String maNCC = rs.getString("PN_MANCC");
				String maNV = rs.getString("PN_MANV"); 
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("PN_TONGTIEN");
				
				PHIEUNHAP a = new PHIEUNHAP(maPN, maNV, maNCC, ngayNhap, tongTien);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public PHIEUNHAP selectById(PHIEUNHAP t) {
		PHIEUNHAP ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM PHIEUNHAP WHERE MAPN=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaPN());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("MAPN");
				String maNCC = rs.getString("PN_MANCC");
				String maNV = rs.getString("PN_MANV"); 
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("PN_TONGTIEN");
				
				ketQua = new PHIEUNHAP(maPN, maNV, maNCC, ngayNhap, tongTien);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<PHIEUNHAP> selectByCondition(String condition) {
		ArrayList< PHIEUNHAP> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM PHIEUNHAP WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maPN = rs.getString("MAPN");
				String maNCC = rs.getString("PN_MANCC");
				String maNV = rs.getString("PN_MANV"); 
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("PN_TONGTIEN");
				
				PHIEUNHAP a = new PHIEUNHAP(maPN, maNV, maNCC, ngayNhap, tongTien);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
}
