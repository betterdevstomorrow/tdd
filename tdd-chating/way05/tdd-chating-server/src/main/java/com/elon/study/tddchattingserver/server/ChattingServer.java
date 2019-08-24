package com.elon.study.tddchattingserver.server;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import java.util.Collection;
import java.util.List;

public class ChattingServer {

    private SocketIOServer server;

    public ChattingServer(String hostname, int port) {
        Configuration config = new Configuration();
        config.setHostname(hostname);
        config.setPort(port);

        server = new SocketIOServer(config);
        server.addConnectListener(client -> System.out.println(client.getSessionId() + " is Connected"));
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop();
    }

}
