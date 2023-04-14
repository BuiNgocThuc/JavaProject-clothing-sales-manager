/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.HOADON;

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
public class HOADONDAO implements DAOInterface<HOADON> {
	public static HOADONDAO getInstance() {
		return new HOADONDAO();
	}
	@Override
	public int insert(HOADON t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO HOADON(MAHD, HD_MAKH, HD_MANV, NGAYNHAP, HD_TONGTIEN) " +
			             " VALUES(?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaHD());
			pst.setString(2, t.getMaKH());
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
		return 0;
	}

	@Override
	public int delete(HOADON t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM HOADON " +
			             " WHERE MAHD=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaHD());
			
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
	public int update(HOADON t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE HOADON " +
			             " SET HD_MAKH=?" + 
					     ", HD_MANV=?" +
			             ", NGAYNHAP=?" +
					     ", HD_TONGTIEN=?" +
			             " WHERE MAHD=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKH());
			pst.setString(2, t.getMaNV());
			String ngayString = t.getNgayNhap();
			Date date = Date.valueOf(ngayString);
			pst.setDate(3, date);
			pst.setFloat(4, t.getTongTien());
			pst.setString(5, t.getMaHD());
			
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
	public ArrayList<HOADON> selectAll() {
		ArrayList<HOADON> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM HOADON";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("MAHD");
				String maKH = rs.getString("HD_MAKH");
				String maNV = rs.getString("HD_MANV");
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("HD_TONGTIEN");
				
				HOADON a = new HOADON(maHD, maNV, maKH, ngayNhap, tongTien);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public HOADON selectById(HOADON t) {
		HOADON ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM HOADON WHERE MAHD=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaHD());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("MAHD");
				String maKH = rs.getString("HD_MAKH");
				String maNV = rs.getString("HD_MANV");
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("HD_TONGTIEN");
				
				ketQua = new HOADON(maHD, maNV, maKH, ngayNhap, tongTien);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<HOADON> selectByCondition(String condition) {
		ArrayList<HOADON> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM HOADON WHERE" + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("MAHD");
				String maKH = rs.getString("HD_MAKH");
				String maNV = rs.getString("HD_MANV");
				String ngayNhap = String.valueOf(rs.getDate("NGAYNHAP"));
				Float tongTien = rs.getFloat("HD_TONGTIEN");
				
				HOADON a = new HOADON(maHD, maNV, maKH, ngayNhap, tongTien);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    
	public String selectTenKH(String maKH) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENKH FROM HOADON JOIN KHACHHANG ON HD_MAKH = MAKH "
					+ " WHERE HD_MAKH = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maKH);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENKH");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public String selectTenNV(String maNV) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENNV FROM HOADON JOIN NHANVIEN ON HD_MANV = MANV "
					+ " WHERE HD_MANV = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maNV);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENNV");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
}
