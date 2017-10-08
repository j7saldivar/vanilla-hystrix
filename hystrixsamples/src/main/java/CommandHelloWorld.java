import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Execute HystrixCommand syncronous by calling the execute() method
 * <code>
 *     String s = new CommandHelloWorld("World").execute();
 * </code>
 *
 * Call HystrixCommand asyncronous by executing the queue() method:
 *
 * <code>
 *     Future<String> fs = new CommandHelloWorld("World").queue();
 *     String s = fs.get();
 * </code>
 *
 * Both are equivalent:
 *
 * <code>
 *     String s1 = new CommandHelloWorld("World").execute();
 *     String s2 = new CommandHelloWorld("World").queue().get();
 * </code>
 *
 *
 * @author saldivar
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return String.join("", "Hello ", name, "!");
    }

}
