/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.NHOMQUYEN;

/**
 *
 * @author NGOC THUC
 */
public class NHOMQUYEN {

private String maQuyen, tenQuyen, moTaQuyen;
	
	public NHOMQUYEN()
	{
		
	}

    public NHOMQUYEN(String maQuyen, String tenQuyen, String moTaQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.moTaQuyen = moTaQuyen;
    }

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public String getMoTaQuyen() {
		return moTaQuyen;
	}

	public void setMoTaQuyen(String moTaQuyen) {
		this.moTaQuyen = moTaQuyen;
	}
    
    

    
}
