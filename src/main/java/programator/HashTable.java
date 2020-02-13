package programator;

import java.util.Hashtable;

public class HashTable {

    private final PhoneBook phoneBook = new PhoneBook();
    private final Hashtable<String, String> hashtable = new Hashtable<>();
    private final Search search = new Search();

    public void perform() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching (hash table)");

        phoneBook.create();
        for (Person person : phoneBook.getPhoneBook()) {
            hashtable.put(person.getName(), person.getPhoneNumber());
        }

        long endTime = System.currentTimeMillis();
        search.hashTableSearch(hashtable);
        System.out.println("Time taken: " + Timer.timeTaken(startTime, search.getEndTime()));
        System.out.println("Creating time: " + Timer.timeTaken(startTime, endTime));
    }
}
