package chat.maisy;

public class TempLogger {
    private String fileName = "";

    public TempLogger(Class class1) {
        fileName = class1.getName();
    }

    public void info(String msg) {
        System.out.println("[" + fileName + "] " + msg);
    }
}