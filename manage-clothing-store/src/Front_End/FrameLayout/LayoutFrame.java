package Front_End.FrameLayout;

import Front_End.HandleEvent.EventInLabel;
import Front_End.KHUYENMAI.KHUYENMAIGUI;
import Front_End.PHANQUYEN.PHANQUYENGUI;
import Front_End.TAIKHOAN.TAIKHOANGUI;
import Front_End.THONGKE.THONGKEGUI;
import Front_End.THONGKE.ThongKe;
import Front_End.THUONGHIEU.THUONGHIEUGUI;
import Front_End.BANHANG.BANHANGGUI;
import Front_End.HOADON.HOADONGUI;
import Front_End.KHACHHANG.KHACHHANGGUI;
import Front_End.LoginForm.LoginForm;
import Front_End.NHACUNGCAP.NHACUNGCAPGUI;
import Front_End.NHANVIEN.NHANVIENGUI;
import Front_End.NHAPHANG.NHAPHANGGUI;
import Front_End.PHIEUNHAP.PHIEUNHAPGUI;
import Front_End.SANPHAM.SANPHAMGUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author NGOC THUC
 */
public class LayoutFrame extends JFrame {

    int widthBar = 180, heightBar = 0;
    int widthMainPN = 820, heightMainPN = 0;
    
    Map<JLabel, Boolean> labelStates = new HashMap<>();

    JPanel pnContainer = new JPanel();
    JPanel pnHeader = new JPanel();
    JPanel pnMenu = new JPanel();
    JPanel pnMainContent = new JPanel();
    JPanel pnHello = new JPanel();
    JLabel lblInfoUser = new JLabel("Xin Chào, Bùi Ngọc Thức", JLabel.CENTER);

    JLabel lblMinimize = new JLabel();
    JLabel lblClose = new JLabel("X", JLabel.CENTER);
    JLabel lblLogOut = new JLabel();
    JLabel lblWelcome = new JLabel("Hôm nay là: ");

    JLabel lblSetting = new JLabel();
    JPanel btnMenu = new JPanel();
    JLabel closeMenu = new JLabel();
    JLabel openMenu = new JLabel();

    JScrollPane sbMenu = new JScrollPane();
    JPanel pnFunction = new JPanel();
    JLabel lblLogo = new JLabel("", JLabel.CENTER);
    JLabel lblBanHang = new JLabel("Bán Hàng", JLabel.LEFT);
    JLabel lblNhapHang = new JLabel("Nhập Hàng", JLabel.LEFT);
    JLabel lblSanPham = new JLabel("Sản Phẩm", JLabel.LEFT);
    JLabel lblThuongHieu = new JLabel("Thương Hiệu", JLabel.LEFT);
    JLabel lblHoaDon = new JLabel("Hóa Đơn", JLabel.LEFT);
    JLabel lblPhieuNhap = new JLabel("Phiếu Nhập", JLabel.LEFT);
    JLabel lblNhanVien = new JLabel("Nhân Viên", JLabel.LEFT);
    JLabel lblKhachHang = new JLabel("Khách Hàng", JLabel.LEFT);
    JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp", JLabel.LEFT);
    JLabel lblThongKe = new JLabel("Thống Kê", JLabel.LEFT);
    JLabel lblKhuyenMai = new JLabel("Khuyến Mại", JLabel.LEFT);
    JLabel lblTaiKhoan = new JLabel("Tài Khoản", JLabel.LEFT);
    JLabel lblPhanQuyen = new JLabel("Phân Quyền", JLabel.LEFT);

    ArrayList<JLabel> dslbl = new ArrayList<>();

    Font font = new Font("Arial", Font.ITALIC, 18);
    Font font2 = new Font("Arial", Font.ITALIC, 20);
    Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE);

    public JPanel getPnMainContent() {
        return pnMainContent;
    }

    public void setPnMainContent(JPanel pnMainContent) {
        this.pnMainContent = pnMainContent;
    }

    public LayoutFrame() {
//        this.setUndecorated(true);
        initComponents();
    }

    void initComponents() {

        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());
        this.add(container(), BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        solveActionMenu();
    }

    void solveActionMenu() {
        lblBanHang.addMouseListener(new EventInLabel(pnMainContent, new BANHANGGUI()));
        lblNhapHang.addMouseListener(new EventInLabel(pnMainContent, new NHAPHANGGUI()));
       lblSanPham.addMouseListener(new EventInLabel(pnMainContent, new SANPHAMGUI()));
        lblThuongHieu.addMouseListener(new EventInLabel(pnMainContent, new THUONGHIEUGUI()));
        lblHoaDon.addMouseListener(new EventInLabel(pnMainContent, new HOADONGUI()));
        lblPhieuNhap.addMouseListener(new EventInLabel(pnMainContent, new PHIEUNHAPGUI()));
        lblKhachHang.addMouseListener(new EventInLabel(pnMainContent, new KHACHHANGGUI()));
        lblNhanVien.addMouseListener(new EventInLabel(pnMainContent, new NHANVIENGUI()));
        lblNhaCungCap.addMouseListener(new EventInLabel(pnMainContent, new NHACUNGCAPGUI()));
        lblKhuyenMai.addMouseListener(new EventInLabel(pnMainContent, new KHUYENMAIGUI()));
        lblTaiKhoan.addMouseListener(new EventInLabel(pnMainContent, new TAIKHOANGUI()));
        lblPhanQuyen.addMouseListener(new EventInLabel(pnMainContent, new PHANQUYENGUI()));
        lblThongKe.addMouseListener(new EventInLabel(pnMainContent, new THONGKEGUI()));
    }

    public JPanel container() {

        pnContainer.setBackground(Color.WHITE);
        pnContainer.setOpaque(true);
        pnContainer.setLayout(new BorderLayout());
        pnContainer.add(navbar(), BorderLayout.NORTH);
        pnContainer.add(sidebar(), BorderLayout.WEST);
        pnContainer.add(mainContent(), BorderLayout.CENTER);

        return pnContainer;
    }

    public JLabel getInfoUser() {
        return lblInfoUser;
    }

    public void setLblInfoUser(JLabel lblInfoUser) {
        this.lblInfoUser = lblInfoUser;
    }

    public JPanel getPnContainer() {
        return pnContainer;
    }

    public void setPnContainer(JPanel pnContainer) {
        this.pnContainer = pnContainer;
    }

    public JLabel getLblBanHang() {
        return lblBanHang;
    }

    public void setLblBanHang(JLabel lblBanHang) {
        this.lblBanHang = lblBanHang;
    }

    public JLabel getLblNhapHang() {
        return lblNhapHang;
    }

    public void setLblNhapHang(JLabel lblNhapHang) {
        this.lblNhapHang = lblNhapHang;
    }

    public JLabel getLblSanPham() {
        return lblSanPham;
    }

    public void setLblSanPham(JLabel lblSanPham) {
        this.lblSanPham = lblSanPham;
    }

    public JLabel getLblThuongHieu() {
        return lblThuongHieu;
    }

    public void setLblThuongHieu(JLabel lblThuongHieu) {
        this.lblThuongHieu = lblThuongHieu;
    }

    public JLabel getLblHoaDon() {
        return lblHoaDon;
    }

    public void setLblHoaDon(JLabel lblHoaDon) {
        this.lblHoaDon = lblHoaDon;
    }

    public JLabel getLblPhieuNhap() {
        return lblPhieuNhap;
    }

    public void setLblPhieuNhap(JLabel lblPhieuNhap) {
        this.lblPhieuNhap = lblPhieuNhap;
    }

    public JLabel getLblNhanVien() {
        return lblNhanVien;
    }

    public void setLblNhanVien(JLabel lblNhanVien) {
        this.lblNhanVien = lblNhanVien;
    }

    public JLabel getLblKhachHang() {
        return lblKhachHang;
    }

    public void setLblKhachHang(JLabel lblKhachHang) {
        this.lblKhachHang = lblKhachHang;
    }

    public JLabel getLblNhaCungCap() {
        return lblNhaCungCap;
    }

    public void setLblNhaCungCap(JLabel lblNhaCungCap) {
        this.lblNhaCungCap = lblNhaCungCap;
    }

    public JLabel getLblThongKe() {
        return lblThongKe;
    }

    public void setLblThongKe(JLabel lblThongKe) {
        this.lblThongKe = lblThongKe;
    }

    public JLabel getLblKhuyenMai() {
        return lblKhuyenMai;
    }

    public void setLblKhuyenMai(JLabel lblKhuyenMai) {
        this.lblKhuyenMai = lblKhuyenMai;
    }

    public JLabel getLblTaiKhoan() {
        return lblTaiKhoan;
    }

    public void setLblTaiKhoan(JLabel lblTaiKhoan) {
        this.lblTaiKhoan = lblTaiKhoan;
    }

    public JLabel getLblPhanQuyen() {
        return lblPhanQuyen;
    }

    public void setLblPhanQuyen(JLabel lblPhanQuyen) {
        this.lblPhanQuyen = lblPhanQuyen;
    }

    public JPanel navbar() {
        pnHeader.setBackground(Color.BLACK);
        pnHeader.setOpaque(true);
        pnHeader.setPreferredSize(new Dimension(0, 80));
        pnHeader.setLayout(null);
        pnHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        lblLogOut.setBounds(930, 15, 50, 50);
        lblLogOut.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-log-out-32 (3).png"));
        lblLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Thực hiện các xử lý khi người dùng click vào nút logout ở đây
                // Ví dụ: hiển thị dialog xác nhận đăng xuất
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {

                    // Đóng form hiện tại
                    dispose();
                    // Thực hiện đăng xuất
                    // Ví dụ: chuyển đến form đăng nhập
                    LoginForm lgF = new LoginForm();
                    lgF.setVisible(true);
                }
            }
        });

        lblClose.setBounds(870, 15, 50, 50);
        lblClose.setBackground(Color.BLACK);
        lblClose.setOpaque(true);
        lblClose.setForeground(Color.WHITE);
        lblClose.setFont(new Font("Arial", Font.BOLD, 25));
        lblClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        lblMinimize.setBounds(810, 15, 50, 50);
        lblMinimize.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-subtract-50.png"));
        lblMinimize.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                LayoutFrame.this.setState(JFrame.ICONIFIED);
            }
        });

        btnMenu.setBounds(20, 15, 50, 50);
        btnMenu.setBackground(Color.black);
        btnMenu.setOpaque(true);
        btnMenu.setLayout(new CardLayout());

        closeMenu.setPreferredSize(new Dimension(50, 50));
        closeMenu.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-close-40.png"));
        closeMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                closeMenu();
                btnMenu.removeAll();
                btnMenu.add(openMenu);
                btnMenu.repaint();
                btnMenu.revalidate();
                pnMenu.setPreferredSize(new Dimension(0, 0));
            }
        });

        openMenu.setPreferredSize(new Dimension(50, 50));
        openMenu.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-menu-40.png"));
        openMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openMenu();
                btnMenu.removeAll();
                btnMenu.add(closeMenu);
                btnMenu.repaint();
                btnMenu.revalidate();
                pnMenu.setPreferredSize(new Dimension(180, 0));
            }
        });

        btnMenu.add(closeMenu, "close");
        btnMenu.add(openMenu, "open");

        pnHeader.add(btnMenu);
        pnHeader.add(lblClose);
        pnHeader.add(lblMinimize);
        pnHeader.add(lblLogOut);
        return pnHeader;
    }

    public JPanel sidebar() {
        dslbl.add(lblBanHang);
        dslbl.add(lblNhapHang);
        dslbl.add(lblSanPham);
        dslbl.add(lblThuongHieu);
        dslbl.add(lblHoaDon);
        dslbl.add(lblPhieuNhap);
        dslbl.add(lblNhanVien);
        dslbl.add(lblKhachHang);
        dslbl.add(lblNhaCungCap);
        dslbl.add(lblThongKe);
        dslbl.add(lblKhuyenMai);
        dslbl.add(lblTaiKhoan);
        dslbl.add(lblPhanQuyen);

        pnFunction.setBackground(Color.black);
        pnFunction.setOpaque(true);
        pnFunction.setPreferredSize(new Dimension(180, 950));
        pnFunction.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        pnFunction.add(lblLogo);

        for (JLabel lbl : dslbl) {
            lbl.setPreferredSize(new Dimension(180, 50));
            lbl.setBackground(Color.black);
            lbl.setForeground(Color.white);
            lbl.setOpaque(true);
            lbl.setFont(font);
            lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
 labelStates.put(lbl, false);

    lbl.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            lbl.setBackground(Color.decode("#FFCC00"));
            lbl.setForeground(Color.black);
        }

        public void mouseExited(MouseEvent e) {
            if (!labelStates.get(lbl)) {
                lbl.setBackground(Color.black);
                lbl.setForeground(Color.white);
            }
        }

        public void mouseClicked(MouseEvent e) {
            for (JLabel label : labelStates.keySet()) {
                labelStates.put(label, false);
                label.setBackground(Color.black);
                label.setForeground(Color.white);
            }

            labelStates.put((JLabel) e.getSource(), true);
            ((JLabel) e.getSource()).setBackground(Color.decode("#FFCC00"));
            ((JLabel) e.getSource()).setForeground(Color.black);
        }
    });

            pnFunction.add(lbl);
        }

        pnMenu.setBackground(Color.black);
        pnMenu.setOpaque(true);
        pnMenu.setPreferredSize(new Dimension(180, 0));
        pnMenu.setLayout(null);

        lblLogo.setPreferredSize(new Dimension(180, 100));
        lblLogo.setBackground(Color.black);
        lblLogo.setOpaque(true);
        lblLogo.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/fashion boulevard.png"));

        lblBanHang.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-shopping-basket-32.png"));
        lblNhapHang.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-add-product-32.png"));
        lblSanPham.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-formal-outfit-32.png"));
        lblThuongHieu.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-adidas-trefoil-32.png"));
        lblHoaDon.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-receipt-dollar-32.png"));
        lblPhieuNhap.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-receipt-32.png"));
        lblNhanVien.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-sales-agent-32.png"));
        lblKhachHang.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-customer-32.png"));
        lblNhaCungCap.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-supplier-32.png"));
        lblThongKe.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-statistic-32.png"));
        lblKhuyenMai.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-discount-32.png"));
        lblTaiKhoan.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-user-32.png"));
        lblPhanQuyen.setIcon(new ImageIcon("E:/nam II - HKII/java/DO_AN_BAN_QUAN_AO/JavaProject-clothing-sales-manager/manage-clothing-store/src/Icon/icon_img/icons8-decentralization-32.png"));

        sbMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sbMenu.setBounds(0, 0, 180, 520);
        sbMenu.setViewportView(pnFunction);
           sbMenu.getVerticalScrollBar().setUnitIncrement(10);
        pnMenu.add(sbMenu);
        return pnMenu;
    }
    
    public void openMenu() {
        int initialWidth = pnMenu.getPreferredSize().width;
        int steps = 200 / 10; // 10 ms interval between each step
        int stepWidth = widthBar / steps;

        Timer timer = new Timer(10, new ActionListener() {
            int currentWidth = initialWidth;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentWidth += stepWidth;
                if (currentWidth >= widthBar) {
                    currentWidth = widthBar;
                    ((Timer) e.getSource()).stop();
                }
                Dimension newPreferredSize = new Dimension(currentWidth, pnMenu.getPreferredSize().height);
                pnMenu.setPreferredSize(newPreferredSize);
                pnMenu.revalidate();
            }
        });
        timer.start();
    }
    
    public void closeMenu() {
        int initialWidth = pnMenu.getPreferredSize().width;
        int steps = 200 / 10; // 10 ms interval between each step
        int stepWidth = initialWidth / steps;

        Timer timer = new Timer(10, new ActionListener() {
            int currentWidth = initialWidth;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentWidth -= stepWidth;
                if (currentWidth <= 0) {
                    currentWidth = 0;
                    ((Timer) e.getSource()).stop();
                }
                Dimension newPreferredSize = new Dimension(currentWidth, pnMenu.getPreferredSize().height);
                pnMenu.setPreferredSize(newPreferredSize);
                pnMenu.revalidate();
            }
        });
        timer.start();
    }
    
    public JPanel mainContent() {
        
        pnMainContent.setPreferredSize(new Dimension(820, 0));
        
        pnMainContent.setLayout(new CardLayout());
        pnMainContent.add(Hello());
        return pnMainContent;
    }
    
    JPanel Hello() {
        pnHello.setSize(900, 400);
        pnHello.setLayout(null);
        pnHello.setBackground(Color.white);
        pnHello.setOpaque(true);
        
        lblInfoUser.setBounds(350, 120, 400, 50);
        lblInfoUser.setForeground(Color.black);
        lblInfoUser.setFont(font2);
        
         //set Img
         // Lấy thứ, ngày và tháng hiện tại
        LocalDate today = LocalDate.now();
        String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("vi-VN"));
        int dayOfMonth = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        
        // Hiển thị thông tin lấy được
      String date = "Hôm nay là " + dayOfWeek + ", ngày " + dayOfMonth + " tháng " + month + " năm " + year;
         
      lblWelcome.setText(date);
         lblWelcome.setBounds(350,180,400,30);
//         lblWelcome.setBorder(BorderFactory.createLineBorder(Color.black));
         lblWelcome.setBackground(Color.white);
        lblWelcome.setForeground(Color.black);
        lblWelcome.setFont(font);
         lblWelcome.setOpaque(true);
         
         JLabel lblImg = new JLabel();
            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            ImageIcon icon = null;
            if (currentHour >= 6 && currentHour < 18) {
                icon = new ImageIcon(getClass().getResource("/Icon/icon_img/day.gif"));
                Image img = icon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_DEFAULT);
                icon = new ImageIcon(img);
            } else {
                icon = new ImageIcon(getClass().getResource("/Icon/icon_img/moon.gif"));
                Image img = icon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_DEFAULT);
                icon = new ImageIcon(img);
            }
            lblImg.setIcon(icon);
            lblImg.setBounds(50,50, 300,300);
            
            pnHello.add(lblInfoUser);
            pnHello.add(lblImg);
            pnHello.add(lblWelcome);
        return  pnHello;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {
        }
     
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException e) {

        }

        new LayoutFrame();
    }
}
