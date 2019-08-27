package acceptance;

import client.ClientIO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClientIOTest {
    @Test
    public void testConnect() throws InterruptedException {
        ClientIO client = new ClientIO();
        String uri = "http://127.0.0.1:12345";
        client.connect(uri);
        Thread.sleep(5000);
        assertThat(client.isConnected(), equalTo(true));
    }
}
