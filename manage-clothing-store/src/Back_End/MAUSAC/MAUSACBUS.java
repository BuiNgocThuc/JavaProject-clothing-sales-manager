/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.MAUSAC;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Back_End.KICHCO.KICHCO;
import Back_End.KICHCO.KICHCODAO;

/**
 *
 * @author NGOC THUC
 */
public class MAUSACBUS {
    static ArrayList<MAUSAC> mauSac = new ArrayList<>();
    public ArrayList<MAUSAC>  loadData()
    {
    	mauSac = MAUSACDAO.getInstance().selectAll();
    	return mauSac;
    }
    
    public DefaultComboBoxModel<String> getModel()
    {
    	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    	model.addElement(" ");
    	for (MAUSAC m : mauSac) {
			model.addElement(m.getTenMau());
		}
    	return model;
    }
    
    public void setTable(JTable table)
    {
    	DefaultTableModel dModel = (DefaultTableModel) table.getModel();
    	dModel.setRowCount(0);
    	for(int i=0; i<mauSac.size(); i++)
    	{
    		dModel.addRow(new Object[] {i+1,mauSac.get(i).getMaMau(),mauSac.get(i).getTenMau()});
    	}
    }
    
    public String autoID()
    {
    	String id = null;
    	int count = mauSac.size();
    	
    	String end = String.valueOf(mauSac.get(count-1).getMaMau());
    	char[] tmp = new char[10];
    	end.getChars(1, end.length(), tmp, 0);
    	int str = 0;
    	String endStr = new String();
    	for(int i=0; i<end.length()-1; i++)
    	{
    		endStr += tmp[i];
    	}
    	str = Integer.parseInt(endStr);
    	id = "M"+String.valueOf(str+1);
    	return id;
    }
    
    public boolean checkExist(String name)
    {
    	for (MAUSAC m : mauSac) {
			if(name.equalsIgnoreCase(m.getTenMau()))
			{
				return true;
			}
		}
    	return false;
    }
    
    public void addMau(String name, JTable table)
    {
    	if(checkExist(name)==true)
    	{
    		JOptionPane.showMessageDialog(null,"Thuộc tính đã tồn tại","Thông báo", JOptionPane.OK_OPTION);
    	}
    	else {
			MAUSAC t = new MAUSAC(autoID(), name);
			int result = MAUSACDAO.getInstance().insert(t);
			if(result!=-1)
			{
				mauSac.add(t);
				setTable(table);
				JOptionPane.showMessageDialog(null,"Thêm thành công","Thông báo", JOptionPane.OK_OPTION);
			}
			else {
				JOptionPane.showMessageDialog(null,"Thêm không thành công","Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
    }
}
