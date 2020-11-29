package dao;

import db.DbConn;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User对象Dao层
 * @author ZQ
 */
public class UserDao {

    /**
     * 
     * @param userName
     * @param password
     * @return
     */
    public static boolean login(String userName, String password) {
       String sql = "SELECT * FROM user WHERE id = ? AND password = ?";
       try {
           Connection connection = DbConn.getconn();
           PreparedStatement ps = connection.prepareStatement(sql);
           
           ps.setString(1,userName);    
           ps.setString(2,password);
           
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()) {
               System.out.println("匹配成功!!!!");
               return true;
           }
           return false;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
    }

    /**
     * 
     * @param userName
     * @return
     */
    public static boolean isAdmin(String userName) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,userName);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                int isAdmin = rs.getInt("admin");
                if(isAdmin == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 
     * @param id
     * @return
     */
    public static User getUser(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                User user = new User();
                
                user.setId(id);
                user.setUserName(rs.getString(2));  
                user.setPassword(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
