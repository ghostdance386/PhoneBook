package programator.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsToFind {

    private List<String> listContactsToFind = new ArrayList<>();
    private File find = new File(this.getClass().getClassLoader().getResource("find.txt").getFile());

    public List<String> createListContactsToFind() {
        try (Scanner scanner = new Scanner(find)) {
            while (scanner.hasNextLine()) {
                listContactsToFind.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listContactsToFind;
    }
}