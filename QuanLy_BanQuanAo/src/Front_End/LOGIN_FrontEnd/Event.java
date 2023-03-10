/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.LOGIN_FrontEnd;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author NGOC THUC
 */
public class Event implements MouseListener {

    private JPanel pnMainContent, pnComponent;
    Font original;

    public Event(JPanel pnM, JPanel pnC) {
        this.pnMainContent = pnM;
        this.pnComponent = pnC;
    }

//    private JPanel mainContent;
//    private String order;
//    private LayoutManager layout;
//    public Event(JPanel mainContent, LayoutManager layout, String order) {
//        this.mainContent = mainContent;
//        this.order = order;
//        this.layout = layout;
//    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        if (layout instanceof CardLayout) {
//            
//            CardLayout cl = (CardLayout) layout;
//            cl.show(mainContent, order);
//            System.out.println("Da click " + order);
//        }
//       System.out.println("Da xong");

        pnMainContent.removeAll();
        pnMainContent.add(pnComponent);
        pnMainContent.repaint();
        pnMainContent.revalidate();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        original = e.getComponent().getFont();
//        Map attributes = original.getAttributes();
//        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        e.getComponent().setFont(original.deriveFont(attributes));
            
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        e.getComponent().setFont(original);
    }

}
