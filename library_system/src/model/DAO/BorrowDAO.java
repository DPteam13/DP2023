package model.DAO;

import model.DAO.borrowListStrategy.BorrowList;
import common.domain.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowDAO {

    public ArrayList<Borrow> getBorrowList(Object input, BorrowList borrowList) throws SQLException{
        ResultSet resultSet = borrowList.borrowList(input);

        while(resultSet.next()){
            Borrow borrow = new Borrow(
                    resultSet.getInt("user_id"),
                    resultSet.getInt("book_id"),
                    resultSet.getString("borrow_date"),
                    resultSet.getString("return_date"),
                    resultSet.getInt("is_returned")
            );

        }

        return null;
    }
}
