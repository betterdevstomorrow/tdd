package unit;

import command.ListCommand;
import org.junit.Test;
import utils.CommandParser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

public class CommandParserTest {
    @Test
    public void testSelectListCommand() {
        try {
            String command = "/list";
            assertThat((ListCommand) CommandParser.select(command), isA(ListCommand.class));
        } catch(Exception e) {

        }
    }

    @Test(expected=CommandParser.IncorrectCommandException.class)
    public void testSelectNotSupported() throws CommandParser.IncorrectCommandException {
        String command = "";
        CommandParser.select(command);
    }

    @Test
    public void testParse() {
        assertThat(CommandParser.getRoomName("/create -n bbc -u dog"), equalTo("bbc"));
        assertThat(CommandParser.getUserName("/create -n bbc -u dog"), equalTo("dog"));
    }
}
