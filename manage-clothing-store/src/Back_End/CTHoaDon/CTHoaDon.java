/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTHoaDon;

/**
 *
 * @author NGOC THUC
 */
public class CTHoaDon {

	 private String maHD, maSP;
	 private float donGia;
	 private int soLuong;
	 
	 public CTHoaDon()
	 {
		 
	 }

	 public CTHoaDon(String maHD, String maSP, Float donGia, int soLuong) {
	     this.maHD = maHD;
	     this.maSP = maSP;
	     this.donGia = donGia;
	     this.soLuong = soLuong;
	 }

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	 
	 

}
