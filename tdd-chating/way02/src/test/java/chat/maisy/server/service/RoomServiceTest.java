package chat.maisy.server.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import chat.maisy.entity.Room;

public class RoomServiceTest {
	@Test
	public void getRoomTest() {
		RoomService service = new RoomService();
		List<Room> rooms = service.getRoomList();
		Room singleRoom = rooms.get(0);
		assertThat("Is Room Instance", singleRoom, instanceOf(Room.class));
	}
}
