import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandHelloWorldTest {

    @Test
    public void testSynchronous() {
        assertEquals("Hello World!", new CommandHelloWorld("World").execute());
        assertEquals("Hello Jorge!", new CommandHelloWorld("Jorge").execute());
    }

}