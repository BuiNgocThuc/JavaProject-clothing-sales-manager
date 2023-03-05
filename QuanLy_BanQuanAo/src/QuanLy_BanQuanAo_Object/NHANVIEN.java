/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy_BanQuanAo_Object;

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
 }
