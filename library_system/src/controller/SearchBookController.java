package controller;

import model.DAO.BookDAO;
import model.DAO.bookSearchStrategy.SearchBookByBookName;
import model.domain.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchBookController {
    private BookDAO bookDAO;


    /**
     *
     * @param bookName
     * @return Book
     */
    public ArrayList<Book> searchByBookName(String bookName){
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.search(bookName, SearchBookByBookName.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    /**
     *
     * @param author
     * @return book id
     */
    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.search(author, SearchBookByBookName.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}
