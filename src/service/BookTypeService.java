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
     * 
     * @param bookTypeName
     * @param bookTypeDesc
     * @return
     */
    public boolean add(String bookTypeName, String bookTypeDesc) {
        BookType bookType = new BookType();
        bookType.setBookTypeName(bookTypeName);
        bookType.setBookTypeDesc(bookTypeDesc);

        if (bookTypeDao.add(bookType)) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @return
     */
    public List<BookType> list() {
        List<BookType> bs = bookTypeDao.list();
        Collections.sort(bs,(c1,c2)->c1.getId() - c2.getId());
        return bs;
    }

    /**
     * 
     * @param search
     * @return
     */
    public List<BookType> list(String search) {
        return bookTypeDao.list(search);
    }

    /**
     * 
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
     * 
     * @param id
     */
    public void delete(int id) {
        bookTypeDao.delete(id);
    }

    /**
     * 
     * @param id
     * @return
     */
    public BookType getById(int id) {
        return bookTypeDao.getById(id);
    }
}
















































