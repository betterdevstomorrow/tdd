package com.elon.study.tddchattingclient.client;

import org.junit.Before;
import org.junit.Test;

public class ChattingClientTest {

    ChattingClient client;

    @Before
    public void init() throws Exception {
        client = new ChattingClient("localhost", 8080);
    }

    @Test
    public void connect() throws Exception {
        client.connect();
    }

}
