package chat.maisy.server;

import chat.maisy.TempLogger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    // Logger logger = LoggerFactory.getLogger(getClass());
    TempLogger logger;

    ServerHandler() {
        logger = new TempLogger(getClass());
    }

    // 채널 입출력 준비 완료 사용자가 들어왔을 때.
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("Channel Active");
    }

    // 채널을 읽을 때 동작할 코드를 정의 합니다.
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String message = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
        logger.info(message);
        ctx.write(msg);
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