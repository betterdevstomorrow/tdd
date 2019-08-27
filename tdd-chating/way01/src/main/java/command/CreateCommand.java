package command;

import utils.HttpRequest;

public class CreateCommand {
    private HttpRequest httpRequest = new HttpRequest();

    public void execute(String roomName, String userName) {
        httpRequest.createRoom(roomName);
    }
}
