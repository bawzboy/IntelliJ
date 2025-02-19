package posts;

import org.junit.jupiter.api.Test;
import user.UserModel;

import static org.junit.jupiter.api.Assertions.*;


class ReadDataTest {
    ReadData reader = new ReadData();
    UserModel user = new UserModel();

    @Test
    void readData() {
        assertNotNull(reader.readData("helge@me.com"));

        assertEquals(user, reader.readData("helge@me.com"));
    }
}