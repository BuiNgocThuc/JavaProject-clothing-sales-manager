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

	private String maNV, tenNV, diaChi, sdt, maQuyen, gioiTinh;
	 private int tuoiNV;
	    
	 public NHANVIEN() {
	        maNV = null;
	        tenNV = null;
	        diaChi = null;
	        sdt = null;
	        maQuyen = null;
	        tuoiNV = 0;
	        gioiTinh = null;
	  }

	 public NHANVIEN(String maNV, String tenNV, String diaChi, String sdt, String maQuyen, int tuoi, String gioiTinh) {
	        this.maNV = maNV;
	        this.tenNV = tenNV;
	        this.diaChi = diaChi;
	        this.sdt = sdt;
	        this.maQuyen = maQuyen;
	        this.tuoiNV = tuoi;
	        this.gioiTinh = gioiTinh;
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

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getTuoiNV() {
		return tuoiNV;
	}

	public void setTuoiNV(int tuoiNV) {
		this.tuoiNV = tuoiNV;
	}

	@Override
	public String toString() {
		return "NHANVIEN [maNV=" + maNV + ", tenNV=" + tenNV + ", diaChi=" + diaChi + ", sdt=" + sdt + ", maQuyen="
				+ maQuyen + ", gioiTinh=" + gioiTinh + ", tuoiNV=" + tuoiNV + "]";
	}
	 

}
