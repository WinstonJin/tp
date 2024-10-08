package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TelegramTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Telegram(null));
    }

    @Test
    public void constructor_invalidTelegram_throwsIllegalArgumentException() {
        String invalidTelegram = "";
        assertThrows(IllegalArgumentException.class, () -> new Telegram(invalidTelegram));
    }

    @Test
    public void isValidTelegram() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Telegram.isValidTelegram(null));

        // invalid phone numbers
        assertFalse(Telegram.isValidTelegram("")); // empty string
        assertFalse(Telegram.isValidTelegram(" ")); // spaces only
        assertFalse(Telegram.isValidTelegram("91")); // less than 3 numbers
        assertFalse(Telegram.isValidTelegram("phone")); // non-numeric
        assertFalse(Telegram.isValidTelegram("9011p041")); // alphabets within digits
        assertFalse(Telegram.isValidTelegram("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(Telegram.isValidTelegram("911")); // exactly 3 numbers
        assertTrue(Telegram.isValidTelegram("93121534"));
        assertTrue(Telegram.isValidTelegram("124293842033123")); // long phone numbers
    }

    @Test
    public void equals() {
        Telegram phone = new Telegram("999");

        // same values -> returns true
        assertTrue(phone.equals(new Telegram("999")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different values -> returns false
        assertFalse(phone.equals(new Telegram("995")));
    }
}
