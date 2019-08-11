package chat.maisy.server;

import java.net.BindException;

import org.junit.Test;

public class PureJavaServerTest {
	static PureJavaServer server;

	// @Test
	// public void testStart() {
	// try {
	// server = new Server(3333);
	// // assertEquals(ServerSocket.class, server.getServer().getClass());
	// assertNotNull("Failed to generate server", server.getClass());;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	@Test(expected = BindException.class)
	public void bindExceptionTest() throws Exception {
		new PureJavaServer(3331).listen();
		new PureJavaServer(3331).listen();
	}

}
