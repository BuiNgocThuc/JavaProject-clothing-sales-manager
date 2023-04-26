/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.LoginForm;

import Back_End.TAIKHOAN.TAIKHOANBUS;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.*;

/**
 *
 * @author NGOC THUC
 */
public class LoginForm extends JFrame {

    JLabel lblAvatar = new JLabel("",JLabel.CENTER);
    JPanel pnContainer = new GradientPanel();
    JLabel lblClose = new JLabel("X", JLabel.CENTER);
    JLabel lblMinimize = new JLabel("_", JLabel.CENTER);
    JLabel lblUserName = new JLabel("Tài Khoản: ", JLabel.CENTER);
    JLabel lblPassWord = new JLabel("Mật Khẩu: ", JLabel.CENTER);
    JLabel lblUsernameIcon = new JLabel("", JLabel.CENTER);
    JLabel lblPasswordIcon = new JLabel("",JLabel.CENTER);
    
    JTextField txtUserName = new JTextField();
    JPasswordField txtPassword = new JPasswordField();
    
    JLabel lblLogin = new JLabel("Đăng Nhập", JLabel.CENTER);
    
     Font font = new Font("Dosis", Font.BOLD, 16);
     Font font1 = new Font("Dosis", Font.BOLD, 20);
     Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);

    public LoginForm() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextField getUsername() {
        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }

    public JPasswordField getPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }
    
    

    public void initComponents() {
        this.setSize(400, 500);
        this.add(panelContainer());
        
        //  pnContainer.add(lblAvatar);

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

    public JPanel panelContainer() {

        lblClose.setBounds(365, 0, 30, 30);
        lblClose.setFont(font1);
        lblClose.setCursor(new Cursor(HAND_CURSOR));
        lblClose.setForeground(Color.white);
        lblClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        lblMinimize.setBounds(330, -5, 30, 30);
        lblMinimize.setFont(font1);
        lblMinimize.setCursor(new Cursor(HAND_CURSOR));
        lblMinimize.setForeground(Color.white);
        lblMinimize.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblMinimize);
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        
        lblAvatar.setBounds(0, 30, 400, 100);
        lblAvatar.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-male-user-100.png")));
        
        lblUserName.setBounds(30,160,120,20);
        lblUserName.setForeground(Color.white);
        lblUserName.setFont(font);
        
         lblPassWord.setBounds(30,260,120,20);
        lblPassWord.setForeground(Color.white);
        lblPassWord.setFont(font);
        
        txtUserName.setBounds(50, 195, 250,30);
        txtUserName.setBorder(border);
        txtUserName.setOpaque(false);
        txtUserName.setBackground(new Color(0, 0, 0, 0));
        
        txtPassword.setBounds(50, 295, 250,30);
        txtPassword.setBorder(border);
        txtPassword.setOpaque(false);
        txtPassword.setBackground(new Color(0, 0, 0, 0));

        lblUsernameIcon.setBounds(320, 180, 50,50);
        lblUsernameIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/user.png")));
        
        lblPasswordIcon.setBounds(320, 280, 50,50);
        lblPasswordIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/password.png")));
        
        lblLogin.setBounds(55,380,300,40);
        lblLogin.setForeground(Color.white);
        lblLogin.setBackground(Color.black);
        lblLogin.setOpaque(true);
        lblLogin.setFont(font1);
        lblLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new TAIKHOANBUS().login(LoginForm.this);
            }
        });
        
        pnContainer.setPreferredSize(new Dimension(400, 500));
        pnContainer.setLayout(null);
        
        pnContainer.add(lblUserName);
        pnContainer.add(lblPassWord);
        pnContainer.add(lblAvatar);
        pnContainer.add(lblClose);
        pnContainer.add(lblMinimize);
        pnContainer.add(lblLogin);
        pnContainer.add(lblUsernameIcon);
        pnContainer.add(lblPasswordIcon);
        
        pnContainer.add(txtUserName);
        pnContainer.add(txtPassword);

        return pnContainer;
    }
    
    

    public static void main(String[] args) {
        new LoginForm();
    }
}
