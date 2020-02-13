package programator.methods;

import org.springframework.stereotype.Component;
import programator.lists.AllContacts;
import programator.lists.ContactsToFind;
import programator.search.Search;
import programator.sort.QuickSort;
import programator.time.Timer;

@Component
public class QuickSortAndBinary {

    private final QuickSort quickSort = new QuickSort();
    private final AllContacts allContacts = new AllContacts();
    private final Search search = new Search();
    private final ContactsToFind contactsToFind = new ContactsToFind();

    public String perform() {
        long startTime = System.currentTimeMillis();

        quickSort.quickSort(allContacts.createListAllContacts(), 0, allContacts.getListAllContacts().size() - 1);
        quickSort.setEndTime(System.currentTimeMillis());
        search.binarySearch(quickSort.getPhoneBook(), contactsToFind.createListContactsToFind());

        long endTime = System.currentTimeMillis();
        return "Time taken: " + Timer.timeTaken(startTime, endTime) + " Sorting time: " + Timer.timeTaken(startTime, quickSort.getEndTime());
    }
}