package Back_End.THUONGHIEU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.connec;
import Dao.DAOInterface;
import javax.swing.JOptionPane;

public class THUONGHIEUDAO implements DAOInterface<THUONGHIEU> {

    public static THUONGHIEUDAO getInstance() {
        return new THUONGHIEUDAO();
    }
    
         public boolean insertArray(ArrayList<THUONGHIEU> listKM) {
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO THUONGHIEU(MATH, TENTH, TRANGTHAI) "
                    + " VALUES(?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            for (THUONGHIEU t : listKM) {
                pst.setString(1, t.getMaTH());
                pst.setString(2, t.getTenTH());
                pst.setNString(3, t.getTrangthai());
                
                pst.executeUpdate();
            }
            
            connec.closeConnection(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu xuống bảng THUONGHIEU");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int insert(THUONGHIEU t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO THUONGHIEU(MATH, TENTH, TRANGTHAI) "
                    + " VALUES(?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaTH());
            pst.setString(2, t.getTenTH());
            pst.setString(3, t.getTrangthai());

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
    public int delete(THUONGHIEU t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "DELETE FROM THUONGHIEU "
                    + " WHERE MATH=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaTH());

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
    public int update(THUONGHIEU t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE THUONGHIEU "
                    + " SET TENTH=?"
                    + ", TRANGTHAI=?"
                    + " WHERE MATH=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getTenTH());
            pst.setString(3, t.getMaTH());
            pst.setString(2, t.getTrangthai());

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
    public ArrayList<THUONGHIEU> selectAll() {
        ArrayList<THUONGHIEU> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM THUONGHIEU";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maTH = rs.getString("MATH");
                String tenTH = rs.getNString("TENTH");
                String trangthai = rs.getString("TRANGTHAI");

                THUONGHIEU a = new THUONGHIEU(maTH, tenTH, trangthai);
                ketQua.add(a);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public THUONGHIEU selectById(THUONGHIEU t) {
        THUONGHIEU ketQua = null;
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM THUONGHIEU WHERE MATH=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaTH());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maTH = rs.getString("MATH");
                String tenTH = rs.getNString("TENTH");
                String trangthai = rs.getString("TRANGTHAI");

                ketQua = new THUONGHIEU(maTH, tenTH, trangthai);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<THUONGHIEU> selectByCondition(String condition) {
        ArrayList<THUONGHIEU> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM THUONGHIEU WHERE " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maTH = rs.getString("MATH");
                String tenTH = rs.getNString("TENTH");
                String trangthai = rs.getString("TRANGTHAI");

                THUONGHIEU a = new THUONGHIEU(maTH, tenTH, trangthai);
                ketQua.add(a);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
