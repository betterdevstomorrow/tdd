//package chat.maisy;
//
//import java.net.URISyntaxException;
//
//import io.socket.emitter.Emitter;
//import io.socket.engineio.client.Socket;
//import io.socket.engineio.server.EngineIoSocket;
//
//public class ZEngineIoClient {
//
//    private EngineIoSocket socket;
//
//    public void connect() throws URISyntaxException {
////        socket = new Socket("ws://localhost:3333");
////        socket.on(Socket.EVENT_OPEN, new Emitter.Listener() {
////            @Override
////            public void call(Object... args) {
////                socket.send("hi");
////                socket.close();
////            }
////        });
////        socket.open();
//    	
//    	socket.on("message", new Emitter.Listener() {
//    	    @Override
//    	    public void call(Object... args) {
//    	        Object message = args[0];
//    	        // message can be either String or byte[]
//    	        // Do something with message.
//    	    }
//    	});
//
//    }
//}