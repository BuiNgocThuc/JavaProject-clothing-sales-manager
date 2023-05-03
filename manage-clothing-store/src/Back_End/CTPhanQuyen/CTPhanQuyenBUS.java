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
    ArrayList<CTPhanQuyen> dspq = new ArrayList<>();
    public CTPhanQuyenBUS() {
    }
     public ArrayList<String> getListCTQByNQuyen(String nhomQuyen){
         return nqDao.getListCTQByNQuyen(nhomQuyen);
     }
     
     public boolean add(String roleID, String perID) {
          CTPhanQuyen role_per = new CTPhanQuyen(roleID, perID);
        int add = nqDao.insert(role_per);
        if (add == 1) {
            dspq.add(role_per);
            return true;
        } else {
            return false;
        }
     }
}
