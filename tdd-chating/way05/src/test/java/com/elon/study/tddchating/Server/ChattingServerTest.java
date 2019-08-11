package com.elon.study.tddchating.Server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
