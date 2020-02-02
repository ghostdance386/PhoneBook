package programator;

import java.util.Hashtable;

public class HashTable {
    static long startTime;
    static long endTime;

    public static void perform() {
        startTime = System.currentTimeMillis();
        System.out.println("Start searching (hash table)");
        Hashtable<String,String> hashtable = new Hashtable<>();
        PhoneBook phoneBook = new PhoneBook();
        Search search = new Search();
        phoneBook.create();
        for (Person person: phoneBook.getPhoneBook()
        ) {
            hashtable.put(person.getName(), person.getPhoneNumber());
        }
        endTime = System.currentTimeMillis();
        search.hashTableSearch(hashtable);
        System.out.println("Time taken: " + Timer.timeTaken(startTime, search.getEndTime()));
        System.out.println("Creating time: " + Timer.timeTaken(startTime, endTime));
        System.out.println("Searching time: " + Timer.timeTaken(search.getStartTime(), search.getEndTime()));
    }
}
