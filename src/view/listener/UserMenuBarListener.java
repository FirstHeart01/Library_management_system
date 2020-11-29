package view.listener;

import view.frame.BorrowBookFrame;
import view.frame.ReturnBookFrame;
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
            BorrowBookFrame.instance.setVisible(true);
            BorrowBookFrame.instance.updateData();
            return;
        }
        //图书归还
        if(i == f.returnItem) {
            ReturnBookFrame.instance.setVisible(true);
            ReturnBookFrame.instance.updateData();
            return;
        }
        //修改密码
        //此界面功能还未实现
        if(i == f.editPassItem) {
            JOptionPane.showMessageDialog(f,"修改密码");
        }
        //系统介绍
        //此界面功能还未实现
        if(i == f.sysDescItem) {
            JOptionPane.showMessageDialog(f, "系统介绍");
        }
    }
}
