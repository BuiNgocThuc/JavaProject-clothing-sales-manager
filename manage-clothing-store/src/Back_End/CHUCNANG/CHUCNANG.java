/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CHUCNANG;

/**
 *
 * @author NGOC THUC
 */
public class CHUCNANG {

    private String maCN, tenCN, moTa;

    public CHUCNANG() {

    }
    
    public CHUCNANG(String maCN, String tenCN, String moTa) {
        this.maCN = maCN;
        this.tenCN = tenCN;
        this.moTa = moTa;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN(String tenCN) {
        this.tenCN = tenCN;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
    
}
