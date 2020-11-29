package view.listener;

import view.frame.AddBookFrame;
import view.frame.AddTypeFrame;
import view.frame.AdminFrame;
import view.frame.UserRegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        AdminFrame f = AdminFrame.instance;
        JMenuItem i = (JMenuItem)e.getSource();
        
        //图书类别添加
        if(i == f.addTypeItem) {
            AddTypeFrame.instance.setVisible(true);
            AddTypeFrame.instance.resetInput();
        }
        
        //图书类别维护
        if(i == f.editTypeItem) {
            
        }
        
        //图书添加
        if(i == f.addBookItem) {
            AddBookFrame.instance.setVisible(true);
            AddBookFrame.instance.updateData();
        }
        
        //图书维护
        if(i == f.editBookItem) {
            
        }
        
        //统计分析
        if(i == f.borrowStatisticItem) {
            JOptionPane.showMessageDialog(f,"借阅分析");
        }
        
        //用户注册
        if(i == f.registerItem) {
            UserRegisterFrame.instance.setVisible(true);
        }
        
        //用户管理
        if(i == f.userManageItem) {
            JOptionPane.showMessageDialog(f,"用户管理");
        }
        
        //系统介绍
        if(i == f.sysDescItem) {
            JOptionPane.showMessageDialog(f,"系统介绍");
        }
    }

    /**
     * 显示另一个窗体
     * @param hideFrame
     * @param showFrame
     */
    public void show(JFrame hideFrame, JFrame showFrame) {
        hideFrame.setVisible(false);
        showFrame.setVisible(true);
    }
}



























