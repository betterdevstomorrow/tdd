package unit;

import client.ClientIO;
import org.junit.Test;

public class ClientIOTest {
    @Test
    public void testConnect() {
        ClientIO client = new ClientIO();
        String uri = "http://127.0.0.1:12345";
        client.connect(uri);
    }

//    @Test
//    public void testCreate() {
//        ClientIO client = new ClientIO();
//        client.create("localhost", 12345);
//    }
}
