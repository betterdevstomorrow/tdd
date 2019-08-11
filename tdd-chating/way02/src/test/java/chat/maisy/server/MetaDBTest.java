package chat.maisy.server;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import chat.maisy.entity.Room;

public class MetaDBTest {

	private MetaDB target;
	private ByteArrayOutputStream bout;

	@Before
	public void setup() throws IOException {
		target = new MetaDB();
		bout = new ByteArrayOutputStream();
		System.out.println(target);
		target.init();
	}

	@Test //(Description="My funky test")
		public void testGetRoomList() throws InterruptedException, ExecutionException {
		bout.reset();

		ArrayList<Room> roomList = target.getRoomList();
        System.out.println(roomList);
        assertNotNull("room list is null", roomList);
		// assertTrue(rst.contains("disney"));
		// assertTrue(rst.contains("world"));
		// assertTrue(!rst.contains("nature"));
	}
}