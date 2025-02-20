package posts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {
    PasswordCheck pwcheck = new PasswordCheck();

    @Test
    public void checkPassword(){
        assertTrue(pwcheck.check("helge@me.com", "Passw0rd!"));
        assertFalse(pwcheck.check("helge@me.com", "Passw0rd"));
        assertFalse(pwcheck.check("helge@me.", "Passw0rd!"));
    }
}
