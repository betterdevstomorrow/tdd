package utils;

import command.CreateCommand;
import command.ListCommand;

public class CommandParser {
    public static class IncorrectCommandException extends Exception {
        public IncorrectCommandException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static Object select(String command) throws IncorrectCommandException {
        if (command.startsWith("/list")) {
            return new ListCommand();
        } else if (command.startsWith("/create")) {
            return new CreateCommand("hello");
        } else if (command.startsWith("/join")) {
            return new ListCommand();
        } else if (command.startsWith("/exit")) {
            return new ListCommand();
        } else if (command.startsWith("/help")) {
            return new ListCommand();
        } else {
            throw new IncorrectCommandException("Unsupported command. please refer to /help");
        }
    }

    private static String parse(String command, String option) {
        String[] strList = command.split(" ");
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].equals(option)) return strList[i + 1];
        }
        return null;
    }

    public static String getUserName(String command) {
        return parse(command, "-u");
    }

    public static String getRoomName(String command) {
        return parse(command, "-n");
    }
}
