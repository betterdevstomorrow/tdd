package chat.maisy.server;

public class ServerApp {
	
	public static void main(String[] args) {
		int port = 3333;
		try {
			new Server(port).listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
