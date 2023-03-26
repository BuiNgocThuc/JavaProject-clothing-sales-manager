/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAIKHOAN;

/**
 *
 * @author NGOC THUC
 */
public class TAIKHOAN {
private String userName, passWord, maQuyen;
	
	public TAIKHOAN()
	{
		
	}

	public TAIKHOAN(String userName, String passWord, String maQuyen) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.maQuyen = maQuyen;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}
	
	
}
