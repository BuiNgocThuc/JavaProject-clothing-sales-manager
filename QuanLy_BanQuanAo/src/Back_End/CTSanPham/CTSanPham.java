/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.CTSanPham;

/**
 *
 * @author NGOC THUC
 */
public class CTSanPham {
    private String maSP, maSize, maMau;

    public CTSanPham(String maSP, String maSize, String maMau) {
        this.maSP = maSP;
        this.maSize = maSize;
        this.maMau = maMau;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }
    
    
}
