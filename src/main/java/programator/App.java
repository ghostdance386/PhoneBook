package programator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) {

        File directory = new File("src/directorytest.txt");
        File find = new File("src/find.txt");

        Map<String, String> phoneBook = new TreeMap<>(Comparator.naturalOrder());
        List<String> namesToFind = new ArrayList<>();

        long startTime;
        long endTime;

        writeDataToPhoneBook(directory, phoneBook);
        writeDataToFind(find, namesToFind);

        String[] phoneBookNamesSorted = phoneBook.keySet().toArray(new String[phoneBook.size()]);

        String temp;

        for (int i = 0; i < phoneBookNamesSorted.length; i++) {
            for (int j = i + 1; j < phoneBookNamesSorted.length; j++) {
                if (phoneBookNamesSorted[i].compareTo(phoneBookNamesSorted[j]) < 0) {
                    temp = phoneBookNamesSorted[i];
                    phoneBookNamesSorted[i] = phoneBookNamesSorted[j];
                    phoneBookNamesSorted[j] = temp;
                }
            }
        }
        Map<String, String> phoneBookBubbleSorted = new TreeMap<>();
        for (String name : phoneBookNamesSorted) {
            phoneBookBubbleSorted.put(name, phoneBook.get(name));
        }
        System.out.println(phoneBookBubbleSorted);

        System.out.println("Start searching");
        startTime = System.currentTimeMillis();
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
        long seconds = (endTime - startTime) / 1000 - (minute * 60);
        long milliseconds = (endTime - startTime) - (seconds * 1000) - (minute * 60);
        System.out.println("Found " + foundCount + "/" + searchesCount + " .Time taken: " + minute + "min. " + seconds + "sec. " + milliseconds + "ms.");

    }

    private static void writeDataToPhoneBook(File directory, Map<String, String> phoneBook) {
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
    }

    private static void writeDataToFind(File find, List<String> namesToFind) {
        try (Scanner scannerFind = new Scanner(find)) {
            while (scannerFind.hasNextLine()) {
                namesToFind.add(scannerFind.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
