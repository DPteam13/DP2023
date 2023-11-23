package model.DAO.borrowListStrategy;

import context.DBConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowListByBorrowId implements BorrowList{

    private static BorrowListByBorrowId instance = new BorrowListByBorrowId();

    private BorrowListByBorrowId(){}
    public static BorrowListByBorrowId getInstance(){
        return instance;
    }
    public ResultSet borrowList(Object id) throws SQLException {
        return borrowList((int)id);
    }
    private ResultSet borrowList(int borrowId) throws SQLException {
        return DBConnectionManager.executeQuery("SELECT * FROM borrow WHERE borrow_id = " + borrowId);
    }
}
