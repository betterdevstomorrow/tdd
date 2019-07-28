import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {
    @Test
    public void testReturnHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();

        assertThat(helloWorld.get(), is("hello world!!"));
    }
}
