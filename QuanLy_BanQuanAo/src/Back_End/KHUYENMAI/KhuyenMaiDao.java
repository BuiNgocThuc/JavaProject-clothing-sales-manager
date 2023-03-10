package Back_End.KHUYENMAI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

public class KhuyenMaiDao implements DAOInterface<KHUYENMAI> {
	public static KhuyenMaiDao getInstance() {
		return new KhuyenMaiDao();
	}
	@Override
	public int insert(KHUYENMAI t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO KHUYENMAI(MAKM, TENKM, DIEUKIEN, NGAY_BD, NGAY_KT, GIAMGIA) " +
			             " VALUES(?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKM());
			pst.setString(2, t.getTenKM());
			pst.setString(3, t.getDieuKien());
			String ngayBD = t.getNgayBD();
			String ngayKT = t.getNgayKT();
			Date dateBD = Date.valueOf(ngayBD);
			Date dateKT = Date.valueOf(ngayKT);
			pst.setDate(4, dateBD);
			pst.setDate(5, dateKT);
			pst.setDouble(6, t.getPhanTramGiamGia());
			
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
	public int delete(KHUYENMAI t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM KHUYENMAI " +
			             " WHERE MAKM=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKM());
			
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
	public int update(KHUYENMAI t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO KHUYENMAI(MAKM, TENKM, DIEUKIEN, NGAY_BD, NGAY_KT, GIAMGIA) " +
			             " SET TENKM=?" +
					     ", DIEUKIEN=?" +
			             ", NGAY_BD=?" +
					     ", NGAY_KT=?" +
			             ", GIAMGIA=?" +
					     " WHERE MAKM=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenKM());
			pst.setString(2, t.getDieuKien());
			String ngayBD = t.getNgayBD();
			String ngayKT = t.getNgayKT();
			Date dateBD = Date.valueOf(ngayBD);
			Date dateKT = Date.valueOf(ngayKT);
			pst.setDate(3, dateBD);
			pst.setDate(4, dateKT);
			pst.setDouble(5, t.getPhanTramGiamGia());
			pst.setString(6, t.getMaKM());
			
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
	public ArrayList<KHUYENMAI> selectAll() {
		ArrayList<KHUYENMAI> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KHUYENMAI";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKM = rs.getString("MAKM");
				String tenKM = rs.getNString("TENKM");
				String dieuKien = rs.getString("DIEUKIEN");
				String ngayBD = String.valueOf(rs.getDate("NGAY_BD"));
				String ngayKT = String.valueOf(rs.getDate("NGAY_KT"));
				Float phamTramGiamGia = rs.getFloat("GIAMGIA");
				
				KHUYENMAI a = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KHUYENMAI selectById(KHUYENMAI t) {
		KHUYENMAI ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KHUYENMAI WHERE MAKM= ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKM());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKM = rs.getString("MAKM");
				String tenKM = rs.getNString("TENKM");
				String dieuKien = rs.getString("DIEUKIEN");
				String ngayBD = String.valueOf(rs.getDate("NGAY_BD"));
				String ngayKT = String.valueOf(rs.getDate("NGAY_KT"));
				Float phamTramGiamGia = rs.getFloat("GIAMGIA");
				
				ketQua = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KHUYENMAI> selectByCondition(String condition) {
		ArrayList<KHUYENMAI> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KHUYENMAI WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKM = rs.getString("MAKM");
				String tenKM = rs.getNString("TENKM");
				String dieuKien = rs.getString("DIEUKIEN");
				String ngayBD = String.valueOf(rs.getDate("NGAY_BD"));
				String ngayKT = String.valueOf(rs.getDate("NGAY_KT"));
				Float phamTramGiamGia = rs.getFloat("GIAMGIA");
				
				KHUYENMAI a = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

}
