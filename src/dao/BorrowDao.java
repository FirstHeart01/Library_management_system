package dao;

import db.DbConn;
import entity.Borrow;
import view.frame.LoginFrame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Borrow对象Dao层
 * @author ZQ
 */
public class BorrowDao {

    /**
     *
     * @param borrow
     * @return
     */
    public boolean add(Borrow borrow) {
        boolean bool = false;
        String sql = "INSERT INTO borrow(user_id,book_id,bookBorrowTime,bookType_id,bookName) VALUES(?,?,?,?,?)";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,borrow.getUserId());
            ps.setInt(2,borrow.getBookId());
            ps.setString(3,borrow.getBookBorrowDate());
            ps.setInt(4,borrow.getBookTypeId());
            ps.setString(5,borrow.getBookName());

            int rs = ps.executeUpdate();
            
            if(rs > 0)
                bool = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public List<Borrow> list() {
        return list("");
    }

    public List<Borrow> list(String search) {
        List<Borrow> bs = new ArrayList<>();

        String sql = "SELECT * FROM borrow";

        if(0 != search.length()) {
            sql += " WHERE bookTypeId like '%" + search + "%'";
        }

        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Borrow borrow = new Borrow();
                int userId = LoginFrame.user.getId();
                int bookId = rs.getInt(2);
                String borrowDate = rs.getString(3);
                int bookTypeId = rs.getInt(4);
                String bookName = rs.getString(6);
                
                borrow.setUserId(userId);
                borrow.setBookId(bookId);
                borrow.setBookBorrowDate(borrowDate);
                borrow.setBookTypeId(bookTypeId);
                borrow.setBookName(bookName);
                
                bs.add(borrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    /**
     * 
     * @param borrow
     */
    public void delete(Borrow borrow) {
       String sql = "DELETE FROM borrow WHERE user_id = ? AND book_id = ? AND bookBorrowTime = ?";
       try {
           Connection connection = DbConn.getconn();
           PreparedStatement ps = connection.prepareStatement(sql); 
           
           ps.setInt(1,borrow.getUserId());
           ps.setInt(2,borrow.getBookId());
           ps.setString(3, borrow.getBookBorrowDate()); 
           
           ps.execute();
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
}
