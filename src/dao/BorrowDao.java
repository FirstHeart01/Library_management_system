package dao;

import db.DbConn;
import entity.Borrow;
import view.frame.LoginFrame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BorrowDao {

    /**
     *
     * @param borrow
     * @return
     */
    public boolean add(Borrow borrow) {
        String sql = "INSERT INTO borrow VALUES(?,?,?,?,?)";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1,borrow.getUserId());
            ps.setInt(2,borrow.getBookId());
            ps.setString(3,borrow.getBookName());
            ps.setString(4,borrow.getBookBorrowDate());
            ps.setInt(5,borrow.getBookTypeId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
                String bookName = rs.getString(3);
                String borrowDate = rs.getString(4);
                int bookTypeId = rs.getInt(5);
                
                borrow.setUserId(userId);
                borrow.setBookId(bookId);
                borrow.setBookName(bookName);
                borrow.setBookBorrowDate(borrowDate);
                borrow.setBookTypeId(bookTypeId);
                
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
