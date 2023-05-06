package Back_End.KHUYENMAI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import Connection.connec;
import Dao.DAOInterface;
import Front_End.KHUYENMAI.KHUYENMAIGUI;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class KhuyenMaiDao implements DAOInterface<KHUYENMAI> {

    public static KhuyenMaiDao getInstance() {
        return new KhuyenMaiDao();
    }

    @Override
    public int insert(KHUYENMAI t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO KHUYENMAI(MAKM, TENKM, DIEUKIEN, GIAMGIA, NGAY_BD, NGAY_KT, TRANGTHAI) "
                    + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaKM());
            pst.setString(2, t.getTenKM());
            pst.setDouble(3, t.getDieuKien());
            pst.setDouble(4, t.getPhanTramGiamGia());
            LocalDate ngayBD = t.getNgayBD();
            LocalDate ngayKT = t.getNgayKT();
            pst.setDate(5, Date.valueOf(ngayBD));
            pst.setDate(6, Date.valueOf(ngayKT));
            pst.setNString(7, t.getTrangThai());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu xuống bảng KHUYENMAI");
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public boolean insertArray(ArrayList<KHUYENMAI> listKM) {
        try {
            Connection c = connec.getConnection();
            String sql = "INSERT INTO KHUYENMAI(MAKM, TENKM, DIEUKIEN, GIAMGIA, NGAY_BD, NGAY_KT, TRANGTHAI) "
                    + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            for (KHUYENMAI t : listKM) {
                pst.setString(1, t.getMaKM());
                pst.setString(2, t.getTenKM());
                pst.setDouble(3, t.getDieuKien());
                pst.setDouble(4, t.getPhanTramGiamGia());
                LocalDate ngayBD = t.getNgayBD();
                LocalDate ngayKT = t.getNgayKT();
                pst.setDate(5, Date.valueOf(ngayBD));
                pst.setDate(6, Date.valueOf(ngayKT));
                pst.setNString(7, t.getTrangThai());
                
                pst.executeUpdate();
            }

            
            
            connec.closeConnection(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm dữ liệu xuống bảng KHUYENMAI");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int delete(KHUYENMAI t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE KHUYENMAI "
                    + "SET trangThai='Đã Xóa' "
                    + " WHERE MAKM=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaKM());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(KHUYENMAI t) {
        int ketQua = 0;
        try {
            Connection c = connec.getConnection();
            String sql = "UPDATE KHUYENMAI "
                    + " SET TENKM=?"
                    + ", DIEUKIEN=?"
                    + ", GIAMGIA=?"
                    + ", NGAY_BD=?"
                    + ", NGAY_KT=?"
                    + ", TRANGTHAI=?"
                    + " WHERE MAKM=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(7, t.getMaKM());
            pst.setString(1, t.getTenKM());
            pst.setDouble(2, t.getDieuKien());
            pst.setDouble(3, t.getPhanTramGiamGia());
            LocalDate ngayBD = t.getNgayBD();
            LocalDate ngayKT = t.getNgayKT();
            pst.setDate(4, Date.valueOf(ngayBD));
            pst.setDate(5, Date.valueOf(ngayKT));
            pst.setNString(6, t.getTrangThai());

            ketQua = pst.executeUpdate();

            System.out.println("Bạn đã thực thi " + sql);
            System.out.println("Có " + ketQua + " bị thay đổi");

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int getCount() {
        int count = 0;
        try {
            Connection c = connec.getConnection();
            Statement st = c.createStatement();
            String sql = "select COUNT(*) as count from KHUYENMAI";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("count");
            }

            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public ArrayList<KHUYENMAI> selectAll() {
        ArrayList<KHUYENMAI> ketQua = new ArrayList<>();
        try {
            Connection c = connec.getConnection();
            String sql = "SELECT * FROM KHUYENMAI WHERE TRANGTHAI NOT IN ('Đã Xóa')";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maKM = rs.getString("MAKM");
                String tenKM = rs.getNString("TENKM");
                double dieuKien = rs.getDouble("DIEUKIEN");
                LocalDate ngayBD = rs.getDate("NGAY_BD").toLocalDate();
                LocalDate ngayKT = rs.getDate("NGAY_KT").toLocalDate();
                double phamTramGiamGia = rs.getDouble("GIAMGIA");
                String trangthai = rs.getNString("TRANGTHAI");

                KHUYENMAI a = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia, trangthai);
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
                double dieuKien = rs.getDouble("DIEUKIEN");
                LocalDate ngayBD = rs.getDate("NGAY_BD").toLocalDate();
                LocalDate ngayKT = rs.getDate("NGAY_KT").toLocalDate();
                Float phamTramGiamGia = rs.getFloat("GIAMGIA");
                String trangthai = rs.getNString("TRANGTHAI");

                ketQua = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia, trangthai);
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
                double dieuKien = rs.getDouble("DIEUKIEN");
                LocalDate ngayBD = rs.getDate("NGAY_BD").toLocalDate();
                LocalDate ngayKT = rs.getDate("NGAY_KT").toLocalDate();
                Float phamTramGiamGia = rs.getFloat("GIAMGIA");
                String trangthai = rs.getNString("TRANGTHAI");

                KHUYENMAI a = new KHUYENMAI(maKM, tenKM, dieuKien, ngayBD, ngayKT, phamTramGiamGia, trangthai);
                ketQua.add(a);
            }
            connec.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
