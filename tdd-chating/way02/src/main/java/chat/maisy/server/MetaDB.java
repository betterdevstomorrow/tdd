package chat.maisy.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import chat.maisy.entity.Room;

// https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/firestore/src/main/java/com/example/firestore/Quickstart.java
public class MetaDB {
	ArrayList<Room> roomList;

	private Firestore db;

	public void init() throws IOException {
		// String fileName = "tdd-chatting-mk.json";
		String fileName = "maisy-secret.json";
		String filePath = getClass().getClassLoader().getResource(fileName).getPath();
		InputStream serviceAccount = new FileInputStream(filePath);
		System.out.println(serviceAccount);

		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);

		db = FirestoreClient.getFirestore();
	}

	// Firestore getDb() {
	// return db;
	// }

	public ArrayList<Room> getRoomList() throws InterruptedException, ExecutionException {
		roomList = new ArrayList();
		ApiFuture<QuerySnapshot> query = db.collection("rooms").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			String id = document.getId();
			String name = document.getString("name");
			// System.out.println("Room id " + document.getId());
			// System.out.println("Room name " + document.getString("name"));
			roomList.add(new Room(id, name));
		}
		return roomList;
	}

}
