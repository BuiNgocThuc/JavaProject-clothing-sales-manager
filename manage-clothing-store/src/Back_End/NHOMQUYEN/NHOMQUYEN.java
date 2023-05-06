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

    private String maQuyen, tenQuyen, moTaQuyen, trangThai;

    public NHOMQUYEN() {

    }

    public NHOMQUYEN(String maQuyen, String tenQuyen, String moTaQuyen, String trangThai) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.moTaQuyen = moTaQuyen;
        this.trangThai = trangThai;
    }
    
    public NHOMQUYEN(String maQuyen) {
        this.maQuyen =maQuyen;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
