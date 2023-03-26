/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.NHACUNGCAP;

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
import javax.swing.JButton;
import javax.swing.JTable;

public class NHACUNGCAPGUI {
    private JPanel jp,jp1;
    private JLabel l1,l2,l3,l4;
    private JTextField tf1,tf2,tf3;
    private JButton bt1,bt2,bt3,bt4;
    private JTable tb;
    private JScrollPane jsp;
    
    public NHACUNGCAPGUI(JFrame f){
        init(f);
    }
    
    private void init(JFrame f){
        jp = new JPanel();
        
        jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp1.setPreferredSize(new Dimension(400,250));
        jp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jp1.setBorder(BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));
        
        l1 = new JLabel("Mã nhà cung cấp: ");
        l1.setBounds(10, 10, 50, 30);
        jp1.add(l1);
        
        tf1 = new JTextField(33);
        jp1.add(tf1);
        
        l2 = new JLabel("Tên nhà cung cấp");
        l2.setBounds(10, 70, 50, 30);
        jp1.add(l2);
        
        tf2 = new JTextField(33);
        jp1.add(tf2);
        
        l3 = new JLabel("Số điện thoại");
        l3.setBounds(10,240,50,30);
        jp1.add(l3);
        
        tf3 = new JTextField(33);
        jp1.add(tf3);
        
        l4 = new JLabel("Địa chỉ");
        l4.setBounds(10,270, 50 , 30);
        jp1.add(l4);
        
        tf3 = new JTextField(33);
        jp1.add(tf3);
        
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
                {" "," "," "," "},
            {" "," "," "," "},
            {" "," "," "," "}
        };
        
        String [] column = {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ"};
        tb = new JTable(data,column);
        jsp = new JScrollPane(tb);
        tb.setFillsViewportHeight(true);
        
        jp.add(jp1, BorderLayout.NORTH);
        jp.add(jsp, BorderLayout.SOUTH);
        f.add(jp);
    }
}
