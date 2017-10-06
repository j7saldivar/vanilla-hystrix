import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Execute HystrixCommand by calling the execute() method
 * <code>
 *     String s = new CommandHelloWorld("World").execute();
 * </code>
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
