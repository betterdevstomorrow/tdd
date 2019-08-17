package chat.maisy.server;

import java.net.SocketAddress;

import chat.maisy.TempLogger;
import chat.maisy.server.service.RoomService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

//http://wonwoo.ml/index.php/post/553

@Sharable
//class ServerHandler extends ChannelInboundHandlerAdapter {
class ServerHandler extends SimpleChannelInboundHandler<String> {
	private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	RoomService roomService = new RoomService();
	TempLogger logger;

	ServerHandler() {
		logger = new TempLogger(getClass());
	}

	// 채널 입출력 준비 완료 사용자가 들어왔을 때.
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		logger.info("Channel Active");

		Channel incoming = ctx.channel();
		for (Channel channel : channelGroup) {
			channel.writeAndFlush("[Server]-" + incoming.remoteAddress() + " has joined!\n");
		}

//		incoming.write("==== ROOM LIST === ");
//		incoming.write(msg)
//		incoming.write(roomService.getRoomList());
//		incoming.flush();

		channelGroup.add(incoming);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		logger.info("Channel In Active");

		Channel incoming = ctx.channel();
		for (Channel channel : channelGroup) {
			channel.writeAndFlush("[Server]-" + incoming.remoteAddress() + " has left!\n");
		}
		incoming.writeAndFlush("[Server] - left");

		channelGroup.remove(incoming);
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, String message) {
//		System.out.println("server channelRead");

		Channel incoming = ctx.channel();
		SocketAddress clientHost = incoming.remoteAddress();
		String result = getMessage(clientHost.toString(), message);
		System.out.println(result);

		for (Channel channel : channelGroup) {
			if (channel != incoming) {
//				System.out.println("- " + channel.remoteAddress());
				channel.writeAndFlush(result + "\n");
			}
		}

		if ("bye".equals(message.toLowerCase())) {
			System.out.println("[close] " + clientHost);
			ctx.writeAndFlush("exit");
			ctx.disconnect();
			ctx.close();
		}
		ctx.writeAndFlush(result);
	}

	public String getMessage(String clientId, String msg) {
		return "[" + clientId + "] " + msg;
	}

	// 채널 읽는 것을 완료했을 때 동작할 코드를 정의 합니다.
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	// 예외가 발생할 때 동작할 코드를 정의 합니다.
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}