/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Back_End.NHANVIEN;

/**
 *
 * @author NGOC THUC
 */
public class NHANVIEN {
    private String maNV, tenNV, diaChi, sdt;
    
    public NHANVIEN() {
        maNV = null;
        tenNV = null;
        diaChi = null;
        sdt = null;
    }

    public NHANVIEN(String maNV, String tenNV, String diaChi, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
 }
