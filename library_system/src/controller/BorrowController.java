package controller;

import model.DAO.BorrowDAO;
import model.DAO.borrowListStrategy.BorrowListByUserId;
import common.domain.Borrow;

import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowController {
    private BorrowDAO borrowDAO;

    private static BorrowController instance = new BorrowController();
    private BorrowController(){
        borrowDAO = BorrowDAO.getInstance();
    }
    public static BorrowController getInstance(){
        return instance;
    }

    /**
     *
     * @param bookId
     * @return borrow id
     */
    public int borrow(int bookId, int userId) throws SQLException{
        return borrowDAO.borrow(bookId, userId);
    }

    public ArrayList<Borrow> getBorrowListByUserId(int userId) throws SQLException {
        return borrowDAO.getBorrowList(userId, BorrowListByUserId.getInstance()); 
    }
}
