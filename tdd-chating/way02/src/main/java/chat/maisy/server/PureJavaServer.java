package chat.maisy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import chat.maisy.constant.Status;

public class PureJavaServer {

	public static void main(String[] args) {
		int port = 3333;
		try {
			new PureJavaServer(port).listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	BufferedWriter bw;

	ServerSocket serverSocket = null;
	Socket socket;

	public PureJavaServer(int port) throws IOException {
		// 서버 생성
		serverSocket = new ServerSocket(port);
		System.out.println("SERVER START: " + port);
	}

	public void listen() throws BindException {
		new Thread(() -> {
			try {
				socket = serverSocket.accept();
				System.out.println("Server listen " + socket);
				sendMessage(Status.CONNECTED.print());
				String line;
				while ((line = receiveMessage()) != null) {
					System.out.println(line);
				}
				System.out.println("[server] closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

	}

	private void sendMessage(String msg) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();
	}

	public void close() throws IOException {
		if (socket != null) {
			socket.close();
		}
		serverSocket.close();
		if (bw != null) {
			bw.close();
		}
		System.out.println("SERVER STOPPED");
	}

	public String receiveMessage() throws IOException {
		// client가 보낸 데이터 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		return br.readLine();
	}

}