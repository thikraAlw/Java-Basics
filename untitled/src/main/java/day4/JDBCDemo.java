package day4;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\untitled\\src\\main\\java\\day4\\hr.db";
        String query = "select * from departments";

        try (Connection conn = DriverManager.getConnection(url);) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Department d = new Department(rs);
                System.out.println(d);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
