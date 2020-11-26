package view.frame;

import entity.BookType;
import model.BookTableModel;
import model.BookTypeComboBoxModel;
import service.BorrowService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author ZQ
 */
public class BorrowBookFrame extends JFrame {
        
    public static BorrowBookFrame instance = new BorrowBookFrame();
    
    BorrowService service = new BorrowService();
    
    //创建表格数据源
    BookTableModel btm;
    
    //创建表格
    JTable table;
    
    //创建搜索按钮
    JButton searchButton;
    
    //创建确认借阅按钮
    JButton borrowButton;
    
    //创建comboBox
    BookTypeComboBoxModel bcm = new BookTypeComboBoxModel();
    JComboBox<BookType> bookTypeField;
    
    
    public BorrowBookFrame() {
        //设置窗体信息
        setTitle("图书借阅");
        setSize(800,400);
        setLocationRelativeTo(null);
        setResizable(false);    
        
        //设置窗口图标
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/book-BM.png")));
        
        //初始化面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        setContentPane(contentPanel);
        contentPanel.setBorder(new EmptyBorder(0,30,10,30));
        
        //标签，输入框
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
        searchPanel.setPreferredSize(new Dimension(getWidth(),70));
        contentPanel.add(searchPanel);
        
        //图书名称标签
        JLabel labelBookName = new JLabel("图书名称：");
        searchPanel.add(labelBookName);
        //图书名称输入框
        JTextField bookNameField = new JTextField();
        bookNameField.setPreferredSize(new Dimension(120,30));
        searchPanel.add(bookNameField);
        
        //图书作者标签
        JLabel labelAuthor = new JLabel("图书作者：");
        searchPanel.add(labelAuthor);
        //图书作者输入框
        JTextField authorField = new JTextField();
        authorField.setPreferredSize(new Dimension(120,30));    
        searchPanel.add(authorField);
        
        //图书类别标签
        JLabel labelBookType = new JLabel("图书类别：");
        searchPanel.add(labelBookType);
        //图书类别输入框
        bookTypeField = new JComboBox<>(bcm);
        bookTypeField.setPreferredSize(new Dimension(120,30));
        searchPanel.add(bookTypeField);
        
        //创建按钮
        searchButton = new JButton("查询");
        searchButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/search-icon.png")));
        searchButton.setPreferredSize(new Dimension(100,40));
        searchPanel.add(searchButton);
        
        
        //创建表格面板
        JPanel tablePanel = new JPanel();
        contentPanel.add(tablePanel);
        
        //创建表格
        btm = new BookTableModel();
        table = new JTable(btm);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(750,180));
        add(sp);
        
        
        //创建按钮
    }
}








































