package unit;

import command.CreateCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.HttpRequest;

import static org.mockito.Mockito.doThrow;

@RunWith(Enclosed.class)
public class CreateCommandTest {

    public static class testWithMock {
        @Mock
        private HttpRequest httpReqeust;

        @InjectMocks
        private CreateCommand createCommand;

        @Before
        public void initialize() {
            System.out.println("initialized");
            MockitoAnnotations.initMocks(this);
        }

        @Test(expected=Exception.class)
        public void testExecuteWithMock() {
            String roomName = "test";
            String userName = "user";
            doThrow(new Exception()).when(httpReqeust).createRoom(roomName);

            createCommand.execute(roomName, userName);
        }
    }

    public static class testWithoutMock {
        @Test
        public void testExecuteWithoutMock() {
            CreateCommand createCommand = new CreateCommand();
            String roomName = "test1";
            String userName = "user1";
            createCommand.execute(roomName, userName);
        }
    }
}
