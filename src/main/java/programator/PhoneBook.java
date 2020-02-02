package programator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private List<Person> phoneBook = new ArrayList<>();
    private File directory = new File("src/directory.txt");

    public List<Person> getPhoneBook() {
        return phoneBook;
    }

    public List<Person> create() {
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String[] contact = scanner.nextLine().split("\\s", 2);
                if (contact.length >= 2) {
                    Person person = new Person();
                    person.setName(contact[1]);
                    person.setPhoneNumber(contact[0]);
                    phoneBook.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return phoneBook;
    }

}
