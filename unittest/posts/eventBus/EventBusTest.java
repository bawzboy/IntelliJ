package posts.eventBus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventBusTest {

    InterfaceEventBus iEventBus;

    @BeforeEach
    void initEventBus() {
        iEventBus = EventBus.getInstance();
    }

    @Test
    void testConstructor() {
        assertNotNull(iEventBus);
    }

    @Test
    void testSendeMessageHelloWorld() {
        iEventBus.sendMessage("Hello World");
    }

    @Test
    void testRegisterListener() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
            }
        });
    }

    String erhalteneMessage = "";
    String erhalteneMessage2 = "";

    @Test
    void testRegisterListenerUndSendeMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage = s;
            }
        });
        assertEquals("", erhalteneMessage);
        iEventBus.sendMessage("Hello World über den EventBus");
        assertEquals("Hello World über den EventBus", erhalteneMessage);

    }

    @Test
    void testRegisterListenerUndSendeMultipleMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage = s;
            }
        });
        assertEquals("", erhalteneMessage);
        iEventBus.sendMessage("Hello World über den EventBus");
        assertEquals("Hello World über den EventBus", erhalteneMessage);

        iEventBus.sendMessage("Hello World über den EventBus2");
        assertEquals("Hello World über den EventBus2", erhalteneMessage);

    }


    @Test
    void testRegisterMultipleListenerUndSendeMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage = s;

            }
        });
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage2 = s;
            }
        });

        assertEquals("", erhalteneMessage);

        iEventBus.sendMessage("Hello World über den EventBus");
        assertEquals("Hello World über den EventBus", erhalteneMessage);
        assertEquals("Hello World über den EventBus", erhalteneMessage2);

    }

    @Test
    void testRegisterMultipleListenerUndSendeMultipleMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage = s;

            }
        });
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(String s) {
                erhalteneMessage2 = s;

            }
        });

        assertEquals("", erhalteneMessage);

        iEventBus.sendMessage("Hello World über den EventBus");
        assertEquals("Hello World über den EventBus", erhalteneMessage);
        assertEquals("Hello World über den EventBus", erhalteneMessage2);

        iEventBus.sendMessage("Message 2 über den EventBus");
        assertEquals("Message 2 über den EventBus", erhalteneMessage);
        assertEquals("Message 2 über den EventBus", erhalteneMessage2);

    }

}