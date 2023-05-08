/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTHoaDon;

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
public class CTHoaDonDAO implements DAOInterface<CTHoaDon> {
	public static CTHoaDonDAO getInstance()
	{
		return new CTHoaDonDAO();
	}
	@Override
	public int insert(CTHoaDon t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO CHITIETHOADON(CTHD_MAHD, CTHD_MASP, DONGIA, CTHD_SOLUONG " +
			             " VALUES(?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaHD());
			pst.setString(2, t.getMaSP());
			pst.setFloat(3, t.getDonGia());
			pst.setInt(4, t.getSoLuong());
			
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
	public int delete(CTHoaDon t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM CHITIETHOADON " +
			             " CT_MAHD=?";
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
	public int update(CTHoaDon t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE CHITIETHOADON " +
			             " SET CTHD_MASP=?" +
					     ", DONGIA=?" +
			             ", CTHD_SOLUONG=?" +
					     " WHERE CTHD_MAHD=?";
			PreparedStatement pst = c.prepareStatement(sql);
		
			pst.setString(1, t.getMaSP());
			pst.setFloat(2, t.getDonGia());
			pst.setInt(3, t.getSoLuong());
			pst.setString(4, t.getMaHD());
			
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
	public ArrayList<CTHoaDon> selectAll() {
		ArrayList<CTHoaDon> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETHOADON";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("CTHD_MAHD");
				String maSP = rs.getString("CTHD_MASP");
				Float donGia = rs.getFloat("DONGIA");
				int soLuong = rs.getInt("CTHD_SOLUONG");
				
				CTHoaDon a = new CTHoaDon(maHD, maSP, donGia, soLuong);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public CTHoaDon selectById(CTHoaDon t) {
		CTHoaDon ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETHOADON WHERE CTHD_MAHD=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaHD());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("CTHD_MAHD");
				String maSP = rs.getString("CTHD_MASP");
				Float donGia = rs.getFloat("DONGIA");
				int soLuong = rs.getInt("CTHD_SOLUONG");
				
				ketQua = new CTHoaDon(maHD, maSP, donGia, soLuong);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<CTHoaDon> selectByCondition(String condition) {
		ArrayList<CTHoaDon> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETHOADON WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maHD = rs.getString("CTHD_MAHD");
				String maSP = rs.getString("CTHD_MASP");
				Float donGia = rs.getFloat("DONGIA");
				int soLuong = rs.getInt("CTHD_SOLUONG");
				
				CTHoaDon a = new CTHoaDon(maHD, maSP, donGia, soLuong);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    
	public String selectTenSP(String maSP) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENSP FROM CHITIETHOADON JOIN SANPHAM ON CTHD_MASP = MASP "
					+ " WHERE CTHD_MASP = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maSP);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENSP");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public String selectTenSize(String maSP) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENSIZE FROM (CHITIETHOADON JOIN SANPHAM ON CTHD_MASP = MASP) JOIN KICHCO ON SIZE = MASIZE "
					+ " WHERE CTHD_MASP = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maSP);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENSIZE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public String selectTenMau(String maSP) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENMAU FROM (CHITIETHOADON JOIN SANPHAM ON CTHD_MASP = MASP) JOIN MAUSAC ON MAUSAC = MAMAU "
					+ " WHERE CTHD_MASP = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maSP);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENMAU");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public String selectTenTH(String maSP) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT TENTH FROM (CHITIETHOADON JOIN SANPHAM ON CTHD_MASP = MASP) JOIN THUONGHIEU ON SP_MATH = MATH "
					+ " WHERE CTHD_MASP = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maSP);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("TENTH");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public String selectTinhTrang(String maHD) {
		String ten = new String();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT HD_TINHTRANG FROM CHITIETHOADON JOIN HOADON ON CTHD_MAHD = MAHD "
					+ " WHERE CTHD_MAHD = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, maHD);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {		
				ten = rs.getString("HD_TINHTRANG");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ten;
	}
}
