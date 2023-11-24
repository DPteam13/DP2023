package controller;

import model.DAO.BorrowDAO;

import java.sql.SQLException;

public class ReturnController {
    private static ReturnController instance = new ReturnController();
    private ReturnController(){};
    public static ReturnController getInstance(){
        return instance;
    }

    private BorrowDAO borrowDAO = BorrowDAO.getInstance();
    /**
     *
     * @param bookId
     * @return status 성공 여부
     */
    public int returnBookByBookId(int bookId){
        try{
            int result = borrowDAO.returnBook(bookId);
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
}
