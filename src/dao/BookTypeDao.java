package dao;

import db.DbConn;
import entity.BookType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * BookType对象Dao层
 * @author ZQ
 */
public class BookTypeDao {
    /**
     * 添加
     * @param bookType
     * @return
     */
    public boolean add(BookType bookType) {
        String sql = "INSERT INTO booktype values(null,?,?)";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,bookType.getBookTypeName());
            ps.setString(2,bookType.getBookTypeDesc());

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

    public List<BookType> list() {
        return list("");
    }
    public List<BookType> list(String search) {
        List<BookType> bs = new ArrayList<>();
        String sql = "SELECT * FROM booktype";

        //
        if(0 != search.length()) {
            sql += " WHERE bookTypeName LIKE '%" + search + "%'";
        }

        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookType bookType = new BookType();
                int id = rs.getInt(1);
                String typeName = rs.getString(2);
                String typeDesc = rs.getString(3);
                bookType.setId(id);
                bookType.setBookTypeName(typeName);
                bookType.setBookTypeDesc(typeDesc);
                bs.add(bookType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    /**
     * 更新
     * @param bookType
     */
    public void update(BookType bookType) {
        String sql = "UPDATE booktype SET bookTypeName = ?, bookTypeDesc = ? WHERE id = ?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1,bookType.getBookTypeName());
            ps.setString(2,bookType.getBookTypeDesc());
            ps.setInt(3,bookType.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id) {
        String sql = "DELETE FROM booktype WHERE id = ?";

        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据名称返回BookType对象
     * @param name
     * @return
     */
    public BookType getByName(String name) {
        String sql = "SELECT * FROM booktype WHERE bookTypeName = ?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookType bookType = new BookType();
                int id = rs.getInt(1);
                String typeName = rs.getString(2);
                String typeDesc = rs.getString(3);

                bookType.setId(id);
                bookType.setBookTypeName(typeName);
                bookType.setBookTypeDesc(typeDesc);

                return bookType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public BookType getById(int id) {
        String sql = "SELECT * FROM booktype WHERE id = ?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookType bookType = new BookType();
                int tempId = rs.getInt(1);
                String typeName = rs.getString(2);
                String typeDesc = rs.getString(3);
                bookType.setId(tempId);
                bookType.setBookTypeName(typeName);
                bookType.setBookTypeDesc(typeDesc);
                return bookType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
