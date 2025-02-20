package posts;

import org.junit.jupiter.api.Test;
import user.UserModel;

import static org.junit.jupiter.api.Assertions.*;


class ReadDataTest {
    ReadData reader = new ReadData();

    @Test
    void readData() {
        assertNotNull(reader.readData("helge@me.com"));

        UserModel geleseneDaten = reader.readData("helge@me.com");
        assertEquals("helge@me.com", geleseneDaten.getEmail());
        assertEquals("Passw0rd!", geleseneDaten.getPassword());
    }

    @Test
    void readWrongData() {
        assertNotNull(reader.readData("helge@me.de"));

        UserModel geleseneDaten = reader.readData("helge@me.de");
        assertEquals("helge@me.de", geleseneDaten.getEmail());
        assertEquals("Passw0rd!", geleseneDaten.getPassword());
    }
}