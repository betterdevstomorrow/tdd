package chat.maisy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientApp {
	public static void main(String[] args) {
		String serverHost = "localhost";
		int port = 3333;
		int genId = (int) (Math.random() * 100);
		Client c1 = new Client("user" + genId, serverHost, port);
		try {
			BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
			c1.connect();
			c1.receiveMessage();
			while (true) {

				String line = bw.readLine();
				c1.sendMessage(line);
				if ("quit".equals(line)) {
					break;
				}
			}

			System.out.println("close chatting : user" + genId);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
