/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Front_End.NHANVIEN;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;

public class NHANVIENGUI {

    private JPanel jp,jp1,jp2;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JTextField tf1,tf2,tf3,tf4,tf5;
    private ButtonGroup btg;
    private JButton bt1,bt2,bt3,bt4;
    private JTable tb;
    private JScrollPane jsp;
    
    public NHANVIENGUI(JFrame f){
        init(f);
    }
    
    private void init(JFrame f){
        jp = new JPanel();
        
        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400,330));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin"));
        
        l1 = new JLabel("Mã nhân viên: ");
        l1.setBounds(10, 10, 50, 30);
        jp1.add(l1);
        
        tf1 = new JTextField(33);

        jp1.add(tf1);
        
        l2 = new JLabel("Họ và tên");
        l2.setBounds(10, 70, 50, 30);
        jp1.add(l2);
        
        tf2 = new JTextField(33);
        jp1.add(tf2);
        
        l3 = new JLabel("Tuổi");
        l3.setBounds(10, 130, 50, 30);
        jp1.add(l3);
        
        tf3 = new JTextField(33);
        jp1.add(tf3);
        
        l4 = new JLabel("Giới tính");
        l4.setBounds(10, 190, 50, 30);
        jp1.add(l4);
        
        btg = new ButtonGroup();
        JRadioButton male = new JRadioButton("Nam");
        JRadioButton female = new JRadioButton("Nữ");
        btg.add(male);
        btg.add(female);
        jp2 = new JPanel();
        jp2.setPreferredSize(new Dimension(280,30));
        jp2.add(male);
        jp2.add(female);
        jp1.add(jp2);
        
        l5 = new JLabel("Số điện thoại");
        l5.setBounds(10,240,50,30);
        jp1.add(l5);
        
        tf4 = new JTextField(33);
        jp1.add(tf4);
        
        l6 = new JLabel("Địa chỉ");
        l6.setBounds(10,270, 50 , 30);
        jp1.add(l6);
        
        tf5 = new JTextField(33);
        jp1.add(tf5);
        
        bt1 = new JButton("Thêm");
        bt1.setPreferredSize(new Dimension(70, 30));
	jp1.add(bt1);
        
        bt2 = new JButton("Sửa");
	bt2.setPreferredSize(new Dimension(70, 30));
	jp1.add(bt2);	
        
        bt3 = new JButton("Xóa");
	bt3.setPreferredSize(new Dimension(70, 30));
        jp1.add(bt3);
        
        bt4 = new JButton("Tìm kiếm");
	bt4.setPreferredSize(new Dimension(100, 30));
        jp1.add(bt4);
            
        String [][] data = {
                {" "," "," "," "," "," "},
            {" "," "," "," "," "," "},
            {" "," "," "," "," "," "}
        };
        
        String [] column = {"Mã nhân viên","Họ và tên","Tuổi","Giới tính","Số điện thoại","Địa chỉ"};
        tb = new JTable(data,column);
        jsp = new JScrollPane(tb);
        tb.setFillsViewportHeight(true);
        
        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.SOUTH);
        f.add(jp);
    }
    
}
