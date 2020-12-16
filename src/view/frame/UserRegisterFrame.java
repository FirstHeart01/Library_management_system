package view.frame;

import dao.UserDao;
import entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 用户注册界面
 * 此功能还未实现
 * @author ZQ
 */
public class UserRegisterFrame extends JFrame {
    
    public static UserRegisterFrame instance = new UserRegisterFrame();

    public UserRegisterFrame() {
        setTitle("用户注册");
        setSize(700,600);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/register-icon.png")));

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
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200,30));
        usernameField.setFont(new Font("微软雅黑",Font.BOLD,20));
        fieldPanel.add(usernameField);

        //创建密码标签
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/password.png")));
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
        fieldPanel.add(passwordLabel);
        //创建密码输入框
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,30));
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        fieldPanel.add(passwordField);

        //按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        contentPanel.add(buttonPanel);
        
        //创建注册按钮
        JButton register = new JButton("注册");
        register.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/register-icon.png")));
        buttonPanel.add(register);
        
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(0 == usernameField.getText().length() || 0 == passwordField.getPassword().length) {
                    JOptionPane.showMessageDialog(UserRegisterFrame.this,"用户名与密码不能为空");
                    return;
                }
                User user = new User();
                user.setUserName(usernameField.getText());
                user.setPassword(new String(passwordField.getPassword()));
                user.setAdmin(0);

                if(UserDao.add(user)) {
                    JOptionPane.showMessageDialog(UserRegisterFrame.this,"添加成功！");
                } else {
                    JOptionPane.showMessageDialog(UserRegisterFrame.this,"添加失败！");
                }
                setVisible(false);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        
    }
}
