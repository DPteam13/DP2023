package controller;

import model.DAO.BorrowDAO;
import model.DAO.borrowListStrategy.BorrowListByUserId;
import model.domain.Borrow;

import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowController {
    private BorrowDAO borrowDAO;
    /**
     *
     * @param bookId
     * @return borrow id
     */
    public int borrow(int bookId, int userId){
        return 0;
    }

    public ArrayList<Borrow> getBorrowListByUserId(int userId) throws SQLException {
        return borrowDAO.getBorrowList(userId, BorrowListByUserId.getInstance()); 
    }
}
