package model.DAO.bookSearchStrategy;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface SearchBook {
    public ResultSet search(String name) throws SQLException;
}
