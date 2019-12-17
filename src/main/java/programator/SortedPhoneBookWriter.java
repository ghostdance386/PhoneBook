package programator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SortedPhoneBookWriter {

    public void writeSortedMapToFile(List<Person> phoneBookBubbleSorted) {
        File phoneBookOutput = new File("src/phonebookoutput.txt");

        try (FileWriter writer = new FileWriter(phoneBookOutput)) {
            for (Person person : phoneBookBubbleSorted) {
                writer.write(person.getPhoneNumber() + " " + person.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
