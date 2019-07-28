import java.io.IOException;
import java.net.Socket;

public class Client {
    private String host = "127.0.0.1";
    private int port = 12345;

    public Socket createSocket() throws IOException {
        return new Socket(host, port);
    }
}
