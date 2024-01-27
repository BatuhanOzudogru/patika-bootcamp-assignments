package Week6;

import java.sql.*;

public class JDBC {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        Connection connect = null;
        Statement st = null;
        // SQL query to retrieve data from the database
        String sql = "SELECT * FROM employees";
        try {
            // Establish a database connection
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            // Create a statement for executing SQL queries
            st = connect.createStatement();
            // Execute the SQL query and get the result set
            ResultSet rs = st.executeQuery(sql);
            // Iterate through the result set and print employee details
            while (rs.next()) {
                System.out.println("Id : " + rs.getInt("employee_id") + " Name : " + rs.getString("employee_name") +
                        " Position : " + rs.getString("employee_position") + " Salary : " + rs.getInt("employee_salary"));
            }

            // Close the database connection
            connect.close();
        } catch (SQLException e) {
            // Handle any SQLException that might occur during database operations
            // and throw a RuntimeException with the original exception for debugging purposes
            throw new RuntimeException(e);
        }
    }
}
