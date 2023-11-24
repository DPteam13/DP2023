package model.DAO.borrowListStrategy;

import context.DBConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowListByUserId implements BorrowList{

    private static BorrowListByUserId instance = new BorrowListByUserId();
    private BorrowListByUserId(){}
    public static BorrowListByUserId getInstance(){
        return instance;
    }

    public ResultSet borrowList(Object id) throws SQLException {
        return borrowList((int)id);
    }
    private ResultSet borrowList(int userId) throws SQLException {
        return DBConnectionManager.executeQuery("SELECT * FROM borrow WHERE user_id = " + userId);
    }
}
