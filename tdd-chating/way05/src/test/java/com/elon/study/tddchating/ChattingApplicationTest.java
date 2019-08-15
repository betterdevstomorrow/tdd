package com.elon.study.tddchating;

import com.elon.study.tddchattingclient.client.ChattingClient;
import com.elon.study.tddchattingserver.server.ChattingServer;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class ChattingApplicationTest {

    @Test
    @Ignore
    public void chattingApplication() throws Exception {
        ChattingServer server = new ChattingServer("localhost", 8080);
        ChattingClient client = new ChattingClient("localhost", 8080);
        server.start();
        client.connect();
        client.enterServer(server);
        List<Object> chatRooms = server.getChatRooms();
        Object chatRoom = null;
        client.enterChatRoom(chatRoom);
        client.chat("message");
        client.exit();
        server.stop();
    }

}
