import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class CommandHelloWorldTest {

    @Test
    public void testSynchronous() {
        assertEquals("Hello World!", new CommandHelloWorld("World").execute());
        assertEquals("Hello Jorge!", new CommandHelloWorld("Jorge").execute());
    }

    @Test
    public void testAsynchronous_1() throws Exception {
        assertEquals("Hello World!", new CommandHelloWorld("World").queue().get());
        assertEquals("Hello Bob!", new  CommandHelloWorld("Bob").queue().get());
    }

    @Test
    public void testAsynchronous_2() throws Exception {

        Future<String> fWorld = new CommandHelloWorld("World").queue();
        Future<String> fBob = new CommandHelloWorld("Bob").queue();

        assertEquals("Hello World!", fWorld.get());
        assertEquals("Hello Bob!", fBob.get());
    }

}