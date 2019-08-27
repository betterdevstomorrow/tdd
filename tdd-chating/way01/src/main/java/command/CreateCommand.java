package command;

import utils.CommandParser;
import utils.HttpRequest;

public class CreateCommand {
    private HttpRequest httpRequest = new HttpRequest();
    private String roomName;
    private String userName;

    public CreateCommand(String command) {
        if(command != null) {
            roomName = CommandParser.getRoomName(command);
            userName = CommandParser.getUserName(command);
        }
    }

    public void execute() throws CommandParser.IncorrectCommandException {
        if(roomName == null) {
            throw new CommandParser.IncorrectCommandException("Room name");
        }
        httpRequest.createRoom(roomName);
    }
}
