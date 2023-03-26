/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CTPhanQuyen;

/**
 *
 * @author NGOC THUC
 */
public class CTPhanQuyen {
String maQuyen, tenChucNang;
	
	public CTPhanQuyen()
	{
		
	}

	public CTPhanQuyen(String maQuyen, String tenChucNang) {
		super();
		this.maQuyen = maQuyen;
		this.tenChucNang = tenChucNang;
	}

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenChucNang() {
		return tenChucNang;
	}

	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}
}
