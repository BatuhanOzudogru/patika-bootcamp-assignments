package Week6;

import java.sql.*;

public class JDBC {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        Connection connect = null;
        Statement st = null;
        String sql = "SELECT * FROM employees";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Id : " + rs.getInt("employee_id") + " Name : " + rs.getString("employee_name") +
                        " Position : " + rs.getString("employee_position") + " Salary : " + rs.getInt("employee_salary"));
            }


            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
