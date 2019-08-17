package chat.maisy.server;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import io.netty.channel.embedded.EmbeddedChannel;

public class ServerHandlerTest {
	@Test
	public void echo() {
		String m = "echo test\n";
		String clientId = "embedded";
		ServerHandler sh = new ServerHandler();
		EmbeddedChannel ch = new EmbeddedChannel(sh);
		ch.writeInbound(m);
		String r = ch.readOutbound();
		String exp = sh.getMessage(clientId, m);

		assertThat("응답이 없습니다", r, notNullValue());
		assertThat("수신한 텍스트가 결과로 와야합니다", r, equalTo(exp));
	}

}