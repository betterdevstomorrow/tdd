package entity;

public class User {
    private String id = "";
    private UserData data = new UserData();

    public User() {

    }

    public User(String id, String name) {
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

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
