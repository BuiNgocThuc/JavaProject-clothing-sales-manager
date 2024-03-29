package Front_End.SANPHAM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSOutput;

import Back_End.KICHCO.KICHCOBUS;
import Back_End.MAUSAC.MAUSACBUS;
import Back_End.SANPHAM.SANPHAMBUS;
import Front_End.FrameLayout.LayoutFrame;

public class SANPHAMGUI extends JPanel {

    public JLabel tenSP, tenTH, size, mauSac;
    public static JComboBox<String> boxTenSP, boxTenTH, boxSize, boxMauSac;
    public JButton btnDelete, btnSave, btnUpdate, btnAdd, btnHuy, btnResert;
    public JButton btnApply, btnCancel, btnSP, btnLoc, btnTTSP;
    public JPanel panelMaSP, panelMaTH, panelTenSP, panelSize, panelSoLuong, panelMau, panelDonGia;
    public static JPanel pannelBoLocSP;
    public static JTable tableSP;
    public static DefaultTableModel defaultTableModel;
    public JScrollPane scrollPane;
    public JLabel labelTenSP, labelMaTH, labelMaSP, labelSize, labelColor, labelGia, labelSoLuong;
    public JTextField txtTenSP, txtDonGia;
    public JPanel panelChucNang, panelBottom, panelTop;
    private String tmpTenSP, tmpDonGia, tmpSize, tmpMau;
    SANPHAMBUS a = new SANPHAMBUS();
    KICHCOBUS kcb = new KICHCOBUS();
    MAUSACBUS msb = new MAUSACBUS();

    // form thuộc tính sản phẩm
    JLabel tenThuocTinh = new JLabel("Tên thuộc tính", JLabel.CENTER);
    JPanel inforTT = new JPanel();
    JTextField txtTenTT = new JTextField(10);
    JButton btnThemTT = new JButton("Thêm");
    JRadioButton rSize = new JRadioButton("Kích cỡ");
    JRadioButton rColor = new JRadioButton("Màu sắc");
    ButtonGroup bg = new ButtonGroup();
    private JPanel thuocTinhSP = new JPanel();
    private JLabel panelImg;
    private JComboBox<String> boxSize1;
    private JComboBox<String> cbMau;

    public SANPHAMGUI() {
        init();
        a.loadDataToCombobox();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        // Panel top
        panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());

        // -- Panel menu
        JPanel menu = new JPanel();
        menu.setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
        btnSP = new JButton("Sản phẩm");
        btnSP.setPreferredSize(new Dimension(120, 23));
        btnSP.setBackground(Color.lightGray);
        btnSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thuocTinhSP.isDisplayable()) {
                    btnTTSP.setBackground(Color.white);
                    btnSP.setBackground(Color.lightGray);
                    thuocTinhSP.setVisible(false);
                    panelTop.setVisible(true);
                    panelBottom.setVisible(true);
                    panelChucNang.setVisible(true);
                }

            }
        });

        btnLoc = new JButton("Lọc sản phẩm");
        btnLoc.setPreferredSize(new Dimension(120, 23));
        btnLoc.setBackground(Color.white);
        btnLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLoc.setBackground(Color.lightGray);
                pannelBoLocSP.setVisible(true);
                panelImg.setIcon(null);
                if (thuocTinhSP.isDisplayable()) {
                    btnTTSP.setBackground(Color.white);
                    btnSP.setBackground(Color.lightGray);
                    thuocTinhSP.setVisible(false);
                    panelBottom.setVisible(true);
                    panelChucNang.setVisible(true);
                }
            }
        });

        btnTTSP = new JButton("Thuộc tính sản phẩm");
        btnTTSP.setPreferredSize(new Dimension(120, 23));
        btnTTSP.setBackground(Color.white);
        btnTTSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBottom.setVisible(false);
                panelChucNang.setVisible(false);
                addFormTTSP();
                thuocTinhSP.setVisible(true);
                btnTTSP.setBackground(Color.lightGray);
                btnSP.setBackground(Color.white);
                panelImg.setIcon(null);
                if (pannelBoLocSP.isDisplayable()) {
                    pannelBoLocSP.setVisible(false);
                    btnLoc.setBackground(Color.white);
                }
            }
        });

        menu.add(btnSP);
        menu.add(btnTTSP);
        menu.add(btnLoc);

        menu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        panelTop.add(menu, BorderLayout.CENTER);

        // Bộ lọc sản phẩm
        pannelBoLocSP = new JPanel();
        pannelBoLocSP.setBounds(0, 0, this.getWidth(), 50);
        pannelBoLocSP.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        tenSP = new JLabel("Tên sản phẩm", JLabel.CENTER);
        tenTH = new JLabel("Thương hiệu", JLabel.CENTER);
        size = new JLabel("Size", JLabel.CENTER);
        mauSac = new JLabel("Màu sắc", JLabel.CENTER);

        boxTenSP = new JComboBox<String>();

        boxTenTH = new JComboBox<String>();

        boxSize = new JComboBox<String>();

        boxMauSac = new JComboBox<String>();

        btnApply = new JButton("Áp dụng");
        btnApply.setPreferredSize(new Dimension(100, 25));
        btnApply.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-done-32.png")));
        btnApply.setBorder(new LineBorder(Color.black));
        btnApply.setBackground(Color.white);

        btnCancel = new JButton("Hủy");
        btnCancel.setPreferredSize(new Dimension(100, 25));
        btnCancel.setBorder(new LineBorder(Color.black));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
        btnCancel.setBackground(Color.white);

        // Xử lý sự kiện lọc sản phẩm
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnApply) {
                    SANPHAMBUS a = new SANPHAMBUS();
                    a.boLocSanPham();
                    if (panelImg.isDisplayable()) {
                        panelImg.setIcon(null);
                    }
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnCancel) {
                    a.loadDataToTable_UseArray(tableSP);
                    btnLoc.setBackground(Color.white);
                    pannelBoLocSP.setVisible(false);
                    if (panelImg.isDisplayable()) {
                        panelImg.setIcon(null);
                    }
                }
            }
        });
        pannelBoLocSP.add(tenSP);
        pannelBoLocSP.add(boxTenSP);
        pannelBoLocSP.add(tenTH);
        pannelBoLocSP.add(boxTenTH);
        pannelBoLocSP.add(size);
        pannelBoLocSP.add(boxSize);
        pannelBoLocSP.add(mauSac);
        pannelBoLocSP.add(boxMauSac);
        pannelBoLocSP.add(btnApply);
        pannelBoLocSP.add(btnCancel);

        pannelBoLocSP.setVisible(false);
        this.add(panelTop, BorderLayout.NORTH);

        // Panel table, sửa sản phẩm , hiển thị hình ảnh
        panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        panelBottom.setBorder(new LineBorder(Color.black));
        panelBottom.add(pannelBoLocSP, BorderLayout.NORTH);
        // -- table
        tableSP = new JTable();
        panelBottom.add(createTable(tableSP), BorderLayout.CENTER);
        a.loadDataToTable(tableSP); // đổ dữ liệu lên table

        // --Img
        JPanel imgPanel = new JPanel();
        imgPanel.setLayout(new BorderLayout());
        JPanel panelBottom1 = new JPanel();
        panelBottom1.setLayout(new BorderLayout());
        panelBottom1.setPreferredSize(new Dimension(this.getWidth(), 200));
        panelImg = new JLabel();
        panelImg.setPreferredSize(new Dimension(200, 200));
        imgPanel.add(panelImg, BorderLayout.CENTER);
        panelBottom1.add(imgPanel, BorderLayout.WEST);

        // --Sửa sản phẩm
        JPanel panelUpdate = new JPanel();
        panelUpdate.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelUpdate.setVisible(false);

        panelMaSP = new JPanel();
        panelMaSP.setPreferredSize(new Dimension(79, 46));
        panelMaSP.setBorder(new TitledBorder(new LineBorder(Color.black), "Mã SP", TitledBorder.LEADING, TitledBorder.TOP));
        labelMaSP = new JLabel("", JLabel.CENTER);
        panelMaSP.add(labelMaSP);
        panelUpdate.add(panelMaSP);

        panelMaTH = new JPanel();
        panelMaTH.setPreferredSize(new Dimension(79, 46));
        panelMaTH.setBorder(new TitledBorder(new LineBorder(Color.black), "Mã TH", TitledBorder.LEADING, TitledBorder.TOP));
        labelMaTH = new JLabel("", JLabel.CENTER);
        panelMaTH.add(labelMaTH);
        panelUpdate.add(panelMaTH);

        panelTenSP = new JPanel();
        panelTenSP.setPreferredSize(new Dimension(102, 46));
        panelTenSP.setBorder(new TitledBorder(new LineBorder(Color.black), "Tên SP", TitledBorder.LEADING, TitledBorder.TOP));
        labelTenSP = new JLabel("", JLabel.CENTER);
        panelTenSP.add(labelTenSP);
        txtTenSP = new JTextField(8);
        txtTenSP.setVisible(false);
        panelTenSP.add(txtTenSP);
        panelTenSP.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                tmpTenSP = labelTenSP.getText();
                labelTenSP.setVisible(false);
                txtTenSP.setVisible(true);

            }
        });
        txtTenSP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (txtTenSP.getText().isEmpty() == false) {
                        labelTenSP.setText(txtTenSP.getText());
                        labelTenSP.setVisible(true);
                        txtTenSP.setVisible(false);
                    } else {
                        labelTenSP.setVisible(true);
                        labelTenSP.setText(tmpTenSP);
                        txtTenSP.setVisible(false);
                    }
                }
            }
        });
        panelUpdate.add(panelTenSP);

        panelSize = new JPanel();
        panelSize.setPreferredSize(new Dimension(46, 46));
        panelSize.setBorder(new TitledBorder(new LineBorder(Color.black), "Size", TitledBorder.LEADING, TitledBorder.TOP));
        labelSize = new JLabel("", JLabel.CENTER);
        panelSize.add(labelSize);
        boxSize1 = new JComboBox<String>();
        boxSize1.setModel(kcb.setModel());
        boxSize1.setPreferredSize(new Dimension(40, 20));
        boxSize1.setVisible(false);
        panelSize.add(boxSize1);
        panelSize.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                tmpSize = labelSize.getText();
                labelSize.setVisible(false);
                boxSize1.setVisible(true);
            }
        });
        boxSize1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (boxSize1.getSelectedItem() == " ") {
                    labelSize.setVisible(true);
                    labelSize.setText(tmpSize);
                    boxSize1.setVisible(false);
                } else {
                    labelSize.setVisible(true);
                    labelSize.setText(String.valueOf(boxSize1.getSelectedItem()));
                    boxSize1.setVisible(false);
                }

            }
        });
        panelUpdate.add(panelSize);

        panelMau = new JPanel();
        panelMau.setPreferredSize(new Dimension(79, 46));
        panelMau.setBorder(new TitledBorder(new LineBorder(Color.black), "Màu sắc", TitledBorder.LEADING, TitledBorder.TOP));
        labelColor = new JLabel("", JLabel.CENTER);
        panelMau.add(labelColor);
        cbMau = new JComboBox<String>();
        cbMau.setModel(msb.getModel());
        cbMau.setPreferredSize(new Dimension(70, 20));
        cbMau.setVisible(false);
        panelMau.add(cbMau);
        panelMau.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                tmpMau = labelColor.getText();
                labelColor.setVisible(false);
                cbMau.setVisible(true);
            }
        });
        cbMau.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbMau.getSelectedItem() == " " || cbMau.getSelectedIndex() == -1) {
                    labelColor.setVisible(true);
                    labelColor.setText(tmpMau);
                    cbMau.setVisible(false);
                } else {
                    labelColor.setVisible(true);
                    labelColor.setText(String.valueOf(cbMau.getSelectedItem()));
                    cbMau.setVisible(false);
                }
            }
        });
        panelUpdate.add(panelMau);

        panelSoLuong = new JPanel();
        panelSoLuong.setPreferredSize(new Dimension(130, 46));
        panelSoLuong.setBorder(new TitledBorder(new LineBorder(Color.black), "Số lượng", TitledBorder.LEADING, TitledBorder.TOP));
        labelSoLuong = new JLabel("", JLabel.CENTER);
        panelSoLuong.add(labelSoLuong);
        panelUpdate.add(panelSoLuong);

        panelDonGia = new JPanel();
        panelDonGia.setPreferredSize(new Dimension(130, 46));
        panelDonGia.setBorder(new TitledBorder(new LineBorder(Color.black), "Đơn giá", TitledBorder.LEADING, TitledBorder.TOP));
        labelGia = new JLabel("", JLabel.CENTER);
        panelDonGia.add(labelGia);
        txtDonGia = new JTextField(8);
        txtDonGia.setVisible(false);
        panelDonGia.add(txtDonGia);
        panelDonGia.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                tmpDonGia = labelGia.getText();
                labelGia.setVisible(false);
                txtDonGia.setVisible(true);
            }
        });
        txtDonGia.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (txtDonGia.getText().isEmpty() == false) {
                        if (txtDonGia.getText().chars().allMatch(Character::isDigit)) {
                            Float gia = Float.parseFloat(txtDonGia.getText());
                            labelGia.setText(String.valueOf(gia));
                            labelGia.setVisible(true);
                            txtDonGia.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        labelGia.setVisible(true);
                        labelGia.setText(tmpDonGia);
                        txtDonGia.setVisible(false);
                    }
                }
            }
        });

        btnSave = new JButton("LƯU");
        btnSave.setBorder(new LineBorder(Color.black));
        btnSave.setBackground(Color.white);
        btnSave.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-save-32.png")));
        btnSave.setPreferredSize(new Dimension(75, 30));

        btnHuy = new JButton("HỦY");
        btnHuy.setBorder(new LineBorder(Color.black));
        btnHuy.setBackground(Color.white);
        btnHuy.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8_cancel_30px_1.png")));
        btnHuy.setPreferredSize(new Dimension(75, 30));
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnHuy) {
                    panelUpdate.setVisible(false);
                    if (panelImg.isDisplayable()) {
                        panelImg.setIcon(null);
                    }
                }
            }
        });

        panelUpdate.add(panelDonGia);
        panelUpdate.add(btnHuy);
        panelUpdate.add(btnSave);

        panelBottom1.add(panelUpdate, BorderLayout.CENTER);
        panelBottom.add(panelBottom1, BorderLayout.SOUTH);

        this.add(panelBottom, BorderLayout.CENTER);
        // Button chức năng
        panelChucNang = new JPanel();
        panelChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        Icon iconDelete = new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-remove-28.png"));
        btnDelete = new JButton("XÓA", iconDelete);
        btnDelete.setBorder(new LineBorder(Color.black));
        btnDelete.setBackground(Color.white);

        Icon iconUpdate = new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-edit-30.png"));
        btnUpdate = new JButton("SỬA", iconUpdate);
        btnUpdate.setBorder(new LineBorder(Color.black));
        btnUpdate.setBackground(Color.white);

        Icon iconAdd = new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-28.png"));
        btnAdd = new JButton("THÊM", iconAdd);
        btnAdd.setBorder(new LineBorder(Color.black));
        btnAdd.setBackground(Color.white);

        Icon iconreset = new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-reset-32.png"));
        btnResert = new JButton("Làm mới", iconreset);
        btnResert.setBorder(new LineBorder(Color.black));
        btnResert.setBackground(Color.white);

        panelChucNang.add(btnAdd);
        btnAdd.setPreferredSize(new Dimension(100, 30));
        panelChucNang.add(btnDelete);
        btnDelete.setPreferredSize(new Dimension(100, 30));
        panelChucNang.add(btnUpdate);
        btnUpdate.setPreferredSize(new Dimension(100, 30));
        panelChucNang.add(btnResert);
        btnResert.setPreferredSize(new Dimension(100, 30));

        this.add(panelChucNang, BorderLayout.SOUTH);

        // Sự kiện thêm
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CHUCNANGTHEM a = new CHUCNANGTHEM();
                panelImg.setIcon(null);
            }
        });

        // Sự kiện xóa
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.xoaSP();
                panelImg.setIcon(null);
            }
        });

        // Sự kiện update
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnUpdate) {
                    panelUpdate.setVisible(true);
                }

            }
        });

        btnResert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.loadDataToTable_UseArray(tableSP);
            }
        });
        // Sự kiện table
        tableSP.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                panelImg.removeAll();
                int index = tableSP.getSelectedRow();
                String url = a.getImage(index);
                panelImg.setIcon(loadImage(url, panelImg.getWidth(), panelImg.getHeight()));
                if (panelUpdate.isDisplayable()) {
                    int row[] = tableSP.getSelectedRows();
                    String maSP = String.valueOf(tableSP.getValueAt(row[0], 1));
                    String maTH = String.valueOf(tableSP.getValueAt(row[0], 2));
                    String tenSP = String.valueOf(tableSP.getValueAt(row[0], 3));
                    String size = String.valueOf(tableSP.getValueAt(row[0], 4));
                    String mau = String.valueOf(tableSP.getValueAt(row[0], 5));
                    String soLuong = String.valueOf(tableSP.getValueAt(row[0], 6));
                    String donGia = String.valueOf(tableSP.getValueAt(row[0], 7));

                    labelMaSP.setText(maSP);
                    labelMaTH.setText(maTH);
                    labelTenSP.setText(tenSP);
                    labelSize.setText(size);
                    labelColor.setText(mau);
                    labelSoLuong.setText(soLuong);
                    labelGia.setText(donGia);
                }

            }
        });
        // Sự kiện lưu sản phẩm
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btnSave) {
                    a.saveSP(labelTenSP.getText(), labelSize.getText(), labelColor.getText(), labelGia.getText());
                    if (panelUpdate.isDisplayable() == true) {
                        panelUpdate.setVisible(false);
                    }
                    if (panelImg.isDisplayable()) {
                        panelImg.setVisible(false);
                    }
                }

            }
        });
    }

    public JScrollPane createTable(JTable tableSP) {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        tableSP.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên TH");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Size");
        defaultTableModel.addColumn("Màu sắc");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");

        tableSP.getColumnModel().getColumn(0).setPreferredWidth(5);
        scrollPane = new JScrollPane(tableSP);
        tableSP.setFillsViewportHeight(true);

        return scrollPane;
    }

    public Icon loadImage(String url, int width, int height) {
        System.out.println(url);
        ImageIcon img = new ImageIcon(getClass().getResource("/Icon/icon_img/" + url));
        
        int ix = img.getIconWidth();
        int iy = img.getIconHeight();
        int dx = 0, dy = 0;
        if (width / height > ix / iy) {
            dy = height;
            dx = dy * ix / iy;
        } else {
            dx = width;
            dy = dx * ix / iy;
        }
        Image imgScale = img.getImage().getScaledInstance(dx, dy, Image.SCALE_SMOOTH);
        return new ImageIcon(imgScale);
    }

    public void addFormTTSP() {
        this.add(formTTSP(), BorderLayout.CENTER);
    }

    public JPanel formTTSP() {
        thuocTinhSP.setLayout(new BorderLayout(10, 10));

        // Thuộc tính sản phẩm
        inforTT.setLayout(new FlowLayout(50, 50, FlowLayout.LEFT));
        inforTT.setBorder(BorderFactory.createTitledBorder(null, "Thuộc tính sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, new Font(null, Font.BOLD, 20), Color.black));
        inforTT.add(tenThuocTinh);

        txtTenTT.setBounds(120, 30, 150, 20);
        inforTT.add(txtTenTT);

        bg.add(rSize);
        bg.add(rColor);
        inforTT.add(rSize);
        inforTT.add(rColor);

        btnThemTT.setIcon(new ImageIcon(getClass().getResource("/Icon/icon_img/icons8-add-new-28.png")));
        btnThemTT.setBackground(Color.white);

        inforTT.add(btnThemTT);

        // Table
        JTable table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã thuộc tính");
        model.addColumn("Tên thuộc tính");
        table.setModel(model);

        rSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                kcb.setTable(table);
            }
        });
        rColor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                msb.setTable(table);
            }
        });
        btnThemTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rSize.isSelected() && txtTenTT.getText() != null) {
                    kcb.addSize(txtTenTT.getText(), table);
                    boxSize1.setModel(kcb.setModel());
                } else if (rColor.isSelected() && txtTenTT.getText() != null) {
                    msb.addMau(txtTenTT.getText(), table);
                    cbMau.setModel(msb.getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn thuộc tính", "Thông báo", JOptionPane.OK_OPTION);
                }
            }
        });
        thuocTinhSP.add(inforTT, BorderLayout.NORTH);
        thuocTinhSP.add(pane, BorderLayout.CENTER);
        thuocTinhSP.setVisible(false);

        return thuocTinhSP;
    }

}
