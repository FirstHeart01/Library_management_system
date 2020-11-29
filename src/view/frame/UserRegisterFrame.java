package view.frame;

import javax.swing.*;

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
        
        
        setVisible(true);
    }

    public static void main(String[] args) {
        
    }
}
