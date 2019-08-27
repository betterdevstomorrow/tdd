package entitiy;

import utils.HttpRequest;
import java.util.List;

public class ListCommand implements Command {
    private HttpRequest httpRequest = new HttpRequest();

    @Override
    public List<Room> execute() {
        return httpRequest.getRoomList();
    }
}
