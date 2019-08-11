package com.elon.study.tddchating.Server;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.List;

public class ChattingServer {

    private Configuration config;
    private SocketIOServer server;

    public ChattingServer(String hostname, int port) {
        config = new Configuration();
        config.setHostname(hostname);
        config.setPort(port);

        server = new SocketIOServer(config);
    }

    public ChattingServer(Configuration config) {
        this.config = config;
        server = new SocketIOServer(config);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop();
    }

    public List<Object> getChatRooms() {
        return null;
    }

}
