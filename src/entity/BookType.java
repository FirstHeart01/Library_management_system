package entity;

import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * BookType
 * @author 曾琪
 */
public class BookType {
    //数据库主键
    private int id;
    private String bookTypeName;
    private String bookTypeDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getBookTypeDesc() {
        return bookTypeDesc;
    }

    public void setBookTypeDesc(String bookTypeDesc) {
        this.bookTypeDesc = bookTypeDesc;
    }
}

