package Front_End.SANPHAM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import Back_End.SANPHAM.SANPHAMBUS;
import Back_End.KICHCO.KICHCOBUS;
import Back_End.MAUSAC.MAUSACBUS;
import Back_End.SANPHAM.SANPHAM;

public class CHUCNANGTHEM extends JFrame{
	SANPHAMBUS spb = new SANPHAMBUS();
	SANPHAM spThem;
	
	JLabel txtMaSP = new JLabel("", JLabel.CENTER);
	JTextField txtMaTH = new JTextField(10);
	JTextField txttenSP = new JTextField(10);
	JTextField txtdonGia = new JTextField(10);
	JTextField txthinhAnh = new JTextField(10);
	 
	JButton btnChonAnh = new JButton();
	JButton btnChonTH = new JButton();
	JButton btnThem = new JButton("THÊM");
	JButton btnHuy = new JButton("HỦY");
	
	JComboBox<String> cbSize;
	JComboBox<String> cbColor;
	
	KICHCOBUS kcb = new KICHCOBUS();
	MAUSACBUS msb = new MAUSACBUS();
	
	public CHUCNANGTHEM()
	{
		init();
	}
	
	public void init()
	{
		this.setLayout(null);
		this.setSize(450, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("Thêm sản phẩm");
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,this.getWidth(),this.getHeight());
		panel.setLayout(new BorderLayout());
		panel.setBackground(new Color(52, 152, 219));
		// input
		txtMaSP.setBorder(BorderFactory.createTitledBorder("Mã SP"));
		txtMaSP.setPreferredSize(new Dimension(100, 50));
		txtMaSP.setText(spb.autoID());
		txtMaTH.setBorder(BorderFactory.createTitledBorder(" "));
		txttenSP.setBorder(BorderFactory.createTitledBorder("Tên SP"));
		cbSize = new JComboBox<String>();
		cbSize.setModel(kcb.setModel());
		cbColor = new JComboBox<String>();
		cbColor.setModel(msb.getModel());
		txtdonGia.setBorder(BorderFactory.createTitledBorder("Đơn giá(trăm)"));
		txthinhAnh.setBorder(BorderFactory.createTitledBorder(" "));
		
		
		btnChonTH.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_more_20px.png")));
		btnChonTH.setPreferredSize(new Dimension(30,30));
		btnChonTH.setBackground(Color.white);
		btnChonAnh.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_opened_folder_20px.png")));
		btnChonAnh.setPreferredSize(new Dimension(30, 30));
		btnChonAnh.setBackground(Color.white);
		
		JPanel plChonTH = new JPanel();
		plChonTH.setBorder(BorderFactory.createTitledBorder("Mã TH"));
		plChonTH.add(txtMaTH);
		plChonTH.add(btnChonTH);
		
		JPanel plChonAnh = new JPanel();
		plChonAnh.setBorder(BorderFactory.createTitledBorder("Tên file ảnh"));
		plChonAnh.add(txthinhAnh);
		plChonAnh.add(btnChonAnh);
		
		JPanel plChonSize = new JPanel();
		plChonSize.setBorder(BorderFactory.createTitledBorder("Size"));
		plChonSize.add(cbSize);
		
		JPanel plChonMau = new JPanel();
		plChonMau.setBorder(BorderFactory.createTitledBorder("Màu sắc"));
		plChonMau.add(cbColor);
		
		JPanel plInput = new JPanel();
		plInput.add(txtMaSP);
		plInput.add(plChonTH);
		plInput.add(txttenSP);
		plInput.add(plChonSize);
		plInput.add(plChonMau);
		plInput.add(txtdonGia);
		plInput.add(plChonAnh);
		
		// panel button
		JPanel plButton = new JPanel();
		btnThem.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-28.png")));
		btnThem.setBackground(Color.white);
		plButton.add(btnThem);
		btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
		btnHuy.setBackground(Color.white);
		plButton.add(btnHuy);
		
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mouseClickThem();
			}
		});
		
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mouseClickHuy();		
			}
		});
		
		btnChonAnh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mouseClickChonAnh();
			}
		});
		
		btnChonTH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormChonTH a = new FormChonTH(txtMaTH);			 
			}
		});
		
		panel.add(plInput,BorderLayout.CENTER);
		panel.add(plButton,BorderLayout.SOUTH);
		this.add(panel);
		this.setVisible(true);
	}
	
	private void mouseClickChonAnh() {
		FileDialog fd = new FileDialog(this);
		fd.setVisible(true);
		String fileName = fd.getFile(); 
		
		if(fileName!=null)
		{
			String direct = fd.getDirectory();
			File fileSrc = new File(direct);
			File fileDest = new File("\\Users\\HP\\Documents\\Project_JAVA\\manage-clothing-store\\src\\Icon\\icon_img");
			File file1 = new File(fileSrc, fileName);
			File file2 = new File(fileDest,fileName);
			try {
				InputStream in = new FileInputStream(file1);
				OutputStream out = new FileOutputStream(file2);
				
				byte[] buffer = new byte[1024];
				int lenghth;
				while ((lenghth= in.read(buffer)) > 0) {
					out.write(buffer,0,lenghth);
				}
				
				in.close();
				out.close();
				System.out.println("File được copy from " + fileSrc + " đến " + fileDest);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			txthinhAnh.setText(fileName);
		}
	}
	
	private void mouseClickThem() {
		if(checkInput())
		{
			String maSP = txtMaSP.getText();
			String maTH = txtMaTH.getText();
			String tenSP = txttenSP.getText();
			String size = cbSize.getSelectedItem().toString();
			String color = cbColor.getSelectedItem().toString();
			Float donGia = Float.parseFloat(txtdonGia.getText());
			String hinhAnh = txthinhAnh.getText();
			
			spThem = new SANPHAM(maSP, maTH, tenSP, size, color, donGia, 0, "Còn", hinhAnh);
			if(spb.addSP(spThem))
			{
				JOptionPane.showMessageDialog(this,"Thêm thành công");
				this.dispose();
			}
		}
	}
	
	private void mouseClickHuy() {
		this.dispose();
	}
	
	private Boolean checkInput() {
		String maTH = txtMaTH.getText();
		String tenSP = txttenSP.getText();
		String donGia = txtdonGia.getText();
		String hinhAnh = txthinhAnh.getText();
		
		if(tenSP.trim().equals(""))
		{
			return showErr(txttenSP, "Tên không được để trống");
		}
		else if(maTH.trim().equals(""))
		{
			return showErr(txtMaTH, "Mã thương hiệu không được để trống");
		}
		else if(donGia.trim().equals(""))
		{
			return showErr(txtdonGia, "Đơn giá không được để trống");
		}
		else if(hinhAnh.trim().equals(""))
		{
			return showErr(txthinhAnh, "Đường dẫn ảnh không được để trống");
		}
		else {
			try {
				Float dg = Float.parseFloat(donGia);
			} catch (NumberFormatException e) {
				return showErr(txtdonGia, "Đơn giá không hợp lê(Phải là số thực)");
			}
		}
		return true;
	}
	
	private Boolean showErr(JTextField tf, String error) {
		JOptionPane.showMessageDialog(tf, error);
		tf.requestFocus();
		return false;
	}
	
	/*public static void main(String[] args) {
		File fileScr = new File("D:\\Downloads");
	    File fileDest = new File("\\Users\\HP\\Documents\\Project_JAVA\\manage-clothing-store\\src\\Icon\\icon_img");
	    File file1 = new File(fileScr, "img1.jpg");
	    File file2 = new File(fileDest, "img1.jpg");
	    try {
			InputStream in = new FileInputStream(file1);
			OutputStream out = new FileOutputStream(file2);
			
			byte[] buffer = new byte[1024];
			int lenghth;
			while ((lenghth= in.read(buffer)) > 0) {
				out.write(buffer,0,lenghth);
			}
			
			in.close();
			out.close();
			System.out.println("File được copy from " + fileScr + " đến " + fileDest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


}
