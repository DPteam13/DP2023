package com.holub.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class SelectStarWithJoinTest {
    @Test
    public void selectStarWithJoin() throws Exception {
        Class.forName("com.holub.database.jdbc.JDBCDriver") //{=JDBCTest.forName}
                .newInstance();

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(            //{=JDBCTest.getConnection}
                    "file:/c:/dbase",
                    "monkey", "priate");

            statement = connection.createStatement();

            statement.executeUpdate(
                    "create table User (" +
                            "  UserId      INTEGER      NOT NULL" +
                            ", UserName   VARCHAR (30) NOT NULL" +
                            ", Address     VARCHAR (30) NOT NULL" +
                            ", PRIMARY KEY( UserId )" +
                            ")"
            );

            statement.executeUpdate(
                    "create table Order (" +
                            "  OrderId      INTEGER      NOT NULL" +
                            ", UserId   VARCHAR (20) NOT NULL" +
                            ", Status       VARCHAR (10) NOT NULL" +
                            ", PRIMARY KEY( OrderId )" +
                            ")"
            );

            String[] UserTableData =
                    {
                            "(1,  'James',   'Busan')",
                            "(2,  'Oasis',     'NewYork')",
                            "(3,  'Kim',  'Seoul')",
                    };

            String[] OrderTableData =
                    {
                            "(101,  1,   'Completed')",
                            "(102,  1,     'WIP')",
                            "(103,  2,  'Completed')",
                            "(104, 3,  'Completed')",
                    };

            for (int i = 0; i < UserTableData.length; ++i)
                statement.executeUpdate(
                        "insert into User VALUES " + UserTableData[i]);
            connection.commit();

            for (int i = 0; i < OrderTableData.length; ++i)
                statement.executeUpdate(
                        "insert into Order VALUES " + OrderTableData[i]);
            connection.commit();


            ResultSet result = statement.executeQuery("select * from User, Order");
            int joinedRecordCount = 0;
            while (result.next()) {
                System.out.println
                        (
                                result.getInt("OrderId") + ", "
                                        + result.getString("UserId") + ", "
                                        + result.getString("UserName") + ", "
                                        + result.getString("Address") + ", "
                                        + result.getString("Status")
                        );
                joinedRecordCount += 1;
            }

            Assertions.assertEquals(UserTableData.length * OrderTableData.length, joinedRecordCount, "User 테이블과 Order 테이블의 각 레코드 개수를 곱한 값이, Join한 결과 값의 레코드 개수와 같아야 합니다.");

        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
    }

}
