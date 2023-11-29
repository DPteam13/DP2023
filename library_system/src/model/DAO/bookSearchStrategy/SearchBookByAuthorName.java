package model.DAO.bookSearchStrategy;

import context.DBConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBookByAuthorName implements SearchBook{

    private SearchBookByAuthorName instance = new SearchBookByAuthorName();

    public SearchBookByAuthorName getInstance(){
        return instance;
    }
    private SearchBookByAuthorName(){}
    public ResultSet search(String bookName) throws SQLException {
        String sql =
                "SELECT *" +
                        "FROM book" +
                        "WHERE name = ?";
        
        ResultSet resultSet = DBConnectionManager.executeQuery(sql);
        return resultSet;
    }
}
