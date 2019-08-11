package com.elon.study.tddchating.Client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChattingClientTest {

    ChattingClient client;

    @Before
    public void init() throws Exception {
        client = new ChattingClient("localhost", 8080);
        client.connect();
    }

    @Test
    public void connect() throws Exception {
        client.connect();
    }

    @Test
    public void chat() throws Exception {
        client.chat("message");
    }

}
