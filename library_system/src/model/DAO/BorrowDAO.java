package model.DAO;

import common.CommonConstants;
import context.DBConnectionManager;
import model.DAO.borrowListStrategy.BorrowList;
import common.domain.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BorrowDAO {

    private static BorrowDAO instance = new BorrowDAO();
    private BorrowDAO(){
    }
    public static BorrowDAO getInstance(){
        return instance;
    }

    /**
     *
     * @param input
     * @param borrowList
     * @return Borrw list
     * @throws SQLException
     */
    public ArrayList<Borrow> getBorrowList(Object input, BorrowList borrowList) throws SQLException{
        ResultSet resultSet = borrowList.borrowList(input);

        ArrayList<Borrow> borrowListResult = new ArrayList<>();
        while(resultSet.next()){
            Borrow borrow = new Borrow(
                    resultSet.getInt("user_id"),
                    resultSet.getInt("book_id"),
                    resultSet.getString("borrow_date"),
                    resultSet.getString("return_date"),
                    resultSet.getInt("is_returned")
            );
            borrowListResult.add(borrow);
        }

        return borrowListResult;
    }

    public int borrow(int bookId, int userId) throws SQLException{
        String sql =
                "INSERT INTO borrow (userId, bookId, startTime, dueTime, isExtended, status) " +
                        "VALUES (" + userId + ", " + bookId + ", "
                        + '"' + LocalDate.now() + '"' + "," + '"' + LocalDate.now().plusDays(30) + '"' + "," +
                        '"' + CommonConstants.NOT_EXTENDED +'"' + ","+'"' +  CommonConstants.NOT_RETURNED +'"' +  ")";
        int result = DBConnectionManager.executeUpdate(sql);
        return result;
    }

    public int returnBook(int bookId) throws SQLException{
        //TODO : check status first. 대출 중일 때 반납 처리 가능
        String sql = "UPDATE borrow SET status = " + '"' + CommonConstants.RETURNED + '"' + " WHERE bookId = " + bookId;
        int result = DBConnectionManager.executeUpdate(sql);
        return result;
    }
}