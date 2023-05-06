/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Front_End.HandleEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author NGOC THUC
 */
public class tryCatch {

    public tryCatch() {

    }

    public boolean dateIsValid(String inputDate) throws ParseException {
        try {
            // chuyển đổi chuỗi thành đối tượng LocalDate
            LocalDate.parse(inputDate);
            return true;
        } catch (DateTimeParseException e) {
            // xử lý ngoại lệ khi chuỗi không phải là một ngày hợp lệ
            JOptionPane.showMessageDialog(null, "Ngày không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            // Xử lý ngoại lệ khi không phải số
            return false;
        }
        return true;
    }

    public boolean isTextFieldEmpty(JTextField textField) {
        String text = textField.getText().trim();
        if(text.equals("")) {
             JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        return true;
    }

}
