package posts;

import org.junit.jupiter.api.Test;
import posts.db.DatabaseConnection;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void getConnectionTest() {
        Connection conn = DatabaseConnection.getConnection();
        assertNotNull(conn);

    }
}
