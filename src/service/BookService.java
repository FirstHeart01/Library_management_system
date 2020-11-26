package service;


import dao.BookDao;
import entity.Book;
import entity.BookType;

import java.util.List;

/**
 * @author ZQ
 */
public class BookService {
    
    //dao层
    BookDao bookDao = new BookDao();
    
    public boolean add(String bookName, String author, String price,
                       BookType bookType, int bookCount, String bookDesc) {
        Book book = new Book();
        
        book.setBookName(bookName);
        book.setBookAuthor(author);
        book.setBookPrice(price);
        book.setBookTypeId(bookType.getId());
        book.setBookCount(bookCount);
        book.setBookDesc(bookDesc);
        
        if(bookDao.add(book)) {
            return true;
        }
        return false;
    }
    
    public List<Book> list() {
        return bookDao.list();
    }

    /**
     * 
     * @param id
     * @param bookName
     * @param author
     * @param price
     * @param bookType
     * @param bookCount
     * @param bookDesc
     */
    public void update(int id, String bookName, String author, String price,
                       BookType bookType, int bookCount, String bookDesc) {
        Book book = new Book();
        
        book.setBookId(id);
        book.setBookName(bookName);
        book.setBookAuthor(author);
        book.setBookPrice(price);
        book.setBookTypeId(bookType.getId());
        book.setBookCount(bookCount);
        book.setBookDesc(bookDesc);
        
        bookDao.update(book);
    }

    /**
     * 
     * @param id
     */
    public void delete(int id ) {
        bookDao.delete(id);
    }
}




































