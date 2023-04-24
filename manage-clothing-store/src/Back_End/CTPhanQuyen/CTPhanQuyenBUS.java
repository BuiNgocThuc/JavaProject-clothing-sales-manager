package Back_End.CTPhanQuyen;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NGOC THUC
 */
public class CTPhanQuyenBUS {
    CTPhanQuyenDAO nqDao = new CTPhanQuyenDAO();
    public CTPhanQuyenBUS() {
    }
     public ArrayList<String> getListCTQByNQuyen(String nhomQuyen){
         return nqDao.getListCTQByNQuyen(nhomQuyen);
     }
     
}
