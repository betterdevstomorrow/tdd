import com.corundumstudio.socketio.SocketIOServer;
import org.junit.Test;
import server.ServerNetty;

import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ServerNettyTest {
    @Test
    public void testCreateServer() {
        ServerNetty server = new ServerNetty("localhost", 12345);
        assertThat(server.createServer(), is(instanceOf(SocketIOServer.class)));
    }

    @Test
    public void testGetRooms() {
        ServerNetty server = new ServerNetty("localhost", 12345);
        assertThat(server.getRooms(), instanceOf(List.class));
    }
}
