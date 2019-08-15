package com.elon.study.tddchattingserver.server;

import org.junit.Before;
import org.junit.Test;

public class ChattingServerTest {

    ChattingServer server;

    @Before
    public void init() {
        server = new ChattingServer("localhost", 8080);
    }

    @Test
    public void startAndStop() {
        server.start();
        server.stop();
    }

}
