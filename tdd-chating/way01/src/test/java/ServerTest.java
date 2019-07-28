import com.google.cloud.firestore.Firestore;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class ServerTest {
    @Test
    public void testCreateServerSocket() throws IOException {
        Server server = new Server(12345);
        assertThat(server.createServerSocket(), is(instanceOf(ServerSocket.class)));
        assertThat(server.getDb(), is(instanceOf(Firestore.class)));


    }

//    @Test
//    public void testConnectToFirestore() throws IOException {
//        Server server = new Server(12345);

//    }
}
