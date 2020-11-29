package view.frame;

import service.BookTypeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ZQ
 */
public class AddTypeFrame extends JFrame {
    
    public static AddTypeFrame instance = new AddTypeFrame();
    
    BookTypeService service = new BookTypeService();
    
    JTextField typeNameField;
    JTextArea typeDescField;
    
    public AddTypeFrame() {
        setTitle("图书类型添加");
        setSize(600,500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/leibie-icon.png")));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        setContentPane(contentPanel);
        contentPanel.setBorder(new EmptyBorder(0,30,10,30));
        
        JPanel titlePanel = new JPanel();
        contentPanel.add(titlePanel);
        
        JLabel labelAddType = new JLabel("图书类别添加");
        labelAddType.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bookTypeAdd-icon.png")));
        labelAddType.setFont(new Font("微软雅黑",Font.BOLD,27));
        titlePanel.add(labelAddType);
        
        JPanel nameFieldPanel = new JPanel();
        nameFieldPanel.setLayout(new GridLayout(1,2));
        contentPanel.add(nameFieldPanel);
        
        JLabel labelTypeName = new JLabel("图书类别名称：");
        labelTypeName.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bookTypeAddmenu-icon.png")));
        labelTypeName.setFont(new Font("微软雅黑",Font.BOLD,20));
        nameFieldPanel.add(labelTypeName);
        
        typeNameField = new JTextField();
        typeNameField.setPreferredSize(new Dimension(200,30));
        typeNameField.setFont(new Font("微软雅黑",Font.BOLD,20));
        nameFieldPanel.add(typeNameField);
        
        JPanel descFieldPanel = new JPanel();
        descFieldPanel.setLayout(new GridLayout(1,2));
        contentPanel.add(descFieldPanel);
        
        JLabel labelTypeDesc = new JLabel("图书类别描述：");
        labelTypeDesc.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bookTypeDesc-icon.png")));
        labelTypeDesc.setFont(new Font("微软雅黑",Font.BOLD,20));
        descFieldPanel.add(labelTypeDesc);
        
        typeDescField = new JTextArea();
        
        typeDescField.setLineWrap(true);
        typeDescField.setWrapStyleWord(true);
        
        typeDescField.setPreferredSize(new Dimension(200,150));
        typeDescField.setFont(new Font("微软雅黑",Font.BOLD,20));
        descFieldPanel.add(typeDescField);
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,80,0));
        contentPanel.add(buttonPanel);
        
        JButton add = new JButton("添加");
        add.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/add-icon.png")));
        buttonPanel.add(add);
        
        JButton reset = new JButton("重置");
        reset.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/refresh-icon.png")));
        buttonPanel.add(reset);
        
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(0 == typeNameField.getText().length() || 0 == typeDescField.getText().length()) {
                    JOptionPane.showMessageDialog(AddTypeFrame.this,"图书类型名称和描述不能为空");
                    return;
                }
                if(service.add(typeNameField.getText(),typeDescField.getText())) {
                    JOptionPane.showMessageDialog(AddTypeFrame.this,"添加成功！");
                } else {
                    JOptionPane.showMessageDialog(AddTypeFrame.this,"添加失败！");
                }
            }
        });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeDescField.setText("");
                typeNameField.setText("");
            }
        });
        
        setVisible(true);
    }
    
    public void resetInput() {
        typeDescField.setText("");  
        typeNameField.setText("");
    }

    public static void main(String[] args) {
        
    }
}





























