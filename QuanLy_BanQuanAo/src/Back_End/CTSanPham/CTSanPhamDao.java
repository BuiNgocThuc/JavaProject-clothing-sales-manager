package Back_End.CTSanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

public class CTSanPhamDAO implements DAOInterface<CTSanPham> {
	public static CTSanPhamDAO getInstance() {
		return new CTSanPhamDAO();
	}
	@Override
	public int insert(CTSanPham t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO CHITIETSANPHAM(MASP, MASIZE, MAMAU) " +
			            " VALUES(?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			pst.setString(2, t.getMaSize());
			pst.setString(3, t.getMaMau());
			
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
	public int delete(CTSanPham t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM CHITIETSANPHAM " +
			            " WHERE MASP=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			
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
	public int update(CTSanPham t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE CHITIETSANPHAM(MASP, MASIZE, MAMAU) " +
			            " SET MASIZE=?" +
			            ", MAMAU=?" +
					    " WHERE MASP=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSize());
			pst.setString(2, t.getMaMau());
			pst.setString(3, t.getMaSP());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return 0;	}

	@Override
	public ArrayList<CTSanPham> selectAll() {
		ArrayList<CTSanPham> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETSANPHAM";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maSize = rs.getString("MASIZE");
				String maMau = rs.getString("MAMAU");
				
				CTSanPham a = new CTSanPham(maSP, maMau, maSize);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public CTSanPham selectById(CTSanPham t) {
		CTSanPham ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETSANPHAM WHERE MASP=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maSize = rs.getString("MASIZE");
				String maMau = rs.getString("MAMAU");
				
				ketQua = new CTSanPham(maSP, maMau, maSize);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<CTSanPham> selectByCondition(String condition) {
		ArrayList<CTSanPham> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM CHITIETSANPHAM WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maSize = rs.getString("MASIZE");
				String maMau = rs.getString("MAMAU");
				
				CTSanPham a = new CTSanPham(maSP, maMau, maSize);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
