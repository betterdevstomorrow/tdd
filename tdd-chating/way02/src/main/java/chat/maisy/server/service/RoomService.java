package chat.maisy.server.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import chat.maisy.entity.Room;

public class RoomService {
	private final String GET_ROOM_URI = "https://us-central1-tdd-chatting.cloudfunctions.net/getRooms";

	public List<Room> getRoomList() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Room>> response = restTemplate.exchange(GET_ROOM_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Room>>() {
				});
		List<Room> rooms = response.getBody();
		return rooms;
	}
	
}
// 출처: https: // luvstudy.tistory.com/52 [파란하늘의 지식창고]