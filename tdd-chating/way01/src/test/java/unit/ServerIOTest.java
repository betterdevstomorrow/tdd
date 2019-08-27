package unit;

import com.corundumstudio.socketio.SocketIOServer;
import org.junit.Test;
import server.ServerIO;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ServerIOTest {
    @Test
    public void testCreateServer() {
        ServerIO server = new ServerIO("localhost", 12345);
        assertThat(server.createServer(), is(instanceOf(SocketIOServer.class)));
    }
}
