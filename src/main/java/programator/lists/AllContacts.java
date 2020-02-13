package programator.lists;

import lombok.Getter;
import programator.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class AllContacts {

    private final List<Person> listAllContacts = new ArrayList<>();
    private final File directory = new File(this.getClass().getClassLoader().getResource("directory.txt").getFile());

    public List<Person> createListAllContacts() {
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String[] contact = scanner.nextLine().split("\\s", 2);
                if (contact.length >= 2) {
                    Person person = new Person();
                    person.setName(contact[1]);
                    person.setPhoneNumber(contact[0]);
                    listAllContacts.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listAllContacts;
    }
}