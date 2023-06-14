// Clase Menu
package address;

import address_data.AddressBook;
import address_data.AddressEntry;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    public Menu() {
        addressBook = new AddressBook();
        scanner = new Scanner(System.in);
    }

    public Menu(AddressBook addressBook) {
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("---- Address Book Menu ----");
            System.out.println("1. Load entries from a file");
            System.out.println("2. Add an entry");
            System.out.println("3. Remove an entry");
            System.out.println("4. Search for entries by last name");
            System.out.println("5. Show all entries");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de la entrada del número

            switch (choice) {
                case 1:
                    loadEntriesFromFile();
                    break;
                case 2:
                    addEntry();
                    break;
                case 3:
                    removeEntry();
                    break;
                case 4:
                    searchByLastName();
                    break;
                case 5:
                    showAllEntries();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void loadEntriesFromFile() {
        // Implementa la lógica para cargar las entradas desde un archivo
        System.out.println("Loading entries from a file...");
    }

    private void addEntry() {
        System.out.println("Adding a new entry:");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter street: ");
        String street = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();

        System.out.print("Enter postal code: ");
        String postalCode = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phoneNumber);
        addressBook.addEntry(entry);
        System.out.println("Entry added successfully.");
    }

    private void removeEntry() {
        System.out.print("Enter the last name to search for the entry: ");
        String lastName = scanner.nextLine();

        List<AddressEntry> searchResults = addressBook.searchByLastName(lastName);
        if (searchResults.isEmpty()) {
            System.out.println("No entries found with the last name: " + lastName);
        } else {
            System.out.println("Select the entry to remove:");

            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }

            System.out.print("Enter the index of the entry to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de la entrada del número

            if (index >= 1 && index <= searchResults.size()) {
                AddressEntry entryToRemove = searchResults.get(index - 1);
                addressBook.removeEntry(entryToRemove);
                System.out.println("Entry removed successfully.");
            } else {
                System.out.println("Invalid index. No entry removed.");
            }
        }
    }

    private void searchByLastName() {
        System.out.print("Enter the last name or the starting part of the last name: ");
        String lastName = scanner.nextLine();

        List<AddressEntry> searchResults = addressBook.searchByLastName(lastName);
        if (searchResults.isEmpty()) {
            System.out.println("No entries found with the last name: " + lastName);
        } else {
            System.out.println("Search results:");
            for (AddressEntry entry : searchResults) {
                System.out.println(entry);
                System.out.println();
            }
        }
    }

    private void showAllEntries() {
        List<AddressEntry> entries = addressBook.getAllEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries in the address book.");
        } else {
            System.out.println("All entries:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
                System.out.println();
            }
        }
    }
}
