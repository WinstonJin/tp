package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ListCommand;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class ListCommandParserTest {
    private static final ListCommandParser parser = new ListCommandParser();

    @Test
    public void parse_success() {
        ListCommand newListCommand = new ListCommand();

        // EP: string with no visible characters
        assertParseSuccess(parser, "", newListCommand);
        assertParseSuccess(parser, "    ", newListCommand);


        // EP: string with parameters input
        String allWord = "all";
        String contactsWord = "contacts";
        String allContactsWord = allWord + contactsWord;

        // normal parameter adding
        assertParseSuccess(parser, allWord, newListCommand);
        assertParseSuccess(parser, contactsWord + "    ", newListCommand);

        // Case insensitivity
        assertParseSuccess(parser, allContactsWord.toUpperCase(), newListCommand);

        // different combination and permutation with spacing
        assertParseSuccess(parser, contactsWord + " " + allWord, newListCommand);
        assertParseSuccess(parser, contactsWord + allWord, newListCommand); // edge case
    }

    @Test
    public void parse_failure() {

        // Some parameters are accepted, some not accepted
        assertParseFailure(parser, "add haha", ListCommand.MESSAGE_WRONG_ARGUMENTS);
        assertParseFailure(parser, "contacts with masters", ListCommand.MESSAGE_WRONG_ARGUMENTS);
    }
}
