package playgroundutils;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class BaseTest {
    
    static {
        System.setProperty("test", "true");
    }
    
    @Rule
    public final TestWatcher __watcher = new TestWatcher() {

        @Override
        protected void failed(Throwable t, Description description) {
            System.out.println("TEST FAILURE in " + description.getMethodName()
                    + ": " + t.getMessage());
            System.out.println("----------------------------------\n");
        }

        @Override
        protected void finished(Description description) {
            after();
        }

        @Override
        protected void starting(Description description) {
            before();
        }

    };
    
    protected void before() {};
    
    protected void after() {};

}
