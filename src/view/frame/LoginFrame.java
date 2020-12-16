package view.frame;

import dao.UserDao;
import entity.User;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import view.listener.JTextFieldHintListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录界面
 * @author ZQ
 */
public class LoginFrame extends JFrame {

    //单例模式
    public static LoginFrame instance = new LoginFrame();

    //当前用户
    public static User user;

    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginFrame() {
        //设置窗口基本信息
        setTitle("登录界面");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //设置窗口图标
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/Bookicon.png")));

        //初始化面板
        //组件
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
        setContentPane(contentPanel);
        contentPanel.setBorder(new EmptyBorder(20,100,10,100));
        contentPanel.setFocusable(true);

        //标题面板
        JPanel titlePanel = new JPanel();
        contentPanel.add(titlePanel,BorderLayout.NORTH);
        //内容标题
        JLabel labelBMS = new JLabel("BookManagementSystem");
        labelBMS.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book.png")));
        labelBMS.setFont(new Font("微软雅黑",Font.BOLD,27));
        titlePanel.add(labelBMS);

        //标签、输入框面板
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(2,2,0,30));
        contentPanel.add(fieldPanel,BorderLayout.CENTER);

        //创建用户名标签
        JLabel idLabel = new JLabel("用户名");
        idLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/user.png")));
        idLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
        fieldPanel.add(idLabel);
        //创建用户名输入框
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200,30));
        usernameField.setFont(new Font("微软雅黑",Font.BOLD,20)); 
        usernameField.addFocusListener(new JTextFieldHintListener(usernameField,"用户名"));
        fieldPanel.add(usernameField);
        
        //创建密码标签
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/password.png")));
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
        fieldPanel.add(passwordLabel);
        //创建密码输入框
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,30));
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordField.addFocusListener(new JTextFieldHintListener(passwordField,"密码"));
        if("密码".equals(new String(passwordField.getPassword()))) {
            passwordField.setEchoChar((char)0);
        }
        else {
            passwordField.setEchoChar('*');
        }
        fieldPanel.add(passwordField);
        
        
        //按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,80,0));
        contentPanel.add(buttonPanel);
        
        //创建登录按钮
        JButton login = new JButton("登录");
        login.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login.png")));
        buttonPanel.add(login);
        
        //创建重置按钮
        JButton reset = new JButton("重置");
        reset.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/refresh.png")));
        buttonPanel.add(reset);
        
        //点击登录按钮进入管理员界面
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(0 == usernameField.getText().length() || 0 == passwordField.getPassword().length) {
                    JOptionPane.showMessageDialog(LoginFrame.this,"用户名与密码不能为空");
                    return;
                }
                //判断登录是否成功
                if(UserDao.login(usernameField.getText(), new String(passwordField.getPassword()))) {
                    //判断是否为管理员
                    if(UserDao.isAdmin(usernameField.getText())) {
                        user = UserDao.getUser(usernameField.getText());
                        LoginFrame.instance.setVisible(false);
                        AdminFrame.instance.setVisible(true);
                    } else {
                        user = UserDao.getUser(usernameField.getText());
                        LoginFrame.instance.setVisible(false);
                        UserFrame.instance.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,"账号或密码错误，请重新输入！");
                }
            }
        });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        
        setVisible(true);   
         
    }

    public static void main(String[] args) {
        
    }
}
