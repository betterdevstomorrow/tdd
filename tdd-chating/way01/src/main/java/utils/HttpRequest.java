package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class HttpRequest {
    public HttpRequest() {

    }

    public JsonNode get(String urlStr, Map<String, Object> params) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlStr);
        addParams(builder, params);

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response.getBody());
    }

    public URL getUrl(String urlStr) throws MalformedURLException {
        return new URL(urlStr);
    }

    public void addParams(UriComponentsBuilder builder, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return ;
        }

        Map.Entry<?, ?> entry;
        Iterator<?> iterator = params.entrySet().iterator();
        entry = (Map.Entry<?, ?>) iterator.next();
        builder.queryParam(entry.getKey().toString(), entry.getValue());

        while (iterator.hasNext()) {
            entry = (Map.Entry<?, ?>) iterator.next();
            builder.queryParam(entry.getKey().toString(), entry.getValue());
        }
    }
}
