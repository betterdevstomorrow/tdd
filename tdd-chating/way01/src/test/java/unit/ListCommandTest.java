package unit;

import command.ListCommand;

import entity.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(Enclosed.class)
public class ListCommandTest {

    public static class testWithMock {
        @Mock
        private HttpRequest httpReqeust;

        @InjectMocks
        private ListCommand listCommand;

        @Before
        public void initialize() {
            System.out.println("initialized");
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testExecuteWithMock() {
            List<Room> rooms = Arrays.asList(new Room("1", "a"), new Room("2", "b"));
            when(httpReqeust.getRoomList()).thenReturn(rooms);

            List<Room> result = listCommand.execute();
            assertThat(result, isA(List.class));
            assertThat(result.size(), equalTo(2));
            assertThat(result, hasItem(anyOf(hasProperty("id", equalTo("1")))));
            assertThat(result, hasItem(anyOf(hasProperty("id", equalTo("2")))));
        }
    }

    public static class testWithoutMock {
        @Test
        public void testExecuteWithoutMock() {
            ListCommand listCommand = new ListCommand();
            List<Room> result = listCommand.execute();
            assertThat(result, isA(List.class));
            assertThat(result.size(), equalTo(2));
            assertThat(result, hasItem(anyOf(hasProperty("id", equalTo("YNPxHSShQa7UAR9qntt9")))));
            assertThat(result, hasItem(anyOf(hasProperty("id", equalTo("lesJrL6xS5e5aRk77u0s")))));
        }
    }
}
