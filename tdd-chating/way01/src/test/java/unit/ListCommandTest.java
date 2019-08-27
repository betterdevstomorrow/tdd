package unit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import entitiy.ListCommand;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.HttpRequest;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class ListCommandTest {
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
    public void testExecute() throws IOException {
        JsonNode jsonNode = new ObjectMapper().createArrayNode();
        ((ArrayNode) jsonNode).addObject();
        when(httpReqeust.get("https://us-central1-tdd-chatting.cloudfunctions.net/getRooms", null)).thenReturn(jsonNode);
        assertThat(listCommand.execute(), is("woo"));
    }
}
