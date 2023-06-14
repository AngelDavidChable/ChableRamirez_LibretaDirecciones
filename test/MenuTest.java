import address.Menu;
import address_data.AddressBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MenuTest {
    private Menu menu;
    private ByteArrayOutputStream outputStream;
    private InputStream inputStream;

    @BeforeEach
    public void setUp() {
        AddressBook addressBook = new AddressBook();
        menu = new Menu(addressBook);

        // Redireccionar la salida estándar a un ByteArrayOutputStream
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Establecer el InputStream para las entradas del usuario
        // Aquí puedes simular diferentes entradas del usuario para probar diferentes casos
        inputStream = new ByteArrayInputStream("2\nJohn\nDoe\n123 Main St\nCity\nState\n12345\njohn@example.com\n1234567890\n6\n".getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testAddEntryOption() {
        menu.displayMenu();

        String expectedOutput = "---- Address Book Menu ----\n" +
                "1. Load entries from a file\n" +
                "2. Add an entry\n" +
                "3. Remove an entry\n" +
                "4. Search for entries by last name\n" +
                "5. Show all entries\n" +
                "6. Exit\n" +
                "Enter your choice: \n" +
                "Adding a new entry:\n" +
                "Enter first name: \n" +
                "Enter last name: \n" +
                "Enter street: \n" +
                "Enter city: \n" +
                "Enter state: \n" +
                "Enter postal code: \n" +
                "Enter email: \n" +
                "Enter phone number: \n" +
                "Entry added successfully.\n" +
                "---- Address Book Menu ----\n" +
                "1. Load entries from a file\n" +
                "2. Add an entry\n" +
                "3. Remove an entry\n" +
                "4. Search for entries by last name\n" +
                "5. Show all entries\n" +
                "6. Exit\n" +
                "Enter your choice: \n";

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}
