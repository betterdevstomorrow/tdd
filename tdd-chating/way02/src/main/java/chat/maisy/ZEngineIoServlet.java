//package chat.maisy;
//
//import java.io.IOException;
//
////https://archive.apache.org/dist/tomcat/tomcat-8/v8.0.9/bin/
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import io.socket.emitter.Emitter;
//import io.socket.engineio.parser.Packet;
//import io.socket.engineio.server.EngineIoServer;
//import io.socket.engineio.server.EngineIoSocket;
//
//@WebServlet("/engine.io/*")
//public class ZEngineIoServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -6343896955886657685L;
//
//	public static void main(String[] args) {
//		System.out.println("AAAAAAAAAa");
//	}
//
//	private final EngineIoServer mEngineIoServer = new EngineIoServer();
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		mEngineIoServer.handleRequest(request, response);
//		mEngineIoServer.on("connection", new Emitter.Listener() {
//			@Override
//			public void call(Object... args) {
//				EngineIoSocket socket = (EngineIoSocket) args[0];
//				// Do something with socket
//
//				socket.send(new Packet<>(Packet.MESSAGE, "foo"));
//
//				socket.on("message", new Emitter.Listener() {
//					@Override
//					public void call(Object... args) {
//						Object message = args[0];
//						System.out.println(message);
//						// message can be either String or byte[]
//						// Do something with message.
//					}
//				});
//
//			}
//		});
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html;charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		out.println("<html>" + "<body>" + "<h1>서블릿 간단 작성 예제입니다. </h1> " + "</body>" + "</html>");
//	}
//
//}