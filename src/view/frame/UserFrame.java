package view.frame;

import util.CenterPanel;
import view.listener.UserMenuBarListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 普通用户界面
 * @author ZQ
 */
public class UserFrame extends JFrame {
    
    //单例模式
    public static UserFrame instance = new UserFrame();
    
    public JMenuBar menuBar = new JMenuBar();
    
    //图书借阅菜单
    public JMenu borrowMenu = new JMenu("图书借阅");
    public JMenuItem borrowItem = new JMenuItem("图书借阅");
    
    //图书归还菜单
    public JMenu returnMenu = new JMenu("图书归还");
    public JMenuItem returnItem = new JMenuItem("图书归还");
    
    //个人设置菜单
    public JMenu personalMenu = new JMenu("个人设置");
    public JMenuItem editPassItem = new JMenuItem("密码修改");
    
    //关于菜单
    public JMenu aboutMenu = new JMenu("关于");
    public JMenuItem sysDescItem = new JMenuItem("系统介绍");
    
    //退出系统菜单
    public JMenuItem exitMenu = new JMenuItem("退出系统");
    
    //工作面板
    public CenterPanel workingPanel;
    
    public UserFrame() {
        System.out.println("窗体开始建立");
        //设置窗体信息
        System.out.println("窗体信息建立");
        setTitle("用户界面   当前用户编号：" + LoginFrame.user.getId());
        setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置工作面板
        System.out.println("工作面板建立");
        workingPanel = new CenterPanel(0.85,false);
        setContentPane(workingPanel);
        workingPanel.setSize(this.getWidth(),this.getHeight() - 50);
        
        //设置图标
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/book.png")));
        //设置菜单栏
        setJMenuBar(menuBar);
        
        //添加菜单项
        borrowMenu.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/book-BM.png")));
        menuBar.add(borrowMenu);
        returnMenu.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/归还.png")));
        menuBar.add(returnMenu);
        personalMenu.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/user-icon.png")));
        menuBar.add(personalMenu);
        aboutMenu.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/Cancellation-icon.png")));    
        menuBar.add(aboutMenu);
        exitMenu.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/Safe exit-icon.png")));
        menuBar.add(exitMenu);
        
        //添加子菜单
        //图书借阅
        borrowItem.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/book-BM.png")));
        borrowMenu.add(borrowItem);
        
        //图书归还
        returnItem.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/归还.png")));
        returnMenu.add(returnItem);
        
        //个人设置
        editPassItem.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/密码.png")));
        personalMenu.add(editPassItem);
        
        //关于
        sysDescItem.setIcon(new ImageIcon(AdminFrame.class.getResource("/images/Graduation Project-icon.png")));
        aboutMenu.add(sysDescItem);
        
        //退出系统
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(UserFrame.this,"是否退出系统");
                if(choice == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    
        //添加监听器
        addListener();
        
        //设置窗体信息
        setVisible(true);
    }

    /**
     * 添加监听器
     */
    public void addListener() {
        UserMenuBarListener listener = new UserMenuBarListener();
        
        borrowItem.addActionListener(listener);
        returnItem.addActionListener(listener);
        editPassItem.addActionListener(listener);
        sysDescItem.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        
    }
}




















































