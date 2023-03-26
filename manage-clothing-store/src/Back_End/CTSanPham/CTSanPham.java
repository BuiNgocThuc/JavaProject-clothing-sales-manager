/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTSanPham;

/**
 *
 * @author NGOC THUC
 */
public class CTSanPham {
private String maSP, maMau, maSize;
	
	public CTSanPham()
	{
		
	}

	public CTSanPham(String maSP, String maMau, String maSize) {
		super();
		this.maSP = maSP;
		this.maMau = maMau;
		this.maSize = maSize;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getMaMau() {
		return maMau;
	}

	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}

	public String getMaSize() {
		return maSize;
	}

	public void setMaSize(String maSize) {
		this.maSize = maSize;
	}
	
	
}
