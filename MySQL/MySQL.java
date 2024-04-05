import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
