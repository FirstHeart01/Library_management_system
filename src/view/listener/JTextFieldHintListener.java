package view.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 输入框默认提示字符
 * @author ZQ
 */
public class JTextFieldHintListener implements FocusListener {
    private final String hintText;
    private final JTextField textField;
    
    public JTextFieldHintListener(JTextField jTextField, String hintText) {
        this.textField = jTextField;
        this.hintText= hintText;
        jTextField.setText(hintText);
        jTextField.setForeground(Color.GRAY);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        //获取焦点时清空内容
        String temp = textField.getText();
        if(temp.equals(hintText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        //失去焦点时，没有输入内容显示提示内容
        String temp = textField.getText();
        if(temp.equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }
    }
}