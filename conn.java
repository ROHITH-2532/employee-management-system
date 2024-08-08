package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    public Connection connection;
    public Statement statement;

    public conn() {
        try {
            // Load the JDBC driver
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Rohith111");
            // Create a statement object
            statement = connection.createStatement();
            System.out.println("Connection and Statement initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
