package programator.methods;

import programator.lists.AllContacts;
import programator.lists.ContactsToFind;
import programator.search.Search;
import programator.time.Timer;

public class Linear {

    private final Search search = new Search();
    private final AllContacts allContacts = new AllContacts();
    private final ContactsToFind contactsToFind = new ContactsToFind();

    public void perform() {
        long startTime = System.currentTimeMillis();

        System.out.println("Start linear search");
        search.linearSearch(allContacts.createListAllContacts(), contactsToFind.createListContactsToFind());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, endTime));
    }
}