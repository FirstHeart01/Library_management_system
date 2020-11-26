package view.listener;

import view.frame.UserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuBarListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        UserFrame f = UserFrame.instance;
        JMenuItem i = (JMenuItem)e.getSource();
        
        //图书借阅
        if(i == f.borrowItem) {
            
        }
        //图书归还
        if(i == f.returnItem) {
            
        }
        //修改密码
        if(i == f.editPassItem) {
            JOptionPane.showMessageDialog(f,"修改密码");
        }
    }
}
