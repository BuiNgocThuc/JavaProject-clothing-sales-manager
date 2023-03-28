package Back_End.KICHCO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;

public class KICHCODAO implements DAOInterface<KICHCO>{
	public static KICHCODAO getInstance() {
		return new KICHCODAO();
	}
	@Override
	public int insert(KICHCO t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "INSERT INTO KICHCO(MASIZE, TENSIZE) " +
			             " VALUES(?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKC());
			pst.setString(2, t.getTenKC());
			
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
	public int delete(KICHCO t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "DELETE FROM KICHCO " +
			             " WHERE MASIZE=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKC());
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
	public int update(KICHCO t) {
		int ketQua = 0; 
		try {
			Connection c = connec.getConnection();
			String sql = "UPDATE KICHCO " +
			             " SET TENSIZE=?" +
					     " WHERE MASIZE=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenKC());
			pst.setString(2, t.getMaKC());
			
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
	public ArrayList<KICHCO> selectAll() {
		ArrayList<KICHCO> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO"; 
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKC = rs.getString("MASIZE");
				String tenKC = rs.getString("TENSIZE");
				
				KICHCO a = new KICHCO(maKC, tenKC);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KICHCO selectById(KICHCO t) {
		KICHCO ketQua = null;
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO WHERE MASIZE=?"; 
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKC());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKC = rs.getString("MASIZE");
				String tenKC = rs.getString("TENSIZE");
				
				ketQua = new KICHCO(maKC, tenKC);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KICHCO> selectByCondition(String condition) {
		ArrayList<KICHCO> ketQua = new ArrayList<>();
		try {
			Connection c = connec.getConnection();
			String sql = "SELECT * FROM KICHCO WHERE " + condition; 
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String maKC = rs.getString("MASIZE");
				String tenKC = rs.getString("TENSIZE");
				
				KICHCO a = new KICHCO(maKC, tenKC);
				ketQua.add(a);
			}
			connec.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

}
