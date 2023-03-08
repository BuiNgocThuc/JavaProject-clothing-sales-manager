/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.HOADON;

/**
 *
 * @author NGOC THUC
 */
public class HOADON {

    private String maHD, maNV, maKH, ngayNhap;
    private double tongTien;

    public HOADON(String maHD, String maNV, String maKH, String ngayNhap, double tongTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    

}
