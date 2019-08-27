package command;

import entity.Room;
import utils.HttpRequest;
import java.util.List;

public class ListCommand {
    private HttpRequest httpRequest = new HttpRequest();

    public List<Room> execute() {
        return httpRequest.getRoomList();
    }
}
