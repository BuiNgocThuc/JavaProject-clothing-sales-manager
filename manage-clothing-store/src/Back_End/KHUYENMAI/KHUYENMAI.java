/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KHUYENMAI;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author NGOC THUC
 */
public class KHUYENMAI {
    
    private String maKM, tenKM, trangThai;
    private double dieuKien,  phanTramGiamGia;
    private LocalDate ngayBD, ngayKT;   

    public KHUYENMAI(String maKM, String tenKM, double dieuKien, LocalDate ngayBD, LocalDate ngayKT, double phanTramGiamGia, String trangthai) {
        this.trangThai = trangthai;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dieuKien = dieuKien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public KHUYENMAI(String maKM, String tenKM, double dieuKien, double phanTramGiamGia, LocalDate ngayBD, LocalDate ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dieuKien = dieuKien;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public KHUYENMAI() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public double getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(double dieuKien) {
        this.dieuKien = dieuKien;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate ngayBD) {
        this.ngayBD = ngayBD;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

}
