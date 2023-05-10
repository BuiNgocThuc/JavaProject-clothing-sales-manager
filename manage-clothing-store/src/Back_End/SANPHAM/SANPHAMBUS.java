/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_End.SANPHAM;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.midi.Soundbank;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Back_End.KICHCO.KICHCO;
import Back_End.KICHCO.KICHCOBUS;
import Back_End.KICHCO.KICHCODAO;
import Back_End.MAUSAC.MAUSAC;
import Back_End.MAUSAC.MAUSACBUS;
import Back_End.MAUSAC.MAUSACDAO;
import Back_End.SANPHAM.SANPHAMDAO;
import Back_End.THUONGHIEU.THUONGHIEU;
import Back_End.THUONGHIEU.THUONGHIEUDAO;
import Front_End.SANPHAM.SANPHAMGUI;

/**
 *
 * @author NGOC THUC
 */
public class SANPHAMBUS {
	public static ArrayList<SANPHAM> data = new ArrayList<>();
	static ArrayList<THUONGHIEU> thuongHieu = new ArrayList<>();
	static ArrayList<KICHCO> kichCo = new ArrayList<>();
	static ArrayList<MAUSAC> mauSac = new ArrayList<>();
	ArrayList<String> arrUpdate = new ArrayList<>();

	KICHCOBUS kcb = new KICHCOBUS();
	MAUSACBUS msb = new MAUSACBUS();
	public static SANPHAMBUS getInstance() {
		return new SANPHAMBUS();
	}

	public SANPHAMBUS() {
		
	}

	public void loadDataToTable(JTable tb) {
		thuongHieu = THUONGHIEUDAO.getInstance().selectAll();
		kichCo = kcb.loadData();
		mauSac = msb.loadData();
		data = SANPHAMDAO.getInstance().selectAll();
		DefaultTableModel dModel = (DefaultTableModel) tb.getModel();
		dModel.setRowCount(0);
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getTrangThai().equalsIgnoreCase("Đã Xóa") == false) {
				dModel.addRow(new Object[] {i+1, data.get(i).getMaSP(), getTenTH_formID(data.get(i).getMaTH()), data.get(i).getTenSP(),
						getSize_fromID(data.get(i).getKichCo()), getMau_fromID(data.get(i).getMauSac()), data.get(i).getSoLuongSP(),
						data.get(i).getGiaSP() });
			} else {
				data.remove(i);
			}
		}
	}
	
	public void loadDataFormNhapHang(JTable tb)
	{
		if(thuongHieu.isEmpty())
		{
			thuongHieu = THUONGHIEUDAO.getInstance().selectAll();
		}
		if(kichCo.isEmpty())
		{
			kichCo = KICHCODAO.getInstance().selectAll();
		}
		if(mauSac.isEmpty())
		{
			mauSac = MAUSACDAO.getInstance().selectAll();
		}
		if(data.isEmpty())
		{
			data = SANPHAMDAO.getInstance().selectAll();
		}
		DefaultTableModel dModel = (DefaultTableModel) tb.getModel();
		dModel.setRowCount(0);
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getTrangThai().equalsIgnoreCase("Đã Xóa") == false) {
				dModel.addRow(new Object[] { data.get(i).getMaSP(), getTenTH_formID(data.get(i).getMaTH()), data.get(i).getTenSP(),
						getSize_fromID(data.get(i).getKichCo()), getMau_fromID(data.get(i).getMauSac()), data.get(i).getGiaNhap(),
						data.get(i).getGiaSP() });
			} else {
				data.remove(i);
			}
		}
	}
	
	public String getTenTH_formID(String id)
	{
		String tenTH = null;
		for (THUONGHIEU o : thuongHieu) {
			if(o.getMaTH().equals(id))
			{
				tenTH = o.getTenTH();
				break;
			}
		}
		return tenTH;
	}
	
	public String getSize_fromID(String id)
	{
		String tenSize = null;
		for (KICHCO s : kichCo) {
			if(s.getMaKC().equals(id))
			{
				tenSize = s.getTenKC();
				break;
			}
		}
		return tenSize;
	}
	
	public String getMau_fromID(String id)
	{
		String tenMau = null;
	    for (MAUSAC m : mauSac) {
			if(m.getMaMau().equals(id))
			{
				tenMau = m.getTenMau();
				break;
			}
		}
		return tenMau;
	}

	public void loadDataToTable_UseArray(JTable tb) {
		DefaultTableModel dModel = (DefaultTableModel) tb.getModel();
		dModel.setRowCount(0);
		System.out.println(data.size());
		for (int i = 0; i < data.size(); i++) {
			dModel.addRow(new Object[] {i+1, data.get(i).getMaSP(), getTenTH_formID(data.get(i).getMaTH()), data.get(i).getTenSP(),
					getSize_fromID(data.get(i).getKichCo()), getMau_fromID(data.get(i).getMauSac()), data.get(i).getSoLuongSP(),
					data.get(i).getGiaSP() });
		}
	}

	public void loadDataToCombobox() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		String item1 = "......";
		model.addElement(item1);
		for (SANPHAM sanpham : data) {
			model.addElement(sanpham.getTenSP());
		}
		for (int i = 0; i < model.getSize() - 1; i++) {
			String value = String.valueOf(model.getElementAt(i));
			for (int j = i + 1; j < model.getSize(); j++) {
				if(j>=0)
				{
					String valueSame = String.valueOf(model.getElementAt(j));
					if (value.equalsIgnoreCase(valueSame)) {
						model.removeElementAt(j);
						i--;
					}
				}
			}
		}
		SANPHAMGUI.boxTenSP.setModel(model);

		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		model1.addElement(item1);
		for (SANPHAM sanpham : data) {
			model1.addElement(getTenTH_formID(sanpham.getMaTH()));
		}
		for (int i = 0; i < model1.getSize() - 1; i++) {
			String value = (String) model1.getElementAt(i);
			for (int j = i + 1; j < model1.getSize(); j++) {
				if(j>=0)
				{
					String valueSame = (String) model1.getElementAt(j);
					if (value.equals(valueSame)) {
						model1.removeElementAt(j);
						i--;
					}
				}
			}
		}
		SANPHAMGUI.boxTenTH.setModel(model1);

		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement(item1);
		for (KICHCO o : kichCo) {
			model2.addElement(o.getTenKC());
		}
		SANPHAMGUI.boxSize.setModel(model2);

		DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>();
		model3.addElement(item1);
		for (SANPHAM sanpham : data) {
			model3.addElement(getMau_fromID(sanpham.getMauSac()));
		}
		for (int i = 0; i < model3.getSize() - 1; i++) {
			String value = (String) model3.getElementAt(i);
			for (int j = i + 1; j < model3.getSize(); j++) {
				if(j>=0 && value !=null)
				{
					String valueSame = (String) model3.getElementAt(j);
					if (value.equals(valueSame)) {
						model3.removeElementAt(j);
						i--;
					}
				}
			}
		}
		SANPHAMGUI.boxMauSac.setModel(model3);

	}

	public void boLocSanPham() {
		String condition[] = new String[4];
		int index[] = new int[4];
		index[0] = SANPHAMGUI.boxTenSP.getSelectedIndex();
		index[1] = SANPHAMGUI.boxTenTH.getSelectedIndex();
		index[2] = SANPHAMGUI.boxSize.getSelectedIndex();
		index[3] = SANPHAMGUI.boxMauSac.getSelectedIndex();

		int count = 0;
		for (int i = 0; i < index.length; i++) {
			if (index[i] > 0) {
				count++;
				switch (i) {
				case 0:
					condition[i] = (String) SANPHAMGUI.boxTenSP.getItemAt(index[i]);
					break;
				case 1:
					condition[i] = (String) SANPHAMGUI.boxTenTH.getItemAt(index[i]);

					break;
				case 2:
					condition[i] = (String) SANPHAMGUI.boxSize.getItemAt(index[i]);
					break;
				case 3:
					condition[i] = (String) SANPHAMGUI.boxMauSac.getItemAt(index[i]);
					break;
				default:
					break;
				}
			}
		}

		ArrayList<SANPHAM> tmp = new ArrayList<SANPHAM>();
		System.out.println(count);
		if (count == 1) {
			int i = 0;
			boolean check = false;
			while (check == false && i < condition.length) {
				if (condition[i] != null) {
					for (SANPHAM o : data) {
						switch (i) {
						case 0:
							if (condition[i].equals(o.getTenSP())) {
								tmp.add(o);
							}
							break;
						case 1:
							if (condition[i].equals(getTenTH_formID(o.getMaTH()))) {
								tmp.add(o);
							}
							break;
						case 2:
							if (condition[i].equals(getSize_fromID(o.getKichCo()))) {
								tmp.add(o);
							}
							break;
						case 3:
							if (condition[i].equals(getMau_fromID(o.getMauSac()))) {
								tmp.add(o);
							}
							break;
						default:
							break;
						}
					}
					check = true;
				} else {
					i++;
				}
			}
		} else if (count > 1) {
			int check = 0, check1 = 0, check2 = 0, check3 = 0;
			for (SANPHAM o : data) {
				for (int i = 0; i < condition.length; i++) {
					if (condition[i] != null) {
						if (condition[i].equals(o.getTenSP())) {
							check = 1;
						}
						if (condition[i].equals(getTenTH_formID(o.getMaTH()))) {
							check1 = 1;
							if (check == 1 && check + check1 == count) {
								tmp.add(o);
							}
						}
						if (condition[i].equals(getSize_fromID(o.getKichCo()))) {
							check2 = 1;
							if (check == 1 && check1 != 1 && check + check2 == count) {
								tmp.add(o);
							}
							if (check != 1 && check1 == 1 && check1 + check2 == count) {
								tmp.add(o);
							}
							if (check == 1 && check1 == 1 && check + check1 + check2 == count) {
								tmp.add(o);
							}
						}
						if (condition[i].equals(getMau_fromID(o.getMauSac()))) {
							check3 = 1;
							if (check == 1 && check1 != 1 && check2 != 1 && check + check3 == count) {
								tmp.add(o);
							}
							if (check != 1 && check1 == 1 && check2 != 1 && check1 + check3 == count) {
								tmp.add(o);
							}
							if (check != 1 && check1 != 1 && check2 == 1 && check2 + check3 == count) {
								tmp.add(o);
							}
							if (check == 1 && check1 == 1 && check2 != 1 && check + check1 + check3 == count) {
								tmp.add(o);
							}
							if (check == 1 && check1 == 1 && check2 == 1 && check1 + check2 + check3 + check == count) {
								tmp.add(o);
							}
						}
					}
				}
				check = 0;
				check1 = 0;
				check2 = 0;
				check3 = 0;
			}
		}
		DefaultTableModel dModel = (DefaultTableModel) SANPHAMGUI.tableSP.getModel();
		dModel.setRowCount(0);
		for (int i=0 ; i<tmp.size(); i++) {
			dModel.addRow(new Object[] {i+1, tmp.get(i).getMaSP(), getTenTH_formID(tmp.get(i).getMaTH()),tmp.get(i).getTenSP(), getSize_fromID(tmp.get(i).getKichCo()),
					getMau_fromID(tmp.get(i).getMauSac()), tmp.get(i).getSoLuongSP(), tmp.get(i).getGiaSP() });
		}
	}

	public void xoaSP() {
		int row = SANPHAMGUI.tableSP.getSelectedRow();
		System.out.println(row);
		if(row!=-1)
		{
			String maSP = String.valueOf(SANPHAMGUI.tableSP.getValueAt(row, 1));
			for (SANPHAM o : data) {
				if (o.getMaSP().equalsIgnoreCase(maSP)) {
					o.setTrangThai("Đã Xóa");
					int result = SANPHAMDAO.getInstance().update(o);
					data.remove(o);
					if (result == -1) {
						JOptionPane.showConfirmDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.YES_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, "Xóa thành công", "Thông báo", JOptionPane.YES_OPTION);
					}
					break;
				}
			}
			loadDataToTable_UseArray( SANPHAMGUI.tableSP);
		}
		else {
			JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saveSP(String tenSP, String size,String mau, String donGia) {
		int vitri = SANPHAMGUI.tableSP.getSelectedRow();
		boolean check1=false, check2=false, check3=false, check4=false;
		if(data.get(vitri).getTenSP().equals(tenSP)==false)
		{
			data.get(vitri).setTenSP(tenSP);
			check1=true;
		}
		if(getSize_fromID(data.get(vitri).getKichCo()).equals(size)==false)
		{
			for (KICHCO k : kichCo) {
				if(k.getTenKC().equalsIgnoreCase(size))
				{
					data.get(vitri).setKichCo(k.getMaKC());
					break;
				}
			}
			check2=true;
		}
		if(data.get(vitri).getGiaSP()!=Float.parseFloat(donGia))
		{
			data.get(vitri).setGiaSP(Float.parseFloat(donGia));
			check3=true;
		}
		if(getMau_fromID(data.get(vitri).getMauSac()).equals(mau)==false)
		{
			for (MAUSAC m : mauSac) {
				if(m.getTenMau().equalsIgnoreCase(mau))
				{
					data.get(vitri).setMauSac(m.getMaMau());
					break;
				}
			}
			check4=true;
		}
		if(check1==true || check2==true || check3==true || check4==true)
		{
			int result = SANPHAMDAO.getInstance().update(data.get(vitri));
			if(result!=-1)
			{
				JOptionPane.showConfirmDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.OK_OPTION);
			}
			else {
				JOptionPane.showConfirmDialog(null, "Cập nhật không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
			loadDataToTable_UseArray( SANPHAMGUI.tableSP);
		}
	}
	
	public boolean addSP(SANPHAM t) { 
		String maTH = t.getMaTH();
		String maSize = t.getKichCo();
		String maMau = t.getMauSac();
		for (THUONGHIEU h : thuongHieu ) {
			if(h.getTenTH().equalsIgnoreCase(maTH))
			{
				t.setMaTH(h.getMaTH());
				break;
			}
		}
		for (KICHCO k : kichCo) {
			if(k.getTenKC().equalsIgnoreCase(maSize))
			{
				t.setKichCo(k.getMaKC());
				break;
			}
		}
		for (MAUSAC m : mauSac) {
			if(m.getTenMau().equalsIgnoreCase(maMau))
			{
				t.setMauSac(m.getMaMau());
				break;
			}
		}
		int kq = SANPHAMDAO.getInstance().insert(t);
		if(kq==-1)
		{
			return false;
		}
		data.add(t);
		loadDataToTable_UseArray( SANPHAMGUI.tableSP);
		return true;
	}
	
	public String getImage(int index)
	{
		String url = data.get(index).getHinhAnh();
		return url;
	}
	
	public String autoID()
	{
		String id = null;
		int count = data.size();
		
		String end = String.valueOf(data.get(data.size()-1).getMaSP());
		char tmp[] = new char[10];
		end.getChars(2, end.length(), tmp, 0);
		int str = 0;
		
		String chuoi = String.valueOf(tmp[0]);
		String chuoi1 = String.valueOf(tmp[1]);
		String chuoi2 = String.valueOf(tmp[2]);
		String strEnd = chuoi + chuoi1 + chuoi2;
		str = Integer.parseInt(strEnd);
		
		if (str + 1 <10) {
			id = "SP00" + String.valueOf(str+1);
		}
		else if(str+1<100)
		{
			id = "SP0" + String.valueOf(str+1);
		}
		else if (str+1<1000) {
			id = "SP" + String.valueOf(str+1);
		}
		return id;
	}
	
	public void updateGiaBan(String id, Float giaBan)
	{
		String str = id +"/" + String.valueOf(giaBan);
		arrUpdate.add(str);
	}
	
	public void updateGiaBan2()
	{
		for(int i=0; i<arrUpdate.size(); i++)
		{
		    String str[] = arrUpdate.get(i).split("/");
		    for (SANPHAM o : data) {
				if(str[0].equalsIgnoreCase(o.getMaSP()))
				{
					o.setGiaSP(Float.parseFloat(str[1]));
					break;
				}
			}
		}
	}
	
	public void updateGiaBan_SoLuong(String id,int SoLuong,Float giaNhap)
	{
		
		int soLuongNew=0, soLuongOld=0;
		for (SANPHAM o : data) {
			if(id.equals(o.getMaSP()))
			{
				soLuongOld = o.getSoLuongSP();
				soLuongNew = soLuongOld + SoLuong;
				o.setSoLuongSP(soLuongNew);
				o.setGiaNhap(giaNhap);
				SANPHAMDAO.getInstance().update(o);
				break;
			}
		}
	}
	
	public void updateGiaBan_SoLuong1(String id,int SoLuong)
	{
		
		int soLuongNew=0, soLuongOld=0;
		for (SANPHAM o : data) {
			if(id.equals(o.getMaSP()))
			{
				soLuongOld = o.getSoLuongSP();
				soLuongNew = soLuongOld - SoLuong;
				o.setSoLuongSP(soLuongNew);
				SANPHAMDAO.getInstance().update(o);
				break;
			}
		}
	}
	
	public void txtTimKiem(JTextField txt, JTable table)
	{
		txt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(txt.getText().equals(""))
				{
					loadDataToTable_UseArray(table);
				}
				else {
					String value = txt.getText().toLowerCase();
					ArrayList<SANPHAM> arrTimKiem = new ArrayList<>();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					for(SANPHAM o : data)
					{
						if(o.getMaSP().toLowerCase().contains(value) || o.getTenSP().toLowerCase().contains(value))
						{
							arrTimKiem.add(o);
						}
					}
					model.setRowCount(0);
					for (int i=0; i<arrTimKiem.size(); i++) {
						model.addRow(new Object[] {i+1, arrTimKiem.get(i).getMaSP(), getTenTH_formID(arrTimKiem.get(i).getMaTH()), arrTimKiem.get(i).getTenSP(),
								getSize_fromID(arrTimKiem.get(i).getKichCo()), getMau_fromID(arrTimKiem.get(i).getMauSac()), arrTimKiem.get(i).getSoLuongSP(),
								arrTimKiem.get(i).getGiaSP() });
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
