/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTPhieuNhap;

/**
 *
 * @author NGOC THUC
 */
public class CTPhieuNhap {

	private String maPN, maSP;
    private float donGia;
    private int soLuong;
    
    public CTPhieuNhap()
    {
    	
    }

    public CTPhieuNhap(String maPN, String maSP, float donGia, int soLuong) {
        this.maPN = maPN;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
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
