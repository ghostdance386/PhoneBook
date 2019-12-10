package programator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    static boolean brokeFromBubbleSort = false;
    static Map<String, String> phoneBook = new TreeMap<>();
    static List<String> namesToFind = new ArrayList<>();
    static long startTimeLinear;
    static long endTimeLinear;
    static long startTimeSorting;
    static long midTimeSorting;
    static long endTimeSorting;
    static long startTimeSearching;
    static long endTimeSearching;

    public static void main(String[] args) {

        File directory = new File("src/directory.txt");
        File find = new File("src/find.txt");
//        File phoneBookOutput = new File("src/phonebookoutput_small.txt");           // do zapisywania posortowanych danych do pliku

        startTimeLinear = System.currentTimeMillis();
        putDataToPhoneBookMap(directory, phoneBook);
        putDataToFindList(find, namesToFind);
        System.out.println("Start linear search");
        linearSearch(phoneBook, namesToFind);
        endTimeLinear = System.currentTimeMillis();
        System.out.println(timeTaken(startTimeLinear, endTimeLinear));

        System.out.println("Start bubble sort + jump search");
        startTimeSorting = System.currentTimeMillis();
        Map<String, String> phoneBookBubbleSorted = bubbleSortThePhoneBook(phoneBook);
        endTimeSorting = System.currentTimeMillis();
        if (!brokeFromBubbleSort) {
            startTimeSearching = System.currentTimeMillis();
            jumpSearch(phoneBookBubbleSorted, namesToFind);
            endTimeSearching = System.currentTimeMillis();
        } else {
            startTimeSearching = System.currentTimeMillis();
            linearSearch(phoneBookBubbleSorted, namesToFind);
            endTimeSearching = System.currentTimeMillis();
        }
        System.out.println(timeTaken(startTimeSorting, endTimeSearching));
        System.out.print("Sorting time: " + timeTaken(startTimeSorting, endTimeSorting));
        if (brokeFromBubbleSort) {
            System.out.println("- STOPPED, moved to linear search");
        }
        System.out.println("Searching time: " + timeTaken(startTimeSearching, endTimeSearching));


//        writeSortedMapToFile(phoneBookBubbleSorted, phoneBookOutput); // do zapisywania posortowanych danych do pliku

    }

    private static void putDataToPhoneBookMap(File directory, Map<String, String> phoneBook) {
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

    private static void putDataToFindList(File find, List<String> namesToFind) {
        try (Scanner scannerFind = new Scanner(find)) {
            while (scannerFind.hasNextLine()) {
                namesToFind.add(scannerFind.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String[] createArrayFromMap(Map<String, String> phoneBook) {
        Set<Map.Entry<String, String>> phoneBookSet = phoneBook.entrySet();
        Iterator<Map.Entry<String, String>> iterator = phoneBookSet.iterator();
        String[] phoneBookSorted = new String[phoneBook.size()];
        for (int i = 0; i < phoneBookSorted.length; i++) {
            phoneBookSorted[i] = iterator.next().toString();
        }
        return phoneBookSorted;
    }

    private static Map<String, String> bubbleSortThePhoneBook(Map<String, String> phoneBook) {
        String[] phoneBookSorted = createArrayFromMap(phoneBook);
        String temp;

        for (int i = 0; i < phoneBookSorted.length; i++) {
            midTimeSorting = System.currentTimeMillis();
            if (midTimeSorting - startTimeSorting > 10 * (endTimeLinear - startTimeLinear)) {
                brokeFromBubbleSort = true;
                break;
            }
            for (int j = i + 1; j < phoneBookSorted.length; j++) {
                if (phoneBookSorted[i].compareTo(phoneBookSorted[j]) < 0) {
                    temp = phoneBookSorted[i];
                    phoneBookSorted[i] = phoneBookSorted[j];
                    phoneBookSorted[j] = temp;
                }
            }
        }

        Map<String, String> phoneBookBubbleSorted = new TreeMap<>();
        for (String name : phoneBookSorted) {
            String[] splittedEntry = name.split("=");
            phoneBookBubbleSorted.put(splittedEntry[0], splittedEntry[1]);
        }


        return phoneBookBubbleSorted;
    }

    private static void writeSortedMapToFile(Map<String, String> phoneBookBubbleSorted, File phoneBookOutput) {
        String[] phoneBookSorted = createArrayFromMap(phoneBookBubbleSorted);

        try (FileWriter writer = new FileWriter(phoneBookOutput)) {
            for (String s : phoneBookSorted) {
                String[] splittedEntry = s.split("=");
                writer.write(splittedEntry[1] + " " + splittedEntry[0] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void linearSearch(Map<String, String> phoneBook, List<String> namesToFind) {
        int foundCount = 0;
        int searchesCount = namesToFind.size();
        for (String name : namesToFind) {
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name);
                foundCount++;
            }
        }
        System.out.println("Found: " + foundCount + "/" + searchesCount);
    }

    public static void jumpSearch(Map<String, String> phoneBook, List<String> namesToFind) {
        String[] phoneBookNamesSorted = phoneBook.keySet().toArray(new String[0]);

        int foundCount = 0;
        int searchesCount = namesToFind.size();
        for (String name : namesToFind) {


            int currentRight = 0;
            int prevRight = 0;

            if (phoneBookNamesSorted.length == 0) {
                break;
            }

            if (phoneBookNamesSorted[currentRight].equals(name)) {
                foundCount++;
                continue;
            }

            int jumpLength = (int) Math.sqrt(phoneBookNamesSorted.length);

            while (currentRight < phoneBookNamesSorted.length - 1) {

                currentRight = Math.min(phoneBookNamesSorted.length - 1, currentRight + jumpLength);

                if (phoneBookNamesSorted[currentRight].compareTo(name) >= 0) {
                    break;
                }
                prevRight = currentRight;
            }

            for (int i = currentRight; i > prevRight; i--) {
                if (phoneBookNamesSorted[i].equals(name)) {
                    foundCount++;
                }
            }
        }
        System.out.println("Found: " + foundCount + "/" + searchesCount);
    }

    private static String timeTaken(long startTime, long endTime) {
        long minute = (endTime - startTime) / 1000 / 60;
        long seconds = (endTime - startTime) / 1000 - (minute * 60);
        long millis = (endTime - startTime) - (seconds * 1000) - (minute * 1000 * 60);
        return "Time taken: " + minute + "min. " + seconds + "sec. " + millis + "ms.";
    }


}