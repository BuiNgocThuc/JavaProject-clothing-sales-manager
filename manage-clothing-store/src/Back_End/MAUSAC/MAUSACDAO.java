package Back_End.MAUSAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

public class MAUSACDAO implements DAOInterface<MAUSAC>{
	public static MAUSACDAO getInstance() {
		return new MAUSACDAO();
	}
	@Override
	public int insert(MAUSAC t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO MAUSAC(MAMAU, TENMAU) " +
			             " VALUES(?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaMau());
			pst.setString(2, t.getTenMau());
			
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
	public int delete(MAUSAC t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM MAUSAC " +
			             " WHERE MAMAU=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaMau());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " bị thay đổi");
			
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	}

	@Override
	public int update(MAUSAC t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE MAUSAC " +
			             " SET TENMAU=?" +
					     " WHERE MAMAU=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenMau());
			pst.setString(2, t.getMaMau());
			
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
	public ArrayList<MAUSAC> selectAll() {
		ArrayList<MAUSAC> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO"; 
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maMau = rs.getString("MAMAU");
				String tenMau = rs.getString("TENMAU");
				
				MAUSAC a = new MAUSAC(maMau, tenMau);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public MAUSAC selectById(MAUSAC t) {
		MAUSAC ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO WHERE MAMAU=?"; 
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaMau());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maMau = rs.getString("MAMAU");
				String tenMau = rs.getString("TENMAU");
				
				ketQua = new MAUSAC(maMau, tenMau);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<MAUSAC> selectByCondition(String condition) {
		ArrayList<MAUSAC> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO WHERE " + condition; 
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maMau = rs.getString("MAMAU");
				String tenMau = rs.getString("TENMAU");
				
				MAUSAC a = new MAUSAC(maMau, tenMau);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

}
