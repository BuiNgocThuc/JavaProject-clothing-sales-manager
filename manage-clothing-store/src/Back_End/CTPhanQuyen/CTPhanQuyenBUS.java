package Back_End.CTPhanQuyen;

import Back_End.CHUCNANG.CHUCNANG;
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
    CTPhanQuyenDAO ctnqDao = new CTPhanQuyenDAO();
    public static ArrayList<CTPhanQuyen> dspq = new ArrayList<>();
    public CTPhanQuyenBUS() {

    }
     public ArrayList<String> getListCTQByNQuyen(String nhomQuyen){
         return ctnqDao.getListCTQByNQuyen(nhomQuyen);
     }
     
     public boolean add(String roleID, String perID) {
          CTPhanQuyen role_per = new CTPhanQuyen(roleID, perID);
        int add = ctnqDao.insert(role_per);
        if (add == 1) {
            dspq.add(role_per);
            return true;
        } else {
            return false;
        }
     }
     
     public ArrayList<CTPhanQuyen> getDspq() {
         dspq = ctnqDao.selectAll();
         return dspq;
     }
     
     public boolean delete(String roleID) {
         CTPhanQuyen role = new CTPhanQuyen(roleID);
        int remove = ctnqDao.delete(role);
        if (remove == 1) {
            getDspq();
            return true;
        }
        return false;
     }
}
