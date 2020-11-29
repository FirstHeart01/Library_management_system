package view.frame;

import entity.Borrow;
import model.BorrowTableModel;
import service.BorrowService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ZQ
 */
public class ReturnBookFrame extends JFrame {
    
    public static ReturnBookFrame instance = new ReturnBookFrame();
    
    BorrowService service = new BorrowService();
    
    //创建数据源
    BorrowTableModel btm = new BorrowTableModel();
    JTable table;
    
    //创建按钮
    JButton searchButton;
    JButton returnButton;
    
    public ReturnBookFrame() {
        //设置窗体信息
        setTitle("图书归还");
        setSize(800,400);   
        setLocationRelativeTo(null);
        setResizable(false);    
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/归还.png"))); 
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        setContentPane(contentPanel);
        contentPanel.setBorder(new EmptyBorder(0,30,10,30));
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
        searchPanel.setPreferredSize(new Dimension(getWidth(), 70));
        contentPanel.add(searchPanel);
        
        JLabel labelBookName = new JLabel("点击查询借阅的图书");
        labelBookName.setFont(new Font("微软雅黑",Font.BOLD,20));
        searchPanel.add(labelBookName);
        
        searchButton = new JButton("查询所有");
        searchButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/search-icon.png")));
        searchButton.setPreferredSize(new Dimension(150,40));
        searchPanel.add(searchButton);
        
        JPanel tablePanel = new JPanel();
        contentPanel.add(tablePanel);
        
        table = new JTable(btm);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(750,180));    
        add(sp);
        
        
        JPanel returnPanel = new JPanel();
        contentPanel.add(returnPanel);
        
        returnButton = new JButton("确认归还");
        returnButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/ADD.png")));
        returnButton.setPreferredSize(new Dimension(180,40));   
        returnPanel.add(returnButton);
        
        
        addReturnListener();
        
        setVisible(true);
    }

    /**
     * 获取表格选中当前行的数据
     * @return
     */
    public Borrow getSelectBook() {
        int index = table.getSelectedRow();
        return BorrowTableModel.cs.get(index);
    }

    /**
     * 更新数据
     */
    public void updateData() {
        BorrowTableModel.cs = new BorrowService().list();
        table.updateUI();
    }
    

    /**
     * 
     */
    public void addReturnListener() {
       returnButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(table.getSelectedRow() == -1) {
                   JOptionPane.showMessageDialog(ReturnBookFrame.this,"请先选择一条记录");
                   return;
               }
               int choice = JOptionPane.showConfirmDialog(ReturnBookFrame.this,"是否删除");
               if(choice != JOptionPane.OK_OPTION) {
                   return;
               }
               
               Borrow borrow = getSelectBook();
               
               service.delete(borrow);
               
               updateData();
           }
       }); 
    }

    public static void main(String[] args) {
        
    }
}































