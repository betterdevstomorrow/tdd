package unit;

import entitiy.CreateCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.HttpRequest;

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

        @Test
        public void testExecuteWithMock() {

        }
    }

    public static class testWithoutMock {
        @Test
        public void testExecuteWithoutMock() {
            CreateCommand createCommand = new CreateCommand();
        }
    }
}
