package model.DAO;

import common.CommonConstants;
import context.DBConnectionManager;
import model.DAO.borrowListStrategy.BorrowList;
import common.domain.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
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

        while(resultSet.next()){
            Borrow borrow = new Borrow(
                    resultSet.getInt("user_id"),
                    resultSet.getInt("book_id"),
                    resultSet.getString("borrow_date"),
                    resultSet.getString("return_date"),
                    resultSet.getInt("is_returned")
            );

        }

        return null;
    }

    public int borrow(int bookId, int userId) throws SQLException{
        String sql =
                "INSERT INTO borrow (user_id, book_id, borrow_date, return_date, is_returned) " +
                        "VALUES (" + userId + ", " +
                         bookId + ", " +
                        "NOW(), " +
                        "DATE_ADD(NOW(), INTERVAL 30 DAY), "
                        + CommonConstants.NOT_RETURNED + ")";
        ResultSet resultSet = DBConnectionManager.executeQuery(sql);
        
        return 0;
    }
}
