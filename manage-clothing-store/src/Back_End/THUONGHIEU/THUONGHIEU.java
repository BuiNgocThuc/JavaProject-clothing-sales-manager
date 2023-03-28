/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.THUONGHIEU;

/**
 *
 * @author NGOC THUC
 */
public class THUONGHIEU {

    private String maTH, tenTH, trangthai;

    public THUONGHIEU() {

    }

    public THUONGHIEU(String maTH, String tenTH, String trangthai) {
        this.trangthai = trangthai;
        this.maTH = maTH;
        this.tenTH = tenTH;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaTH() {
        return maTH;
    }

    public void setMaTH(String maTH) {
        this.maTH = maTH;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }
}
