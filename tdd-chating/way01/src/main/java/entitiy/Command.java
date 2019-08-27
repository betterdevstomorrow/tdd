package entitiy;

import java.io.IOException;

public interface Command {
    String execute() throws IOException;
}
