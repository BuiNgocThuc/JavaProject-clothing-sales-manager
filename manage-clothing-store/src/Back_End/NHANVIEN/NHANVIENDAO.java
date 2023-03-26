/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHANVIEN;

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
public class NHANVIENDAO implements DAOInterface<NHANVIEN>{
	public static NHANVIENDAO getInstance()
	{
		return new NHANVIENDAO();
	}

	@Override
	public int insert(NHANVIEN t) {
		int ketQua = 0;
		try {
			Connection conn = connec.getConnection();
			
			String sql = "INSERT INTO NHANVIEN (MANV, NV_MAQUYEN, TENNV, SDTNV, DIACHINV, TUOI, GT) " +
			             " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			pst.setString(2, t.getMaQuyen());
			pst.setString(3, t.getTenNV());
			pst.setString(4, t.getSdt());
			pst.setString(5, t.getDiaChi());
			pst.setInt(6, t.getTuoiNV());
			pst.setString(7, t.getGioiTinh());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return 0;
	}

	@Override
	public int delete(NHANVIEN t) {
		int ketQua;
	    try {
			Connection conn = connec.getConnection();
			
			String sql = "DELETE from NHANVIEN " +
			             " WHERE MANV=? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, t.getMaNV());
			ketQua = pst.executeUpdate();
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(conn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int update(NHANVIEN t) {
		int ketQua = 0;
		try {
			Connection conn = connec.getConnection();
			
			String sql = "UPDATE NHANVIEN " + 
			             " SET NV_MAQUYEN=?" +
					     ", TENNV=?" +
			             ", SDTNV=?" +
					     ", DIACHINV=?" +
			             ", TUOI=?" +
					     ", GT=?" +
			             " WHERE MANV=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, t.getMaQuyen());
			pst.setString(2, t.getTenNV());
			pst.setString(3, t.getSdt());
			pst.setString(4, t.getDiaChi());
			pst.setString(5, t.getMaNV());
			pst.setInt(6, t.getTuoiNV());
			pst.setString(7, t.getGioiTinh());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(conn);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public ArrayList<NHANVIEN> selectAll() {
		ArrayList<NHANVIEN> ketQua = new ArrayList<>();
		try {
			Connection conn = connec.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT * FROM NHANVIEN";
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getNString("TENNV");
				String diaChi = rs.getNString("DIACHINV");
				String sdt = rs.getString("SDTNV");
				String maQuyen = rs.getString("NV_MAQUYEN");
				int tuoi = rs.getInt("TUOI");
				String gioiTinh = rs.getNString("GT");
				
				
				NHANVIEN a = new NHANVIEN(maNV, tenNV, diaChi, sdt, maQuyen, tuoi, gioiTinh);
				ketQua.add(a);
			}
			
			connec.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public NHANVIEN selectById(NHANVIEN t) {
		NHANVIEN ketQua = null;
		try {
			Connection conn = connec.getConnection();
			
			String sql = "SELECT * FROM NHANVIEN " +
			             " WHERE MANV=?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			 
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getNString("TENNV");
				String diaChi = rs.getNString("DIACHINV");
				String sdt = rs.getString("SDTNV");
				String maQuyen = rs.getString("NV_MAQUYEN");
				int tuoi = rs.getInt("TUOI");
				String gioiTinh = rs.getNString("GT");
				
				ketQua = new NHANVIEN(maNV, tenNV, diaChi, sdt, maQuyen,tuoi,gioiTinh);
			}
			
			connec.closeConnection(conn);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<NHANVIEN> selectByCondition(String condition) {
		ArrayList<NHANVIEN> ketQua = new ArrayList<>();
		try {
			Connection conn = connec.getConnection();
			
			String sql = "SELECT * FROM NHANVIEN WHERE " + condition;
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MANV");
				String tenNV = rs.getNString("TENNV");
				String diaChi = rs.getNString("DIACHINV");
				String sdt = rs.getString("SDTNV");
				String maQuyen = rs.getString("NV_MAQUYEN");
				int tuoi = rs.getInt("TUOI");
				String gioiTinh = rs.getNString("GT");
				
				NHANVIEN a = new NHANVIEN(maNV, tenNV, diaChi, sdt, maQuyen, tuoi, gioiTinh);
				ketQua.add(a);
			}
			
			connec.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	

  
}
