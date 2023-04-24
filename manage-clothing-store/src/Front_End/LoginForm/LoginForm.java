/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.LoginForm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NGOC THUC
 */
public class LoginForm extends JFrame {

    JPanel pnContainer = new GradientPanel();
    JLabel lblClose = new JLabel("X", JLabel.CENTER);
    JLabel lblMinimize = new JLabel("_", JLabel.CENTER);
    JLabel lblAvatar = new JLabel();
    
    Font font = new Font("Dosis", Font.BOLD, 18);
    
    public LoginForm() {
        initComponents();
    }

    public void initComponents() {
        this.setSize(400, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        lblClose.setBounds(350,0,30,30);
        lblClose.setFont(font);
        lblClose.setCursor(new Cursor(HAND_CURSOR));
        
        lblMinimize.setBounds(320,-5,30,30);
        lblMinimize.setFont(font);
        lblMinimize.setCursor(new Cursor(HAND_CURSOR));
        
        lblAvatar.setBounds(0, 50, 200, 200);
        lblAvatar.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-male-user-100.png"));
        
        pnContainer.setPreferredSize(new Dimension(400, 500));
        pnContainer.setLayout(null);
        pnContainer.add(lblClose);
        pnContainer.add(lblMinimize);
      //  pnContainer.add(lblAvatar);
        
        
        this.add(pnContainer);
    }

    class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Lấy chiều rộng và chiều cao của JPanel
            int w = getWidth();
            int h = getHeight();

            // Tạo GradientPaint từ màu đầu và màu cuối
            GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#fca5f1"), w, h, Color.decode("#b5ffff"));

            // Vẽ GradientPaint trên JPanel
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, w, h);
        }
        
        
    }
    
    

    public static void main(String[] args) {
        new LoginForm();
    }
}
