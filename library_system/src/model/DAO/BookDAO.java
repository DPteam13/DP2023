package model.DAO;

import context.DBConnectionManager;
import model.DAO.bookSearchStrategy.SearchBook;
import model.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO extends DAO{
//    public BookDAO(Connection conn){
//        super(conn);
//    }

    /**
     *
     * @param bookName
     * @return book list
     */
    public ArrayList<Book> search(String bookName, SearchBook searchMethod) throws SQLException{
        ResultSet resultSet = searchMethod.search(bookName);

        ArrayList<Book> resultList = new ArrayList<>();
        while(resultSet.next()){
            Book book = new Book(
                    resultSet.getString("name"),
                    resultSet.getString("isbn"),
                    resultSet.getInt("classification_code"),
                    resultSet.getInt("publisher_id"),
                    resultSet.getInt("author_id"),
                    resultSet.getInt("is_borrowed")
            );
            resultList.add(book);

        }

        return resultList;
    }
}
