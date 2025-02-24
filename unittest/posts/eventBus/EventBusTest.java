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
        iEventBus.sendMessage(new TextMessage("Hello World"));
    }

    @Test
    void testRegisterListener() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {

            }
        });
    }

    String erhalteneMessage = "";
    String erhalteneMessage2 = "";

    @Test
    void testRegisterListenerUndSendeMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage = (String) ((TextMessage) baseMessage).getMessageContent();
            }
        });
        assertEquals("", erhalteneMessage);
        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus"));
        assertEquals("Hello World über den EventBus", erhalteneMessage);

    }

    @Test
    void testRegisterListenerUndSendeMultipleMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage = (String) ((TextMessage) baseMessage).getMessageContent();
            }
        });
        assertEquals("", erhalteneMessage);
        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus"));
        assertEquals("Hello World über den EventBus", erhalteneMessage);

        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus2"));
        assertEquals("Hello World über den EventBus2", erhalteneMessage);

    }


    @Test
    void testRegisterMultipleListenerUndSendeMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage = (String) ((TextMessage) baseMessage).getMessageContent();
            }

        });
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage2 = (String) ((TextMessage) baseMessage).getMessageContent();
            }

        });

        assertEquals("", erhalteneMessage);

        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus"));
        assertEquals("Hello World über den EventBus", erhalteneMessage);
        assertEquals("Hello World über den EventBus", erhalteneMessage2);

    }

    @Test
    void testRegisterMultipleListenerUndSendeMultipleMessageAnCallback() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage = (String) ((TextMessage) baseMessage).getMessageContent();
            }

        });
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                erhalteneMessage2 = (String) ((TextMessage) baseMessage).getMessageContent();
            }

        });

        assertEquals("", erhalteneMessage);

        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus"));
        assertEquals("Hello World über den EventBus", erhalteneMessage);
        assertEquals("Hello World über den EventBus", erhalteneMessage2);

        iEventBus.sendMessage(new TextMessage("Message 2 über den EventBus"));
        assertEquals("Message 2 über den EventBus", erhalteneMessage);
        assertEquals("Message 2 über den EventBus", erhalteneMessage2);

    }

    String email;

    @Test
    void test2UnterschiedlicheMessageTypen() {
        iEventBus.registerListener(new InterfaceCallback() {
            @Override
            public void handleMessage(BaseMessage baseMessage) {
                switch (baseMessage.getMessageType()){
                    case "TextMessage":
                        erhalteneMessage = (String) ((TextMessage) baseMessage).getMessageContent();
                        break;
                    case "SuccessfulLogin":
                        email = (String) ((SuccessfulLogin) baseMessage).getMessageContent();
                        break;
                }
            }
        });
        iEventBus.sendMessage(new TextMessage("Hello World über den EventBus"));
        iEventBus.sendMessage(new SuccessfulLogin("helge@me.com"));
        assertEquals("Hello World über den EventBus", erhalteneMessage);
        assertEquals("helge@me.com", email);
    }

    @Test
        void testDifferentMessageTypes() {
            iEventBus.registerListener(new InterfaceCallback() {
                @Override
                public void handleMessage(BaseMessage baseMessage) {
                    erhalteneMessage = baseMessage.getMessageType();
                }
            });
        iEventBus.sendMessage(new TextMessage(""));
        assertEquals("TextMessage", erhalteneMessage);
        iEventBus.sendMessage(new SuccessfulLogin(""));
        assertEquals("SuccessfulLogin",erhalteneMessage);

    }
}
