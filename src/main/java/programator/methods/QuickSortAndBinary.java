package programator.methods;

import programator.lists.AllContacts;
import programator.lists.ContactsToFind;
import programator.search.Search;
import programator.sort.QuickSort;
import programator.time.Timer;

public class QuickSortAndBinary {

    private final QuickSort quickSort = new QuickSort();
    private final AllContacts allContacts = new AllContacts();
    private final Search search = new Search();
    private final ContactsToFind contactsToFind = new ContactsToFind();

    public void perform() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start quick sort + binary search");

        quickSort.quickSort(allContacts.createListAllContacts(), 0, allContacts.getListAllContacts().size() - 1);
        quickSort.setEndTime(System.currentTimeMillis());
        search.binarySearch(quickSort.getPhoneBook(), contactsToFind.createListContactsToFind());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, endTime));
        System.out.println("Sorting time: " + Timer.timeTaken(startTime, quickSort.getEndTime()));
    }
}