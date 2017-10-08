import org.junit.Test;
import rx.Observable;

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

    @Test
    public void testObservable() throws Exception {

        Observable<String> fWorld = new CommandHelloWorld("World").observe();
        Observable<String> fBob = new CommandHelloWorld("Bob").observe();

        // blocking
        assertEquals("Hello World!", fWorld.toBlocking().single());
        assertEquals("Hello Bob!", fBob.toBlocking().single());

        // non-blocking
        // - this is a verbose anonymous inner-class approach and doesn't do assertions
        fWorld.subscribe(v -> {
            System.out.println("onNext: " + v);
        });

        // non-blocking
        // - also verbose anonymous inner-class
        // - ignore errors and onCompleted signal
        fBob.subscribe(v -> {
            System.out.println("onNext: " + v);
        });
    }

}