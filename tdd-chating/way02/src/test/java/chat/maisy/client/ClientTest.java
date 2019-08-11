// package chat.maisy.client;

// import static org.junit.Assert.assertEquals;

// import java.io.IOException;

// import org.junit.AfterClass;
// import org.junit.BeforeClass;
// import org.junit.Test;

// import chat.maisy.client.Client;
// import chat.maisy.constant.Status;
// import chat.maisy.server.Server;

// public class ClientTest {
// 	static Server server;
// 	static Client testClient;

// 	@BeforeClass
// 	public static void setUp() throws Exception {
// 		int port = 3333;
// 		server = new Server(port);
// 		server.listen();
// 		testClient = new Client("MK", "localhost", port);
// 		testClient.connect();
// 	}

// 	@Test
// 	public void testReceiveMessageFromServer() throws Exception {
// 		String successMessage = Status.CONNECTED.print();
// 		String msg = testClient.receiveMessage();
// 		assertEquals(successMessage, msg);
// 	}

// 	@Test
// 	public void testSendMessageToServer() throws IOException {
// 		String clientMessage = "Hello Server!";
// 		testClient.sendMessage(clientMessage);
// 		String serverMessage = server.receiveMessage();
// 		assertEquals(clientMessage, serverMessage);
// 	}

// 	@AfterClass
// 	public static void closeClientAndServer() throws IOException {
// 		testClient.close();
// 		server.close();
// 	}
// }