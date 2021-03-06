package server;

import com.corundumstudio.socketio.BroadcastAckCallback;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.List;

public class ServerIO {
    private String hostname;
    private int port;

    public ServerIO(String hostname, int port) {
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
        SocketIOServer server = new ServerIO("localhost", 12345).createServer();

        server.addConnectListener(client -> {
            System.out.println(client.getSessionId() + " is Connected");
        });

        server.addEventListener("message", String.class, (client, data, ackSender) ->
                server.getBroadcastOperations().sendEvent("message", data, client, new BroadcastAckCallback(String.class, 1000)));

//        server.addEventListener("command", );

        server.start();
        System.out.println("Server is listening on 12345");
    }
}
