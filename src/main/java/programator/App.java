package programator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) {

        File directory = new File("src/directory.txt");
        File find = new File("src/find.txt");

        Map<String, String> phoneBook = new HashMap<>();
        List<String> namesToFind = new ArrayList<>();

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        try (Scanner scannerDirectory = new Scanner(directory)) {
            while (scannerDirectory.hasNextLine()) {
                String[] contact = scannerDirectory.nextLine().split("\\s", 2);
                if (contact.length >= 2) {
                    phoneBook.put(contact[1], contact[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try (Scanner scannerFind = new Scanner(find)) {
            while (scannerFind.hasNextLine()) {
                namesToFind.add(scannerFind.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Start searching");
        int foundCount = 0;
        int searchesCount = namesToFind.size();
        for (String name : namesToFind) {
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name);
                foundCount++;
            }
        }
        endTime = System.currentTimeMillis();
        long minute = (endTime - startTime) / 1000 / 60;
        long seconds = (endTime - startTime) / 1000-(minute*60);
        long milliseconds = (endTime - startTime)-(seconds*1000)-(minute*60);
        System.out.println("Found " + foundCount + "/" + searchesCount + " .Time taken: " + minute + "min. " + seconds + "sec. " + milliseconds + "ms.");

    }

}
