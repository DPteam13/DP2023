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
    public int borrow(int bookId, int userId){
        try {
            int result = borrowDAO.borrow(bookId, userId);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Borrow> getBorrowListByUserId(int userId){
        try{
            ArrayList<Borrow> result = borrowDAO.getBorrowList(userId, BorrowListByUserId.getInstance());
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
