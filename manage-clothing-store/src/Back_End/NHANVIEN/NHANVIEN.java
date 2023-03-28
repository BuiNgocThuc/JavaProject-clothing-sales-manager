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

	private String maNV, tenNV,ngaySinh, diaChi, sdt, trangThai;
	    
	 public NHANVIEN() {
	        maNV = null;
	        tenNV = null;
	        diaChi = null;
	        sdt = null;
	        trangThai = null;
	  }

	 public NHANVIEN(String maNV, String tenNV, String ngaySinh, String sdt, String diaChi, String trangThai) {
	        this.maNV = maNV;
	        this.tenNV = tenNV;
	        this.ngaySinh = ngaySinh;
	        this.diaChi = diaChi;
	        this.sdt = sdt;
	        this.trangThai = trangThai;
	  }

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	
	 

}
