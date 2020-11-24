package dao;

import db.DbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

/**
 * Book对象Dao层
 * @author ZQ
 */
public class BookDao {

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public boolean add(Book book) {
        Connection connection = DbConn.getconn();
        String sql ="INSERT INTO book VALUES (null,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,book.getBookName());
            ps.setString(2, book.getBookAuthor());
            ps.setString(3, book.getBookPrice());
            ps.setInt(4, book.getBookTypeId());
            ps.setInt(5, book.getBookCount());
            ps.setString(6, book.getBookDesc());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Book> list() {
        return list("");
    }

    /**
     * 查询所有书籍
     * @param search
     * @return
     */
    public List<Book> list(String search) {
        List<Book> bs = new ArrayList<>();

        String sql = "SELECT * FROM book";

        //判断输入框是否为空，不为空则追加sql语句
        if(0 != search.length()) {
            sql += " WHERE bookTypeName LIKE '%" + search +"%'";
        }

        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book();

                int id = rs.getInt(1);
                String bookName = rs.getString(2);
                String author = rs.getString(3);
                String price = rs.getString(4);
                int bookTypeId = Integer.parseInt(rs.getString(5));
                int bookCount = Integer.parseInt(rs.getString(6));
                String bookDesc = rs.getString(7);

                book.setBookId(id);
                book.setBookName(bookName);
                book.setBookAuthor(author);
                book.setBookPrice(price);
                book.setBookTypeId(bookTypeId);
                book.setBookCount(bookCount);
                book.setBookDesc(bookDesc);

                bs.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    /**
     * 更新数据
     * @param book
     */
    public void update(Book book) {
        String sql = "UPDATE book SET bookName=?,bookAuthor=?,bookPrice=?,bookTypeId=?,BorrowingNumbers=?,bookDesc=? " +
                "WHERE book_id=?";
        try {
            Connection connection =DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, book.getBookName());
            ps.setString(2, book.getBookAuthor());
            ps.setString(3, book.getBookPrice());
            String bookTypeId = String.valueOf(book.getBookTypeId());
            ps.setString(4, bookTypeId);
            String bookCount = String.valueOf(book.getBookCount());
            ps.setString(5, bookCount);
            ps.setString(6, book.getBookDesc());
            String id = String.valueOf(book.getBookId());
            ps.setString(7, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除数据
     * @param id
     */
    public void delete(int id) {
        String sql = "DELETE FROM book WHERE book_id=?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
