package model.DAO;

import context.DBConnectionManager;
import model.domain.Book.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO extends DAO{
//    public BookDAO(Connection conn){
//        super(conn);
//    }

    public Book search(String bookName) {
        /**
         * 함수 오버로딩해서도 도서명 검색 저자 검색 구분할 수 있을거 같기도 한데
         * 여기도 Search 클래스로 만들어서 갈아끼우는걸로 해서 전략 패턴 적용해도 될듯
         */

        String sql =
                "SELECT *" +
                "FROM book" +
                "WHERE name = " + bookName;
        try {
            ResultSet resultSet = DBConnectionManager.executeQuery(sql);
            //TODO parse result
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
