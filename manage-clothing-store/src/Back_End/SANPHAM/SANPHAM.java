/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.SANPHAM;

/**
 *
 * @author NGOC THUC
 */
public class SANPHAM {
	private String maSP, tenSP, trangThai, mauSac, kichCo, maTH, hinhAnh;
    private float giaSP;
    private int soLuongSP;

    public SANPHAM(String maSP,String maTH, String tenSP, String kichCo, String mauSac, float giaSP, int soLuongSP, String trangThai, String hinhAnh) {
        this.maSP = maSP;
        this.maTH = maTH;
        this.tenSP = tenSP;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaSP = giaSP;
        this.soLuongSP = soLuongSP;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
       
    }
    
    public SANPHAM()
    {
    	
    }
    
    

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public float getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}

	public int getSoLuongSP() {
		return soLuongSP;
	}

	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

	public String getMaTH() {
		return maTH;
	}

	public void setMaTH(String maTH) {
		this.maTH = maTH;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	
}
