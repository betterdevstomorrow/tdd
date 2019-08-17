package server;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.List;

public class ServerNetty {
    private String hostname;
    private int port;

    public ServerNetty(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public SocketIOServer createServer() {
        Configuration config = new Configuration();
        config.setHostname(this.hostname);
        config.setPort(this.port);
        final SocketIOServer server = new SocketIOServer(config);

        return server;
    }

    public static void main(String[] args) {
        SocketIOServer server = new ServerNetty("localhost", 12346).createServer();
        server.start();
        System.out.println("Server is listening on 12345");
    }

    public List getRooms() {
        return null;
    }
}
