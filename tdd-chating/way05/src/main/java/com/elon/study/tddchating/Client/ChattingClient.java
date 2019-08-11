package com.elon.study.tddchating.Client;

import com.elon.study.tddchating.Server.ChattingServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChattingClient {

    private Socket socket;
    private String hostname;
    private int port;

    public ChattingClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(hostname, port);
    }

    public void enterServer(ChattingServer server) {
    }

    public void enterChatRoom(Object chatRoom) {
    }

    public void chat(String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    public void exit() {
    }

}
