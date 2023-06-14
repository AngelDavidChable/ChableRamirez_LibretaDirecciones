import address_data.AddressEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

    public class AddressEntryTest {
        private AddressEntry entry;

        @BeforeEach
        public void setUp() {
            entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State",
                    "12345", "john@example.com", "1234567890");
        }

        @Test
        public void testGetters() {
            Assertions.assertEquals("John", entry.getFirstName());
            Assertions.assertEquals("Doe", entry.getLastName());
            Assertions.assertEquals("123 Main St", entry.getStreet());
            Assertions.assertEquals("City", entry.getCity());
            Assertions.assertEquals("State", entry.getState());
            Assertions.assertEquals("12345", entry.getPostalCode());
            Assertions.assertEquals("john@example.com", entry.getEmail());
            Assertions.assertEquals("1234567890", entry.getPhoneNumber());
        }

        @Test
        public void testToString() {
            String expected = "Name: John Doe\n" +
                    "Address: 123 Main St, City, State, 12345\n" +
                    "Email: john@example.com\n" +
                    "Phone: 1234567890";

            Assertions.assertEquals(expected, entry.toString());
        }
    }