/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.TAIKHOAN;

/**
 *
 * @author NGOC THUC
 */
public class TAIKHOAN {

    private String userName, passWord, maQuyen, trangthai;

    public TAIKHOAN() {

    }

    public TAIKHOAN(String userName, String passWord, String maQuyen, String trangthai) {
        this.userName = userName;
        this.passWord = passWord;
        this.maQuyen = maQuyen;
        this.trangthai = trangthai;
    }
    

    public TAIKHOAN(String userName, String passWord, String maQuyen) {
        this.userName = userName;
        this.passWord = passWord;
        this.maQuyen = maQuyen;
    }
    
    public TAIKHOAN (String trangthai){
        this.trangthai = trangthai;
    }
    
    

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
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
