package entitiy;

import com.fasterxml.jackson.databind.JsonNode;
import utils.HttpRequest;

import java.io.IOException;

public class ListCommand implements Command {
    private HttpRequest httpRequest = new HttpRequest();

    @Override
    public String execute() throws IOException {
        JsonNode response = httpRequest.get("https://us-central1-tdd-chatting.cloudfunctions.net/getRooms", null);
        return response.toString();
    }
}
