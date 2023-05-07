/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Import_Export;

import Back_End.KHUYENMAI.KHUYENMAI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NGOC THUC
 */
public class IOExcel {
    public static ArrayList<ArrayList<Object>> readExcel(int sheetIndex) throws IOException, InvalidFormatException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File savefile = jFileChooser.getSelectedFile();
        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        File file = new File(savefile.getPath());
        if (!file.exists()) {
            throw new IOException("File not found: " + savefile.getPath());
        }
        try (FileInputStream fileInputStream = new FileInputStream(file); Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                ArrayList<Object> rowData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING ->
                            rowData.add(cell.getStringCellValue());
                        case Cell.CELL_TYPE_NUMERIC ->
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                        case Cell.CELL_TYPE_BOOLEAN ->
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                        default ->
                            rowData.add("");
                    }
                }
                data.add(rowData);
            }
        }
        return data;
    }

    public static void writeExcel(JTable table, String header, String sheetName) {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(table.getParent());
            File savefile = jFileChooser.getSelectedFile();
            if (savefile != null) {
                savefile = new File(savefile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet(sheetName);
                //tạo hàng đầu tiên để đặt tiêu đề cho bảng
                Row rowCol = sheet.createRow(0);

                // Set title
                CellStyle titleStyle = wb.createCellStyle();
                titleStyle.setAlignment(HorizontalAlignment.CENTER);
                XSSFFont font = wb.createFont();
                font.setBold(true);
                font.setFontHeightInPoints((short) 16);
                titleStyle.setFont(font);
                Cell titleCell = rowCol.createCell(0);
                titleCell.setCellValue(header);
                titleCell.setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, table.getColumnCount() - 1));

                // Set header
                CellStyle headerStyle = wb.createCellStyle();
                headerStyle.setAlignment(HorizontalAlignment.CENTER);
                Row rowHeader = sheet.createRow(1);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = rowHeader.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                    cell.setCellStyle(headerStyle);
                }

                // Set data
                CellStyle dataStyle = wb.createCellStyle();
                dataStyle.setAlignment(HorizontalAlignment.CENTER);
                for (int j = 0; j < table.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 2);
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table.getValueAt(j, k) != null) {
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }
                        cell.setCellStyle(dataStyle);
                    }
                }

                // Set column widths for data rows
                for (int i = 0; i < table.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }
                try (FileOutputStream out = new FileOutputStream(new File(savefile.toString()))) {
                    wb.write(out);
                }
                JOptionPane.showMessageDialog(null, "Xuất File Excel thành công");

            } else {
                JOptionPane.showMessageDialog(null, "Xuất File Excel thất bại");
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
//            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException ignored) {
        }

       
//        ArrayList<ArrayList<Object>> data = IOExcel.readExcel(0);
//        for (ArrayList<Object> sv : data) {
//            for (Object cot : sv) {
//                System.out.print(cot.toString() + " ");
//            }
//            System.out.println();
//        }
    }
}
