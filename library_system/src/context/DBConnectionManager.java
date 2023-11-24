package context;

import java.sql.*;

public class DBConnectionManager {
    public static Connection getConnection(){
        String driver = "com.holub.database.jdbc.JDBCDriver";
        String url = "";	// TODO 추가
        String id = "root";
        String pwd = "1234";

        Connection con = null;

        try {
            Class.forName(driver).newInstance();
            try {
                con = DriverManager.getConnection(url, id, pwd);
                System.out.println("Connected...");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection Failed!");
                e.printStackTrace(); 	// 예외 발생시 내용 출력
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Connection Failed. Check Driver or URL");
            e.printStackTrace(); 		// 예외 발생시 내용 출력
        }

        return con;

    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        statement.close();
        conn.close();
        return resultSet;
    }

    public static int executeUpdate(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(sql);
        statement.close();
        conn.close();
        return result;
    }
}
