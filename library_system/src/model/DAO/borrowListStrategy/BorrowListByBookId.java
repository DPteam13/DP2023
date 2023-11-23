package model.DAO.borrowListStrategy;

import context.DBConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowListByBookId {
    private int bookId;
    public BorrowListByBookId(int id){
        this.bookId = id;
    }
    public ResultSet borrowList() throws SQLException {
        String sql = "SELECT * FROM borrow WHERE book_id = " + bookId;
        return DBConnectionManager.executeQuery(sql);
    }
}
