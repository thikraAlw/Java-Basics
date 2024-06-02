package day4;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertDemo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\untitled\\src\\main\\java\\day4\\hr.db";
        String query = "insert into jobs values (?, ?, ?, ?)";


        try (Connection con1 = DriverManager.getConnection(url);) {

            PreparedStatement st = con1.prepareStatement(query);

            System.out.println("Enter job ID: ");
            int jobId = s.nextInt();
            st.setInt(1,jobId);
            s.nextLine();

            System.out.println("Enter job title: ");
            String jobTitle = s.nextLine();
            st.setString(2,jobTitle);

            System.out.println("Enter min salary: ");
            double min = s.nextDouble();
            st.setDouble(3,min);

            System.out.println("Enter max salary: ");
            double max = s.nextDouble();
            st.setDouble(4,max);

            int rows = st.executeUpdate();

            System.out.println(rows + "inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
