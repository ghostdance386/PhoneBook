package programator.methods;

import programator.lists.AllContacts;
import programator.lists.ContactsToFind;
import programator.model.Person;
import programator.search.Search;
import programator.time.Timer;

import java.util.Hashtable;

public class HashTable {

    private final Search search = new Search();
    private final Hashtable<String, String> hashtable = new Hashtable<>();
    private final ContactsToFind contactsToFind = new ContactsToFind();
    private final AllContacts allContacts = new AllContacts();

    public void perform() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching (hash table)");

        fillHashtable();
        search.hashTableSearch(hashtable, contactsToFind.createListContactsToFind());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, search.getEndTime()));
        System.out.println("Creating time: " + Timer.timeTaken(startTime, endTime));
    }

    private void fillHashtable() {
        allContacts.createListAllContacts();
        for (Person person : allContacts.getListAllContacts()) {
            hashtable.put(person.getName(), person.getPhoneNumber());
        }
    }
}