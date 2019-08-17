package chat.maisy.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

//https://juyoung-1008.tistory.com/23

public class EchoClientHandler extends SimpleChannelInboundHandler<String> {

	// 초기화
	public EchoClientHandler() {
	}

	// 채널이 활성화 되면 동작할 코드를 정의합니다.
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 메시지를 쓴 후 플러쉬합니다.
		System.out.println("Client channel active");
		System.out.print("> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		ctx.write(line);
		ctx.flush();
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, String msg) {
		if("exit".equals(msg)) {
			ctx.disconnect();
			ctx.close();
		}else{
			System.out.println(msg);
		}
		
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.print("> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		ctx.write(line);
		ctx.flush();
//		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}