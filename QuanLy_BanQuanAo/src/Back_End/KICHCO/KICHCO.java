/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KICHCO;

/**
 *
 * @author NGOC THUC
 */
public class KICHCO {
	private String maKC, tenKC;
    public KICHCO()
    {
   	 
    }
    
	public KICHCO(String maKC, String tenKC) {
		super();
		this.maKC = maKC;
		this.tenKC = tenKC;
	}

	public String getMaKC() {
		return maKC;
	}

	public void setMaKC(String maKC) {
		this.maKC = maKC;
	}

	public String getTenKC() {
		return tenKC;
	}

	public void setTenKC(String tenKC) {
		this.tenKC = tenKC;
	}
	
}
