package model.DAO.borrowListStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BorrowList {
    public ResultSet borrowList(Object input) throws SQLException;
}
