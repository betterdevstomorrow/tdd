import com.elon.study.tddchattingclient.client.ChattingClient;

public class ChattingClientApplication {

    public static void main(String[] args) {
        try {
            ChattingClient client = new ChattingClient("localhost", 8080);
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
