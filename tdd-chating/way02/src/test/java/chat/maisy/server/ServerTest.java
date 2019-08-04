package chat.maisy.server;

import java.io.IOException;
import java.net.BindException;

import org.junit.Test;

public class ServerTest {
	static Server server;

//	@Test
//	public void testStart() {
//		try {
//			server = new Server(3333);
//			// assertEquals(ServerSocket.class, server.getServer().getClass());
//			assertNotNull("Failed to generate server", server.getClass());;
//		} catch (IOException e) {
//			// FIXME: ??
//			e.printStackTrace();
//		}
//	}
	
	@Test(expected = BindException.class)
	public void bindExceptionTest() throws BindException {
		try {
			new Server(3331).listen();
			new Server(3331).listen();
		} catch (BindException be) {
			throw be;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
