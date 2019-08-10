package com.elon.study.tddchating;

import com.elon.study.tddchating.Client.ChattingClient;
import com.elon.study.tddchating.Server.ChattingServer;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class ChattingApplicationTest {

    @Test
    @Ignore
    public void chattingApplication() {
        ChattingServer server = new ChattingServer();
        ChattingClient client = new ChattingClient();

        server.start();
        client.start();
        client.enterServer(server);
        List<Object> chatRooms = server.getChatRooms();
        Object chatRoom = null;
        client.enterChatRoom(chatRoom);
        client.chat("message");
        client.exit();
    }

}
