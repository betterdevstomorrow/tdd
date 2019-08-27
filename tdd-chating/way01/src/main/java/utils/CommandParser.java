package utils;

import entitiy.Command;
import entitiy.ListCommand;

public class CommandParser {
    public static Command select(String command) throws IncorrectCommandException {
        if (command.startsWith("/list")) {
            return new ListCommand();
        } else if (command.startsWith("/create")) {
            return new ListCommand();
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

    public static class IncorrectCommandException extends Exception {
        public IncorrectCommandException(String errorMessage) {
            super(errorMessage);
        }
    }
}
