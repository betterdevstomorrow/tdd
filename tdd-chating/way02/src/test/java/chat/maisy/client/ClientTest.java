package chat.maisy.client;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import chat.maisy.client.Client;
import chat.maisy.constant.Status;
import chat.maisy.server.Server;

public class ClientTest {
	static Server server;
	static Client testClient;

	@BeforeClass
	public static void setUp() {
		int port = 3333;
		try {
			server = new Server(port);
			server.listen();
			testClient = new Client("MK","localhost", port);
			testClient.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReceiveMessageFromServer() {
		String successMessage = Status.CONNECTED.print();
		try {
			String msg = testClient.receiveMessage();
			assertEquals(successMessage, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSendMessageToServer() {
		try {
			String clientMessage = "Hello Server!";
			testClient.sendMessage(clientMessage);
			String serverMessage = server.receiveMessage();
			assertEquals(clientMessage, serverMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void closeClientAndServer() {
		try {
			testClient.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}