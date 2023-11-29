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
        String sql = "SELECT borrowId " +
                "FROM borrow";
        try {
            ResultSet result = DBConnectionManager.executeQuery(sql);
            int counter = 1 ;
            while(result.next()){
                counter++;
            }
            Borrow.setIdCounter(counter);
        }catch (SQLException e) {
            e.printStackTrace();
            Borrow.setIdCounter(10000);
        }

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
                    resultSet.getInt("userId"),
                    resultSet.getInt("bookId"),
                    resultSet.getString("startTime"),
                    resultSet.getString("dueTime"),
                    resultSet.getInt("isReturned")
            );
            borrowListResult.add(borrow);
        }

        return borrowListResult;
    }

    public int borrow(int bookId, int userId) throws SQLException{
        String sql =
                "INSERT INTO borrow (borrowId, userId, bookId, startTime, dueTime, isExtended, status) " +
                "VALUES (" + Borrow.getIdCounter() + ", " + userId + ", " + bookId + ", "
                + '"' + LocalDate.now() + '"' + "," + '"' + LocalDate.now().plusDays(30) + '"' + "," +
                '"' + CommonConstants.NOT_EXTENDED +'"' + ","+'"' +  CommonConstants.NOT_RETURNED +'"' +  ")";
        int result = DBConnectionManager.executeUpdate(sql);
        Borrow.setIdCounter(Borrow.getIdCounter() + 1);
        return result;
    }

    public int returnBook(int bookId) throws SQLException{
        //TODO : check status first. 대출 중일 때 반납 처리 가능
        String sql = "UPDATE borrow SET status = " + '"' + CommonConstants.RETURNED + '"' + " WHERE bookId = " + bookId;
        int result = DBConnectionManager.executeUpdate(sql);
        return result;
    }
}