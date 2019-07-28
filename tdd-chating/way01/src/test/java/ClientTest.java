import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ClientTest {
    @Test
    public void testCreateSocket() throws IOException {
        Client client = new Client();
        assertThat(client.createSocket(), is(instanceOf(Socket.class)));
    }
}
