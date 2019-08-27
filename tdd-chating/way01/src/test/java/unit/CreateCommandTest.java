package unit;

import command.CreateCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.CommandParser;
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
            MockitoAnnotations.initMocks(this);
        }

        @Test(expected=Exception.class)
        public void testExecuteWithMock() throws CommandParser.IncorrectCommandException {
            String roomName = "test";
            doThrow(new Exception()).when(httpReqeust).createRoom(roomName);

            createCommand.execute();
        }

    }

    public static class testWithoutMock {
        @Test
        public void testExecuteWithoutMock() throws CommandParser.IncorrectCommandException {
            CreateCommand createCommand = new CreateCommand("/create -n test1 -u user1");
            createCommand.execute();
        }

        @Test(expected = CommandParser.IncorrectCommandException.class)
        public void testExecuteWithWrongParam() throws CommandParser.IncorrectCommandException {
            CreateCommand createCommand = new CreateCommand("/create -u user1");
            createCommand.execute();
        }

    }
}
