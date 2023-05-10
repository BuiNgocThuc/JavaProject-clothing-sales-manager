/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Import_Export;

import Back_End.CTHoaDon.CTHoaDon;
import Back_End.CTHoaDon.CTHoaDonDAO;
import Back_End.CTPhieuNhap.CTPhieuNhap;
import Back_End.CTPhieuNhap.CTPhieuNhapDAO;
import Back_End.HOADON.HOADON;
import Back_End.HOADON.HOADONDAO;
import Back_End.KHACHHANG.KHACHHANG;
import Back_End.KHACHHANG.KHACHHANGDAO;
import Back_End.NHACUNGCAP.NHACUNGCAP;
import Back_End.NHACUNGCAP.NHACUNGCAPDAO;
import Back_End.NHANVIEN.NHANVIEN;
import Back_End.NHANVIEN.NHANVIENDAO;
import Back_End.PHIEUNHAP.PHIEUNHAP;
import Back_End.PHIEUNHAP.PHIEUNHAPDAO;
import Back_End.SANPHAM.SANPHAM;
import Back_End.THUONGHIEU.THUONGHIEU;
import Back_End.THUONGHIEU.THUONGHIEUDAO;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.xmlbeans.impl.soap.Detail;

/**
 *
 * @author NGOC THUC
 */
public class writePDF {

    public static PdfPCell createCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorderWidth(0);
        cell.setPaddingTop(7f);
        cell.setPaddingBottom(7f);
        return cell;
    }

    public static void writePN(String maPN) {
        THUONGHIEUDAO brdDAO = new THUONGHIEUDAO();
        CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
        PHIEUNHAPDAO pnDAO = new PHIEUNHAPDAO();
        PHIEUNHAP  pnNew = new PHIEUNHAP(maPN);
        PHIEUNHAP selectedPN = pnDAO.selectById(pnNew);
        
        BaseFont vietnameseFont = null;
        float topMargin = 10f;
        float bottomMargin = 10f;
        try {
            vietnameseFont = BaseFont.createFont("E:\\nam II - HKII\\java\\DO_AN_BAN_QUAN_AO\\JavaProject-clothing-sales-manager\\manage-clothing-store\\src\\Icon\\icon_img\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return;
        }
        Font vn = new Font(vietnameseFont, 16);
        Font top_vn = new Font(vietnameseFont, 20);
        Font title_vn = new Font(vietnameseFont, 10, Font.ITALIC);

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(null);
        File savefile = jFileChooser.getSelectedFile();
        if (savefile != null) {
            savefile = new File(savefile.toString() + ".pdf");
        } else {
            return;
        }
//        System.out.println(savefile.getPath());
//        String fileName = "res/" + "abc" + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(savefile.getPath()));
            document.open();

            PdfPTable tbl1col = new PdfPTable(1);
            tbl1col.setWidthPercentage(100);
            tbl1col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl1col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tbl1col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tbl1col.getDefaultCell().setBorderWidth(0);

            PdfPTable tbl2col = new PdfPTable(1);
            tbl2col.setWidthPercentage(100);
            tbl2col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl2col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tbl2col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tbl2col.getDefaultCell().setBorderWidth(0);

            PdfPCell heading = new PdfPCell(new Phrase("THÔNG TIN PHIẾU NHẬP", top_vn));
            heading.setBorderWidth(0);
            heading.setPaddingTop(topMargin);
            heading.setPaddingBottom(bottomMargin * 2);
            heading.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tbl1col.addCell(heading);
            document.add(tbl1col);

            PdfPCell cell = new PdfPCell(new Phrase("Mã Phiếu Nhập: " + maPN, vn));
            cell.setBorderWidth(0);
            cell.setPaddingTop(topMargin);
            cell.setPaddingBottom(bottomMargin);
            tbl2col.addCell(cell);
            String maNCC = selectedPN.getMaNCC();
            NHACUNGCAP  ncc = new NHACUNGCAP(maNCC);
            NHACUNGCAPDAO nccDAO = new NHACUNGCAPDAO();
            NHACUNGCAP selectedNCC = nccDAO.selectById(ncc);
            String nameNCC = selectedNCC.getTenNCC();
            cell.setPhrase(new Phrase("Nhà Cung Cấp: " + nameNCC, vn));
            tbl2col.addCell(cell);
            String maNV = selectedPN.getMaNV();
            NHANVIEN nv = new NHANVIEN(maNV);
            NHANVIENDAO nvDAO = new NHANVIENDAO();
            NHANVIEN selectedNV = nvDAO.selectById(nv);
            String nameNV = selectedNV.getTenNV();
            cell.setPhrase(new Phrase("Nhân Viên Nhập: " + nameNV, vn));
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("ngày lập: " + selectedPN.getNgayNhap(), vn));
            tbl2col.addCell(cell);
            document.add(tbl2col);

            PdfPTable tbl5col = new PdfPTable(7);
            tbl5col.setWidthPercentage(80);
            tbl5col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl5col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tbl5col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            cell.setBorderWidth(1);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

            cell.setPhrase(new Phrase("Sản Phẩm", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Thương Hiệu", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Size", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Màu Sắc", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Giá Nhập", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Số lượng", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Tổng Tiền", title_vn));
            tbl5col.addCell(cell);
//            document.add(tbl5col);

            ArrayList<SANPHAM> dsctpn = ctpnDAO.getProducts(maPN);

            int thanhToan = 0;
            for (SANPHAM ctpn : dsctpn) {
                cell.setPhrase(new Phrase(ctpn.getTenSP(), title_vn));
                tbl5col.addCell(cell); // ô 1
                THUONGHIEU brd = new THUONGHIEU(ctpn.getMaTH());
                THUONGHIEU brand = brdDAO.selectById(brd);
                String nameBrand = brand.getTenTH();
                cell.setPhrase(new Phrase(nameBrand, title_vn));
                tbl5col.addCell(cell); // ô 2
                cell.setPhrase(new Phrase(ctpn.getKichCo(), title_vn));
                tbl5col.addCell(cell); // ô 3
                cell.setPhrase(new Phrase(ctpn.getMauSac(), title_vn));
                tbl5col.addCell(cell); // ô 4
                String condition = "CTPN_MAPN = '" + maPN + "' AND CTPN_MASP = '" + ctpn.getMaSP() + "'; ";
                ArrayList<CTPhieuNhap> ticket = ctpnDAO.selectByCondition(condition);
                for (CTPhieuNhap chiTiet : ticket) {
                    String donGia = chiTiet.getDonGia() + "";
                    cell.setPhrase(new Phrase(donGia, title_vn));
                    tbl5col.addCell(cell); // ô 5
                    String soLuong = chiTiet.getSoLuong() + "";
                    cell.setPhrase(new Phrase(soLuong, title_vn));
                    tbl5col.addCell(cell); // ô 6
                    float tongTien = chiTiet.getDonGia() * chiTiet.getSoLuong();
                    thanhToan += tongTien;
                    String sum = tongTien + "";
                    cell.setPhrase(new Phrase(sum, title_vn));
                    tbl5col.addCell(cell); // ô 7
                }
            }
            document.add(tbl5col);

            PdfPTable tbl1col2 = new PdfPTable(1);

            cell.setPhrase(new Phrase("Tổng Thanh Toán: " + thanhToan, vn));
            tbl1col2.setWidthPercentage(100);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            cell.setBorderWidth(0);
            tbl1col2.addCell(cell);

            document.add(tbl1col2);
            JOptionPane.showMessageDialog(null, "Tạo file phiếu nhập thành công!!");
            document.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found error: " + e.getMessage());
        } catch (DocumentException e) {
            System.err.println("Document error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    public static void writeHD(String maHD) {
        THUONGHIEUDAO brdDAO = new THUONGHIEUDAO();
        CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
        HOADONDAO hdDAO = new HOADONDAO();
        HOADON hdnew = new HOADON(maHD);
        HOADON selectedHD = hdDAO.selectById(hdnew);
        
        BaseFont vietnameseFont = null;
        float topMargin = 10f;
        float bottomMargin = 10f;
        try {
            vietnameseFont = BaseFont.createFont("E:\\nam II - HKII\\java\\DO_AN_BAN_QUAN_AO\\JavaProject-clothing-sales-manager\\manage-clothing-store\\src\\Icon\\icon_img\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return;
        }
        Font vn = new Font(vietnameseFont, 16);
        Font top_vn = new Font(vietnameseFont, 20);
        Font title_vn = new Font(vietnameseFont, 10, Font.ITALIC);

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(null);
        File savefile = jFileChooser.getSelectedFile();
        if (savefile != null) {
            savefile = new File(savefile.toString() + ".pdf");
        } else {
            return;
        }
//        System.out.println(savefile.getPath());
//        String fileName = "res/" + "abc" + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(savefile.getPath()));
            document.open();

            PdfPTable tbl1col = new PdfPTable(1);
            tbl1col.setWidthPercentage(100);
            tbl1col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl1col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tbl1col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tbl1col.getDefaultCell().setBorderWidth(0);

            PdfPTable tbl2col = new PdfPTable(1);
            tbl2col.setWidthPercentage(100);
            tbl2col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl2col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tbl2col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tbl2col.getDefaultCell().setBorderWidth(0);

            PdfPCell heading = new PdfPCell(new Phrase("THÔNG TIN HÓA ĐƠN", top_vn));
            heading.setBorderWidth(0);
            heading.setPaddingTop(topMargin);
            heading.setPaddingBottom(bottomMargin * 2);
            heading.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tbl1col.addCell(heading);
            document.add(tbl1col);

            PdfPCell cell = new PdfPCell(new Phrase("Mã Hóa Đơn: " + maHD, vn));
            cell.setBorderWidth(0);
            cell.setPaddingTop(topMargin);
            cell.setPaddingBottom(bottomMargin);
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("", top_vn));
            tbl2col.addCell(cell);
           String maKH = selectedHD.getMaKH();
           KHACHHANG kH = new KHACHHANG(maKH);
            KHACHHANGDAO khDAO = new KHACHHANGDAO();
            KHACHHANG selectedKH = khDAO.selectById(kH);
            String nameKH = selectedKH.getTenKH();
            cell.setPhrase(new Phrase("Khách Hàng: " + nameKH, vn));
            tbl2col.addCell(cell);
            
            String maNV = selectedHD.getMaNV();
            NHANVIEN nv = new NHANVIEN(maNV);
            NHANVIENDAO nvDAO = new NHANVIENDAO();
            NHANVIEN selectedNV = nvDAO.selectById(nv);
            String nameNV = selectedNV.getTenNV();
            cell.setPhrase(new Phrase("Nhân Viên Nhập: " + nameNV, vn));
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("ngày lập: " + selectedHD.getNgayNhap(), vn));
//            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("Mã khuyến mại: " + selectedHD.getMaKM(), vn));
            tbl2col.addCell(cell);
            document.add(tbl2col);

            PdfPTable tbl5col = new PdfPTable(7);
            tbl5col.setWidthPercentage(80);
            tbl5col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl5col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tbl5col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            cell.setBorderWidth(1);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

            cell.setPhrase(new Phrase("Sản Phẩm", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Thương Hiệu", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Size", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Màu Sắc", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Giá Nhập", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Số lượng", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Tổng Tiền", title_vn));
            tbl5col.addCell(cell);
//            document.add(tbl5col);

            ArrayList<SANPHAM> dsctpn = cthdDAO.getProducts(maHD);

            int thanhToan = 0;
            for (SANPHAM ctpn : dsctpn) {
                cell.setPhrase(new Phrase(ctpn.getTenSP(), title_vn));
                tbl5col.addCell(cell); // ô 1
                THUONGHIEU brd = new THUONGHIEU(ctpn.getMaTH());
                THUONGHIEU brand = brdDAO.selectById(brd);
                String nameBrand = brand.getTenTH();
                cell.setPhrase(new Phrase(nameBrand, title_vn));
                tbl5col.addCell(cell); // ô 2
                cell.setPhrase(new Phrase(ctpn.getKichCo(), title_vn));
                tbl5col.addCell(cell); // ô 3
                cell.setPhrase(new Phrase(ctpn.getMauSac(), title_vn));
                tbl5col.addCell(cell); // ô 4
                String condition = "CTHD_MAHD = '" + maHD + "' AND CTHD_MASP = '" + ctpn.getMaSP() + "'; ";
                ArrayList<CTHoaDon> ticket = cthdDAO.selectByCondition(condition);
                for (CTHoaDon chiTiet : ticket) {
                    String donGia = chiTiet.getDonGia() + "";
                    cell.setPhrase(new Phrase(donGia, title_vn));
                    tbl5col.addCell(cell); // ô 5
                    String soLuong = chiTiet.getSoLuong() + "";
                    cell.setPhrase(new Phrase(soLuong, title_vn));
                    tbl5col.addCell(cell); // ô 6
                    float tongTien = chiTiet.getDonGia() * chiTiet.getSoLuong();
                    thanhToan += tongTien;
                    String sum = tongTien + "";
                    cell.setPhrase(new Phrase(sum, title_vn));
                    tbl5col.addCell(cell); // ô 7
                }
            }
            document.add(tbl5col);

            PdfPTable tbl1col2 = new PdfPTable(1);

            cell.setPhrase(new Phrase("Tổng Thanh Toán: " + selectedHD.getTongTien(), vn));
            tbl1col2.setWidthPercentage(100);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            cell.setBorderWidth(0);
            tbl1col2.addCell(cell);

            document.add(tbl1col2);
            JOptionPane.showMessageDialog(null, "Tạo file phiếu nhập thành công!!");
            document.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found error: " + e.getMessage());
        } catch (DocumentException e) {
            System.err.println("Document error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {
        }
       // writePDF.writePN("PN001");
        writePDF.writeHD("HD001");
    }
}
