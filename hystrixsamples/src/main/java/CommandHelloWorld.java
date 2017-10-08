import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Execute HystrixCommand by calling the execute() method
 * <code>
 *     String s = new CommandHelloWorld("World").execute();
 * </code>
 *
 * Call HystrixCommand by executing the queue() method:
 *
 * <code>
 *     Future<String> fs = new CommandHelloWorld("World").queue();
 *     String s = fs.get();
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
