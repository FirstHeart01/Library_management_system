package view.frame;

import entity.BookType;
import model.BookTypeComboBoxModel;
import service.BookService;
import service.BookTypeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame extends JFrame {
    public static AddBookFrame instance = new AddBookFrame();
    
    //service层
    BookService service = new BookService();
    
    JTextField bookNameField;
    JTextField authorField;
    JTextField priceField;
    BookTypeComboBoxModel bcm = new BookTypeComboBoxModel();
    JComboBox<BookType> bookTypeJComboBox;
    JTextField bookCountField;
    JTextArea bookDescField;
    
    JButton add;
    JButton reset;
    
    public AddBookFrame() {
        setTitle("图书添加");
        setSize(700,500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("/images/book-BM.png"));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        setContentPane(contentPanel);
        contentPanel.setBorder(new EmptyBorder(0,30,10,30));
        
        JPanel titlePanel = new JPanel();
        contentPanel.add(titlePanel);
        
        JLabel labelAddBook = new JLabel("图书添加");
        labelAddBook.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/ADD.png")));
        labelAddBook.setFont(new Font("微软雅黑",Font.BOLD,20));
        titlePanel.setPreferredSize(new Dimension(this.getWidth(),70)); 
        titlePanel.add(labelAddBook);
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
        mainPanel.setPreferredSize(new Dimension(getWidth(),280));
        contentPanel.add(mainPanel);
        
        JLabel labelBookId = new JLabel("图书编号：");
        labelBookId.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book-id-icon.png")));
        mainPanel.add(labelBookId);
        JTextField bookIdField = new JTextField();
        bookIdField.setPreferredSize(new Dimension(150,30));
        bookIdField.setEditable(false); 
        mainPanel.add(bookIdField);
        
        JLabel labelBookName = new JLabel("图书名称：");
        labelBookName.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book-name-icon.png")));
        mainPanel.add(labelBookName);
        
        bookNameField = new JTextField();
        bookNameField.setPreferredSize(new Dimension(150,30));
        mainPanel.add(bookNameField);
        
        JLabel labelAuthor = new JLabel("图书作者：");
        labelAuthor.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book-author-icon.png")));
        mainPanel.add(labelAuthor);
        authorField = new JTextField();
        authorField.setPreferredSize(new Dimension(150,30));
        mainPanel.add(authorField);
        
        JLabel labelPrice = new JLabel("图书价格：");
        labelPrice.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book-price-icon.png")));
        mainPanel.add(labelPrice);
       
        priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(150,30));
        mainPanel.add(priceField);
        
        JLabel labelBookType = new JLabel("图书类别：");
        labelBookType.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bookTypeAddmenu-icon.png")));
        mainPanel.add(labelBookType);
        
        bookTypeJComboBox = new JComboBox<>(bcm);
        bookTypeJComboBox.setPreferredSize(new Dimension(150,30));
        mainPanel.add(bookTypeJComboBox);
        
        JLabel labelBookCount = new JLabel("图书库存：");
        labelBookCount.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/book-borrow-time-icon.png")));
        mainPanel.add(labelBookCount);
        bookCountField = new JTextField();
        bookCountField.setPreferredSize(new Dimension(150,30));
        mainPanel.add(bookCountField);
        
        JLabel labelBookDesc = new JLabel("图书描述：");
        labelBookDesc.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bookTypeDesc-icon.png")));
        mainPanel.add(labelBookDesc);
        
        bookDescField = new JTextArea();
        bookDescField.setPreferredSize(new Dimension(450,80));  
        bookDescField.setLineWrap(true);    
        mainPanel.add(bookDescField);
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,80,0));    
        contentPanel.add(buttonPanel);
        
        add = new JButton("添加");
        add.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/add-icon.png")));
        buttonPanel.add(add);
        
        reset = new JButton("重置");
        reset.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/refresh.png")));
        buttonPanel.add(reset);
        
        
        addListener();
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetInput();
            }
        });
        setVisible(true);
    }
    
    public void addListener() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(0 == bookNameField.getText().length() || 0 == authorField.getText().length() ||
                0 == priceField.getText().length() || null == bookTypeJComboBox.getSelectedItem()||
                0 == bookCountField.getText().length() || 0 == bookDescField.getText().length()) {
                    JOptionPane.showMessageDialog(AddBookFrame.this,"选项不能为空");
                    return;
                }
                BookType bookType = (BookType)bookTypeJComboBox.getSelectedItem();
                int bookCount = Integer.parseInt(bookCountField.getText());
                
                if(service.add(bookNameField.getText(),authorField.getText(),
                        priceField.getText(),bookType,bookCount,bookDescField.getText())) {
                    JOptionPane.showMessageDialog(AddBookFrame.this,"添加成功！");
                }
            }
        
        });
    }
    
    public void resetInput() {
        bookNameField.setText("");
        authorField.setText("");
        priceField.setText("");
        bookCountField.setText("");
        bookDescField.setText("");
    }
    
    public void updateData() {
        resetInput();
        bcm.cs = new BookTypeService().list();
        bookTypeJComboBox.updateUI();
    }

    public static void main(String[] args) {
        
    }
}





















