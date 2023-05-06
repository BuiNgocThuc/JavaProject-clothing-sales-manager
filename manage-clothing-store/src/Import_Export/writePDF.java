/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Import_Export;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

    public static void writeHD() {
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

            PdfPTable tbl2col = new PdfPTable(2);
            tbl2col.setWidthPercentage(100);
            tbl2col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl2col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tbl2col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tbl2col.getDefaultCell().setBorderWidth(0);

            PdfPCell heading = new PdfPCell(new Phrase("Thông tin hóa đơn", top_vn));
            heading.setBorderWidth(0);
            heading.setPaddingTop(topMargin);
            heading.setPaddingBottom(bottomMargin * 2);
            heading.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            tbl1col.addCell(heading);
            document.add(tbl1col);

            PdfPCell cell = new PdfPCell(new Phrase("Hóa đơn: HD1", vn));
            cell.setBorderWidth(0);
            cell.setPaddingTop(topMargin);
            cell.setPaddingBottom(bottomMargin);
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("", top_vn));
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("Khách hàng", vn));
            tbl2col.addCell(cell);
            cell.setPhrase(new Phrase("ngày lập", vn));
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tbl2col.addCell(cell);

            document.add(tbl2col);

            PdfPTable tbl5col = new PdfPTable(5);
            tbl5col.setWidthPercentage(80);
            tbl5col.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tbl5col.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tbl5col.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            cell.setBorderWidth(1);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

            cell.setPhrase(new Phrase("Mã Sản Phẩm", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Tên Sản Phẩm", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Đơn Giá", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Số Lượng", title_vn));
            tbl5col.addCell(cell);
            cell.setPhrase(new Phrase("Tổng Tiền", title_vn));
            tbl5col.addCell(cell);
            document.add(tbl5col);
            
            PdfPTable tbl1col2 = new PdfPTable(1);
            
            cell.setPhrase(new Phrase("ádhjaksd", vn));
            tbl1col2.setWidthPercentage(100);
            cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tbl1col2.getDefaultCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

tbl1col2.addCell(cell);
            document.add(tbl1col2);

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
        writePDF.writeHD();
    }
}
