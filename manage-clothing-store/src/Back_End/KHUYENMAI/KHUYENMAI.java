/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KHUYENMAI;

/**
 *
 * @author NGOC THUC
 */
public class KHUYENMAI {

    private String maKM, tenKM, dieuKien, ngayBD, ngayKT, trangThai;
    private double phanTramGiamGia;

    public KHUYENMAI(String maKM, String tenKM, String dieuKien, String ngayBD, String ngayKT, double phanTramGiamGia, String trangthai) {
        this.trangThai = trangthai;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dieuKien = dieuKien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.phanTramGiamGia = phanTramGiamGia;
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

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

}
