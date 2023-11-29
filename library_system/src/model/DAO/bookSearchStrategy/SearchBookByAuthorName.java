package model.DAO.bookSearchStrategy;

import context.DBConnectionManager;

import java.sql.*;

public class SearchBookByAuthorName implements SearchBook{

    private static SearchBookByAuthorName instance = new SearchBookByAuthorName();

    public static SearchBookByAuthorName getInstance(){
        return instance;
    }
    private SearchBookByAuthorName(){}
    public ResultSet search(String authorName) throws SQLException {
        String sql =
                "SELECT * " +
                        "FROM book " +
                        "WHERE author = " + '"' + authorName +'"';

        ResultSet resultSet = DBConnectionManager.executeQuery(sql);
        return resultSet;
    }
}
