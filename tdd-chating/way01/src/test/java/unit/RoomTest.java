package unit;

import entitiy.Room;
import entitiy.RoomData;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertThat;

public class RoomTest {
    @Test
    public void createRoomWithoutParams() {
        Room room = new Room();
        assertThat(room, isA(Room.class));
    }

    @Test
    public void createRoomWithParams() {
        String id = "world";
        String name = "hello";

        Room room = new Room(id, name);
        assertThat(room, isA(Room.class));
        assertThat(room, hasProperty("id", equalTo("world")));
        assertThat(room, hasProperty("data", isA(RoomData.class)));
        assertThat(room.getName(), equalTo("hello"));
    }
}
