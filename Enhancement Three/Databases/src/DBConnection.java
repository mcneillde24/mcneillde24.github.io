// DBConnection.java
//class to connect to my animal_rescue.db SQLite database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // define the url for the SQLite database
    private static final String URL = "jdbc:sqlite:animal_rescue.db";

    // Establishes the SQLite database connection
public static Connection connect() {
    try {
        // Load the SQLite JDBC driver
        Class.forName("org.sqlite.JDBC"); 
        Connection conn = DriverManager.getConnection(URL);
        return conn;
    } catch (ClassNotFoundException e) {
        // Print error if JDBC driver is not found
        System.out.println("JDBC Driver not found: " + e.getMessage());
        return null;
    } catch (SQLException e) {
        // Print error if the connection failed
        System.out.println("Connection failed: " + e.getMessage());
    }
    // Return null if connection fails
    return null;
}
}