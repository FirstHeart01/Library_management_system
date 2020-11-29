package service;

import dao.BookTypeDao;
import entity.BookType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ZQ
 */
public class BookTypeService {
    
    //dao层
    BookTypeDao bookTypeDao = new BookTypeDao();

    /**
     * 添加图书类别记录
     * @param bookTypeName
     * @param bookTypeDesc
     * @return
     */
    public boolean add(String bookTypeName, String bookTypeDesc) {
        BookType bookType = new BookType();
        bookType.setBookTypeName(bookTypeName);
        bookType.setBookTypeDesc(bookTypeDesc);

        return bookTypeDao.add(bookType);
    }

    /**
     * 显示全部
     * @return
     */
    public List<BookType> list() {
        List<BookType> bs = bookTypeDao.list();
        bs.sort((c1, c2) -> c1.getId() - c2.getId());
        return bs;
    }

    /**
     * 部分搜索
     * @param search
     * @return
     */
    public List<BookType> list(String search) {
        return bookTypeDao.list(search);
    }

    /**
     * 修改数据
     * @param id
     * @param typeName
     * @param typeDesc
     */
    public void update(int id, String typeName, String typeDesc) {
        BookType bookType = new BookType();
        
        bookType.setId(id);
        bookType.setBookTypeName(typeName);
        bookType.setBookTypeDesc(typeDesc);
        
        bookTypeDao.update(bookType);
    }

    /**
     * 删除数据
     * @param id
     */
    public void delete(int id) {
        bookTypeDao.delete(id);
    }

    /**
     * 根据类型id获取bookType对象
     * @param id
     * @return
     */
    public BookType getById(int id) {
        return bookTypeDao.getById(id);
    }
}
















































