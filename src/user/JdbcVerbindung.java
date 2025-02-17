package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcVerbindung {
//    private static final String URL = "jdbc:postgresql://ep-quiet-night-a26ia73p-pooler.eu-central-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_I3GCKQpfL1ht&sslmode=require";
//    private static final String USER = "neondb_owner";
//    private static final String PASSWORD = "npg_I3GCKQpfL1ht";
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL80";
    private static final String USER = "root";
    private static final String PASSWORD = "321-Meins";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Verbindung erfolgreich!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
