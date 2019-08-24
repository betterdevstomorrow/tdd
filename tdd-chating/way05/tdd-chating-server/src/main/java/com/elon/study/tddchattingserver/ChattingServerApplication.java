package com.elon.study.tddchattingserver;

import com.elon.study.tddchattingserver.server.ChattingServer;

public class ChattingServerApplication {

    public static void main(String[] args) {
        ChattingServer server = new ChattingServer("localhost", 8080);
        server.start();
    }

}
