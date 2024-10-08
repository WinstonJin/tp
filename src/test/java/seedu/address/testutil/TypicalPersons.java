package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_ADMIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_PRESIDENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withTelegram("94351253")
            .withTags("Admin").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withTelegram("98765432")
            .withTags("President", "Marketing").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withTelegram("95352563")
            .withEmail("heinz@example.com")
            .withAddress("wall street")
            .withTags("External Relations")
            .build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withTelegram("87652533")
            .withEmail("cornelia@example.com")
            .withAddress("10th street")
            .withTags("Events (external)")
            .build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withTelegram("9482224")
            .withEmail("werner@example.com")
            .withAddress("michegan ave")
            .withTags("Events (internal)")
            .build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withTelegram("9482427")
            .withEmail("lydia@example.com")
            .withAddress("little tokyo")
            .withTags("Events (external)")
            .build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withTelegram("9482442")
            .withEmail("anna@example.com")
            .withAddress("4th street")
            .withTags("Vice President")
            .build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withTelegram("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withTelegram("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withTelegram(VALID_TELEGRAM_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_ADMIN).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withTelegram(VALID_TELEGRAM_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_PRESIDENT, VALID_TAG_ADMIN)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
