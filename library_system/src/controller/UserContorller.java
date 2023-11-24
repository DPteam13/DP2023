package controller;

import common.domain.Borrow;
import common.domain.User;
import model.DAO.BorrowDAO;
import model.DAO.borrowListStrategy.BorrowListByUserId;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserContorller {
    private static UserContorller instance = new UserContorller();
    private UserContorller(){};
    public static UserContorller getInstance(){
        return instance;
    }
    private BorrowDAO borrowDAO = BorrowDAO.getInstance();

    /**
     *
     * @param userId
     * @return 대출 목록
     */
    public ArrayList<Borrow> borrowList(int userId){
        try{
            ArrayList<Borrow> resultList = borrowDAO.getBorrowList(userId, BorrowListByUserId.getInstance());
            return resultList;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
