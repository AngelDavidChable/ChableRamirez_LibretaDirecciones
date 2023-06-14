
import address_data.AddressBook;
import address_data.AddressEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

    public class AddressBookTest {
        private AddressBook addressBook;
        private AddressEntry entry1;
        private AddressEntry entry2;

        @BeforeEach
        public void setUp() {
            addressBook = new AddressBook();
            entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "1234567890");
            entry2 = new AddressEntry("Jane", "Smith", "456 Oak Ave", "Town", "State", "67890", "jane@example.com", "9876543210");
        }

        @Test
        public void testAddEntry() {
            addressBook.addEntry(entry1);
            addressBook.addEntry(entry2);

            List<AddressEntry> entries = addressBook.getAllEntries();
            Assertions.assertEquals(2, entries.size());
            Assertions.assertTrue(entries.contains(entry1));
            Assertions.assertTrue(entries.contains(entry2));
        }

        @Test
        public void testRemoveEntry() {
            addressBook.addEntry(entry1);
            addressBook.addEntry(entry2);

            addressBook.removeEntry(entry1);

            List<AddressEntry> entries = addressBook.getAllEntries();
            Assertions.assertEquals(1, entries.size());
            Assertions.assertFalse(entries.contains(entry1));
            Assertions.assertTrue(entries.contains(entry2));
        }

        @Test
        public void testSearchByLastName() {
            addressBook.addEntry(entry1);
            addressBook.addEntry(entry2);

            List<AddressEntry> results = addressBook.searchByLastName("Doe");
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(entry1, results.get(0));

            results = addressBook.searchByLastName("Smith");
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(entry2, results.get(0));

            results = addressBook.searchByLastName("Johnson");
            Assertions.assertEquals(0, results.size());
        }
    }



