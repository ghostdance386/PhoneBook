package programator;

import java.util.Hashtable;

public class HashTable {

    private final Search search = new Search();
    private final Hashtable<String, String> hashtable = new Hashtable<>();
    private final NamesToFindList namesToFindList = new NamesToFindList();
    private final PhoneBook phoneBook = new PhoneBook();

    public void perform() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching (hash table)");

        fillHashtable();
        search.hashTableSearch(hashtable, namesToFindList.create());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, search.getEndTime()));
        System.out.println("Creating time: " + Timer.timeTaken(startTime, endTime));
    }

    private void fillHashtable() {
        phoneBook.create();
        for (Person person : phoneBook.getPhoneBook()) {
            hashtable.put(person.getName(), person.getPhoneNumber());
        }
    }
}
