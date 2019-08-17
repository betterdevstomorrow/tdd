package chat.maisy;
// package chat.maisy;

// import java.net.URISyntaxException;

// import org.json.JSONException;
// import org.json.JSONObject;

// import io.socket.client.IO;
// import io.socket.client.Socket;
// import io.socket.emitter.Emitter;

// public class Client {

//     private Socket socket;

//     protected void connectSocket() {
//         // 설명의 편의를 위해 onCreate()메서드에 추가하였으나,
//         // 꼭 onCreate() 메서드에 위치할 필요는 없을 것 같습니다.
//         try {
//             socket = IO.socket("http://localhost:3333");
//             socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

//                 @Override
//                 public void call(Object... args) {
//                     socket.emit("foo", "hi");
//                     socket.disconnect();
//                 }

//             }).on("event", new Emitter.Listener() {

//                 @Override
//                 public void call(Object... args) {
//                 }

//             }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

//                 @Override
//                 public void call(Object... args) {
//                 }

//             });
//             socket.connect();

//             // Sending an object
//             JSONObject obj = new JSONObject();
//             try {
//                 obj.put("hello", "server");
//                 obj.put("binary", new byte[42]);
//                 socket.emit("foo", obj);
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }

//         } catch (URISyntaxException e) {
//             e.printStackTrace();
//         }
//     }
// }
