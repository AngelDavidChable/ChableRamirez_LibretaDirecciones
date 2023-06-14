// Clase AddressBook
package address_data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    public List<AddressEntry> searchByLastName(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    public List<AddressEntry> getAllEntries() {
        List<AddressEntry> allEntries = new ArrayList<>(entries);
        Collections.sort(allEntries, (entry1, entry2) -> entry1.getLastName().compareToIgnoreCase(entry2.getLastName()));
        return allEntries;
    }
}
