package Back_End.SANPHAM;
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
public class SANPHAMDAO implements DAOInterface<SANPHAM> {
	public static SANPHAMDAO getInstance() {
		return new SANPHAMDAO();
	}
	@Override
	public int insert(SANPHAM t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO SANPHAM(MASP, SP_MATH, TENSP, SIZE, MAUSAC, HINHANH, SP_GIASP, SP_SOLUONGSP, TRANGTHAI) " +
					      " VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			pst.setString(2, t.getMaTH());
			pst.setString(3, t.getTenSP());
			pst.setString(4, t.getKichCo());
			pst.setString(5, t.getMauSac());
			pst.setString(6, t.getHinhAnh());
			pst.setFloat(7,t.getGiaSP());
			pst.setInt(8, t.getSoLuongSP());
			pst.setString(9, t.getTrangThai());
			
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
	public int delete(SANPHAM t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM SANPHAM " +
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
		
		return ketQua;	}

	@Override
	public int update(SANPHAM t) {
		int ketQua = 0;
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE SANPHAM " +
					      " SET SP_MATH=?" +
					      ", TENSP=?" +
					      ", SIZE=?" +
					      ", MAUSAC=?" +
					      ", HINHANH=?" +
					      ", SP_GIASP=?" +
					      ", SP_SOLUONGSP=?" +
					      ", TRANGTHAI=?" +
					      " WHERE MASP=?";
					      
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaTH());
			pst.setString(2, t.getTenSP());
			pst.setString(3, t.getKichCo());
			pst.setString(4, t.getMauSac());
			pst.setString(5, t.getHinhAnh());
			pst.setFloat(6,t.getGiaSP());
			pst.setInt(7, t.getSoLuongSP());
			pst.setString(8, t.getTrangThai());
			pst.setString(9, t.getMaSP());

			
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
	public ArrayList<SANPHAM> selectAll() {
		ArrayList<SANPHAM> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM SANPHAM";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maTH = rs.getString("SP_MATH");
				String tenSP = rs.getNString("TENSP");
				String kichCo = rs.getString("SIZE");
				String mauSac = rs.getNString("MAUSAC");
				String hinhAnh = rs.getString("HINHANH");
				Float giaSP = rs.getFloat("SP_GIASP");
				int soLuong = rs.getInt("SP_SOLUONGSP");
				String trangThai = rs.getString("TRANGTHAI");
				
				
				 SANPHAM a = new SANPHAM(maSP, maTH, tenSP, kichCo, mauSac, giaSP, soLuong, trangThai,hinhAnh);
				 ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public SANPHAM selectById(SANPHAM t) {
		SANPHAM ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM SANPHAM WHERE MASP=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSP());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maTH = rs.getString("SP_MATH");
				String tenSP = rs.getNString("TENSP");
				String kichCo = rs.getString("SIZE");
				String mauSac = rs.getNString("MAUSAC");
				String hinhAnh = rs.getString("HINHANH");
				Float giaSP = rs.getFloat("SP_GIASP");
				int soLuong = rs.getInt("SP_SOLUONGSP");
				String trangThai = rs.getString("TRANGTHAI");
				
				
				ketQua = new SANPHAM(maSP, maTH, tenSP, kichCo, mauSac, giaSP, soLuong, trangThai, hinhAnh);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<SANPHAM> selectByCondition(String condition) {
		ArrayList<SANPHAM> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM SANPHAM WHERE " + condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maSP = rs.getString("MASP");
				String maTH = rs.getString("SP_MATH");
				String tenSP = rs.getNString("TENSP");
				String kichCo = rs.getString("SIZE");
				String mauSac = rs.getNString("MAUSAC");
				String hinhAnh = rs.getString("HINHANH");
				Float giaSP = rs.getFloat("SP_GIASP");
				int soLuong = rs.getInt("SP_SOLUONGSP");
				String trangThai = rs.getString("TRANGTHAI");
				
				
				 SANPHAM a = new SANPHAM(maSP, maTH, tenSP, kichCo, mauSac, giaSP, soLuong, trangThai,hinhAnh);
				 ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
