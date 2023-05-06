/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTPhanQuyen;

/**
 *
 * @author NGOC THUC
 */
public class CTPhanQuyen {
String maQuyen, maChucNang;
	
	public CTPhanQuyen()
	{
		
	}

	public CTPhanQuyen(String maQuyen, String maChucNang) {
		this.maQuyen = maQuyen;
		this.maChucNang = maChucNang;
	}

                    public CTPhanQuyen(String maQuyen) {
                        this.maQuyen = maQuyen;
                    }
        
	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getMaChucNang() {
		return maChucNang;
	}

	public void setMaChucNang(String maChucNang) {
		this.maChucNang = maChucNang;
	}
}
