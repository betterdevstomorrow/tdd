package chat.maisy.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class JavaClient {
	BufferedWriter bw;
	BufferedReader br;
	Socket socket;
	private String serverHost, id;
	private int serverPort;

	public JavaClient(String userId, String host, int port) {
		this.id = userId;
		this.serverHost = host;
		this.serverPort = port;
	}

	private void print(String message) {
		System.out.println("[" + id + "]" + message);
	}

	public Socket connect() throws IOException {
		socket = new Socket(serverHost, serverPort);
		print("connect to server..");
		return socket;
	}

	public String receiveMessage() throws IOException {
		// Server가 보낸 데이터 출력
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String message = br.readLine();
		print("Message : " + message);
		return message;
	}

	public void sendMessage(String message) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(message);
		bw.newLine();
		bw.flush();
	}

	public void close() throws IOException {
		socket.close();
		if (br != null) {
			br.close();
		}
		if (bw != null) {
			bw.close();
		}
	}
}
