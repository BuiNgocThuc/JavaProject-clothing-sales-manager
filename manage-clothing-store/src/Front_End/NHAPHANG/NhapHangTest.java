/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front_End.NHAPHANG;

import java.awt.BorderLayout;

import javax.swing.JFrame;


/**
 *
 * @author NGOC THUC
 */
public class NhapHangTest{
   public static void main(String[] args) {
	   JFrame f = new JFrame();
	   f.setSize(1000, 800);
	   f.setLocationRelativeTo(null);
	   f.setLayout(new BorderLayout());
	   f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	   f.add(new NHAPHANGGUI());
	   f.setVisible(true);
   }
    
}
