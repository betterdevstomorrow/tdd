package com.elon.study.tddchattingclient.client;

import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;

public class ChattingClient {

    private Socket socket;
    private String hostname;
    private int port;

    public ChattingClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws URISyntaxException {
        String uri = "http://" + hostname + ":" + port;
        socket = IO.socket(uri);
        socket.on(Socket.EVENT_CONNECT, args -> System.out.println("connected"));
        socket.connect();
    }

}
