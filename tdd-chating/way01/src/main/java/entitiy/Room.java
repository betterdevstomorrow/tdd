package entitiy;

public class Room {
    private String id = "";
    private RoomData data = new RoomData();

    public Room() {

    }

    public Room(String id, String name) {
        this.id = id;
        data.setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return data.getName();
    }

    public void setName(String name) {
        data.setName(name);
    }

    public RoomData getData() {
        return data;
    }

    public void setData(RoomData data) {
        this.data = data;
    }
}
