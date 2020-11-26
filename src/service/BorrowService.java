package service;

import dao.BorrowDao;
import entity.Book;
import entity.Borrow;
import view.frame.LoginFrame;

import java.util.Date;
import java.util.List;

/**
 * @author ZQ
 */
public class BorrowService {
    //dao层
    BorrowDao borrowDao = new BorrowDao();

    /**
     * 
     * @param book
     * @return
     */
    public boolean add(Book book) {
        Borrow borrow = new Borrow();
        
        borrow.setUserId(LoginFrame.user.getId());  
        borrow.setBookId(book.getBookId());
        borrow.setBookName(book.getBookName());
        borrow.setBookBorrowDate(new Date().toString());
        borrow.setBookTypeId(book.getBookTypeId());
        
        return borrowDao.add(borrow);
    }
    
    public List<Borrow> list() {
        return borrowDao.list();
    }

    /**
     * 
     * @param borrow
     */
    public void delete(Borrow borrow) {
        borrowDao.delete(borrow);
    }
}







































