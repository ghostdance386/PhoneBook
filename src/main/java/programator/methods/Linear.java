package programator.methods;

import org.springframework.stereotype.Component;
import programator.lists.AllContacts;
import programator.lists.ContactsToFind;
import programator.search.Search;
import programator.time.Timer;

@Component
public class Linear {

    private final Search search = new Search();
    private final AllContacts allContacts = new AllContacts();
    private final ContactsToFind contactsToFind = new ContactsToFind();

    public String perform() {
        long startTime = System.currentTimeMillis();

        search.linearSearch(allContacts.createListAllContacts(), contactsToFind.createListContactsToFind());

        long endTime = System.currentTimeMillis();
        return "Time taken: " + Timer.timeTaken(startTime, endTime);
    }
}