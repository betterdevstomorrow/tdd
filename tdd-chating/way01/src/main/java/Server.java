import com.google.cloud.firestore.Firestore;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Firestore db;

    public static void main(String[] args) throws IOException {
        new Server(12345).run();
    }

    public Server(int port) throws IOException {
        this.port = port;

        connectToFirestore();
    }

    public ServerSocket createServerSocket() throws IOException {
        return new ServerSocket(port);
    }

    public void run() throws IOException {
        ServerSocket server = new ServerSocket(port) {
            protected void finalize() throws IOException {
                this.close();
            }
        };
        System.out.println("Port 12345 is now open.");

        while (true) {
            // accepts a new client
            Socket client = server.accept();
        }
    }

    private void connectToFirestore() throws IOException {
        InputStream serviceAccount = new FileInputStream("src/main/resources/tdd-chatting-248015-20a3c2626211.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();
        this.db = db;
    }

    Firestore getDb() {
        return db;
    }
}
