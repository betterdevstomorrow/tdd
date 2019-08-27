package unit;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Room;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.web.util.UriComponentsBuilder;
import utils.HttpRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class HttpRequestTest {

    @RunWith(Parameterized.class)
    public static class TheParameterizedPart {

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { null }, { "" }, { "wrongUrl" }
            });
        }

        @Parameter
        public String wrongUrl;

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testGetUrl() throws MalformedURLException {
            HttpRequest httpRequest = new HttpRequest();

            thrown.expect(MalformedURLException.class);

            httpRequest.getUrl(wrongUrl);
        }

    }

    public static class NotParameterizedPart {
        private HttpRequest httpRequest;

        @Before
        public void initialize() {
            httpRequest = new HttpRequest();
        }

        @Test
        public void testGet() throws IOException {
            String url = "https://us-central1-tdd-chatting.cloudfunctions.net/getRooms";
            JsonNode response = httpRequest.get(url, null);
            assertThat(response.toString(), equalTo("[{\"id\":\"YNPxHSShQa7UAR9qntt9\",\"data\":{\"name\":\"전승훈\"}},{\"id\":\"lesJrL6xS5e5aRk77u0s\",\"data\":{\"name\":\"no.1\"}}]"));
        }

        @Test
        public void testGetRoomList() {
            List<Room> rooms = httpRequest.getRoomList();
            assertThat(rooms.size(), equalTo(2));
            assertThat(rooms, hasItem(anyOf(hasProperty("id", equalTo("YNPxHSShQa7UAR9qntt9")))));
            assertThat(rooms, hasItem(anyOf(hasProperty("id", equalTo("lesJrL6xS5e5aRk77u0s")))));
        }

        @Test
        public void testAddParamsWithNoParams() {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://www.google.com/search");
            httpRequest.addParams(builder, null);
            assertThat(builder.toUriString(), equalTo("http://www.google.com/search"));

            Map<String, Object> params = new HashMap<>();
            httpRequest.addParams(builder, params);
            assertThat(builder.toUriString(), equalTo("http://www.google.com/search"));
        }

        @Test
        public void testAddParamsWithParams() {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://www.google.com/search");
            Map<String, Object> params = new HashMap<>();
            params.put("q", "hello");
            params.put("s", 1);

            httpRequest.addParams(builder, params);
            assertThat(builder.toUriString(), equalTo("http://www.google.com/search?q=hello&s=1"));
        }
    }
}
