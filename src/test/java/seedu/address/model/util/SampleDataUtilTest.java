package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.util.SampleDataUtil.getTagSet;

import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Nickname;
import seedu.address.model.tag.Role;

public class SampleDataUtilTest {
    private Person[] samplePersons = new Person[] {
        new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Address("Blk 30 Geylang Street 29, #06-40"),
                    getTagSet("President"), new Nickname("")),
        new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getTagSet("President", "Admin"), new Nickname("")),
        new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getTagSet("Marketing"), new Nickname("")),
        new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getTagSet("Admin"), new Nickname("")),
        new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #17-35"),
                    getTagSet("Events (internal)"), new Nickname("")),
        new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"),
                    getTagSet("External Relations"), new Nickname(""))
    };

    @Test
    public void getTagSet_success() {
        Role[] roles = {new Role("Admin"), new Role("Vice President")};

        assertTrue(List.of(roles).containsAll(getTagSet("Admin", "Vice President")));
        assertTrue(List.of(roles).containsAll(getTagSet("Vice President", "Admin")));
        assertTrue(List.of(roles).containsAll(getTagSet("Vice President", "Admin", "Admin")));
    }

    @Test
    public void getSamplePersons_success() {
        assertTrue(List.of(samplePersons).containsAll(List.of(SampleDataUtil.getSamplePersons())));
    }

    @Test
    public void getSampleAddressBook_success() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : samplePersons) {
            sampleAb.addPerson(samplePerson);
        }
        assertEquals(sampleAb, SampleDataUtil.getSampleAddressBook());
    }

}
