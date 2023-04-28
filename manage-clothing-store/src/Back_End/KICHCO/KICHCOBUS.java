/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.KICHCO;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC THUC
 */
public class KICHCOBUS {
	static ArrayList<KICHCO> kichCo = new ArrayList<>();
    public ArrayList<KICHCO> loadData()
    {
    	kichCo = KICHCODAO.getInstance().selectAll();
    	return kichCo;
    }
    
    public DefaultComboBoxModel<String> setModel()
    {
    	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    	model.addElement(" ");
    	for (KICHCO k : kichCo) {
			model.addElement(k.getTenKC());
		}
    	return model;
    }
    
    public void setTable(JTable table)
    {
    	DefaultTableModel dModel = (DefaultTableModel) table.getModel();
    	dModel.setRowCount(0);
    	for(int i=0; i<kichCo.size(); i++)
    	{
    		dModel.addRow(new Object[] {i+1,kichCo.get(i).getMaKC(),kichCo.get(i).getTenKC()});
    	}
    }
    
    public String autoID()
    {
    	String id = null;
    	int count = kichCo.size();
    	
    	String end = String.valueOf(kichCo.get(count-1).getMaKC());
    	char[] tmp = new char[10];
    	end.getChars(1, end.length(), tmp, 0);
    	int str = 0;
    	String endStr = new String();
    	for(int i=0; i<end.length()-1; i++)
    	{
    		endStr += tmp[i];
    	}
    	System.out.println(endStr);
    	str = Integer.parseInt(endStr);
    	id = "S" + String.valueOf(str+1);
    	return id;
    }
    
    public boolean checkExist(String name)
    {
    	for (KICHCO k : kichCo) {
			if(name.equalsIgnoreCase(k.getTenKC()))
			{
				return true;
			}
		}
    	return false;
    }
    
    public void addSize(String name, JTable table)
    {
    	if(checkExist(name)==true)
    	{
    		JOptionPane.showMessageDialog(null,"Thuộc tính đã tồn tại","Thông báo", JOptionPane.OK_OPTION);
    	}
    	else {
			KICHCO aKichco = new KICHCO(autoID(), name);
			int result = KICHCODAO.getInstance().insert(aKichco);
			if(result!=-1)
			{
				kichCo.add(aKichco);
				setTable(table);
				JOptionPane.showMessageDialog(null,"Thêm thành công","Thông báo", JOptionPane.OK_OPTION);
			}
			else {
				JOptionPane.showMessageDialog(null,"Thêm không thành công","Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
    }
}
