package model.DAO;

import model.DAO.bookSearchStrategy.SearchBook;
import common.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO extends DAO{
    private static BookDAO instance = new BookDAO();
    private BookDAO(){
    }
    public static BookDAO getInstance(){
        return instance;
    }

    /**
     *
     * @param searchParameter
     * @return book list
     */
    public ArrayList<Book> search(String searchParameter, SearchBook searchMethod) throws SQLException{
        ResultSet resultSet = searchMethod.search(searchParameter);

        ArrayList<Book> resultList = new ArrayList<>();
        while(resultSet.next()){
            Book book = new Book(
                    resultSet.getString("bookId"),
                    resultSet.getString("name"),
                    resultSet.getString("location"),
                    resultSet.getString("isbn"),
                    resultSet.getString("publisher"),
                    resultSet.getString("author"),
                    resultSet.getString("isBorrowed")
                    );
            resultList.add(book);

        }

        return resultList;
    }
}
