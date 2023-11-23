package model.DAO.bookSearchStrategy;

import context.DBConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBookByBookName implements SearchBook{

    private static SearchBookByBookName instance = new SearchBookByBookName();
    public static SearchBookByBookName getInstance(){
        return instance;
    }
    private SearchBookByBookName(){}

    public ResultSet search(String bookName) throws SQLException {
        String sql =
                "SELECT *" +
                "FROM book" +
                "WHERE name = " + bookName;

        ResultSet resultSet = DBConnectionManager.executeQuery(sql);
        return resultSet;
    }
}
