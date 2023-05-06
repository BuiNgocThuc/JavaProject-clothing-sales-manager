package Front_End.BANHANG;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Front_End.SANPHAM.SANPHAMGUI;

public class BanHangTest extends JFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 800);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.add(new BANHANGGUI());
    	f.setVisible(true);
	}
}