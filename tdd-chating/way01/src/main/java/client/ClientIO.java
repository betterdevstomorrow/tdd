package client;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;
import java.util.Scanner;

public class ClientIO {
    private Socket socket;
    private int id;

    public ClientIO() {

    }

    public void connect(String uri) {
        try {
            socket = IO.socket(uri);
            socket.on(Socket.EVENT_CONNECT, onConnect);
            socket.on(Socket.EVENT_ERROR, onError);
            socket.on(Socket.EVENT_DISCONNECT, onDisconnect);
            socket.on("message", onRsvMessage);
            socket.on("id", onRsvId);
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        socket.emit("message",msg);
    }

    public boolean isConnected() {
        return socket.connected();
    }

    private Emitter.Listener onConnect = args -> System.out.println("Connected");
    private Emitter.Listener onError = args -> System.err.println(args[0]);
    private Emitter.Listener onDisconnect = args -> System.out.println("Disconnected");
    private Emitter.Listener onRsvMessage = args -> System.out.println(args[0]);
    private Emitter.Listener onRsvId = args -> {
        this.id = (Integer) args[0];
        System.out.println("My Id is " + this.id);
    };

    public static void main(String[] args) {
        ClientIO clientIO = new ClientIO();
        clientIO.connect("http://localhost:12345");

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            clientIO.sendMessage(sc.nextLine());
        }
        sc.close();
    }
}
