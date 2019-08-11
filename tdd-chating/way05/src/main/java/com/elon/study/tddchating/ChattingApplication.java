package com.elon.study.tddchating;

import com.elon.study.tddchating.Server.ChattingServer;

public class ChattingApplication {

    public static void main(String[] args) {
        ChattingServer server = new ChattingServer("localhost", 8080);
        server.start();
    }

}
