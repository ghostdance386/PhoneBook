package programator;

public class QuickSortAndBinarySearch {

    private final QuickSort quickSort = new QuickSort();
    private final PhoneBook phoneBook = new PhoneBook();
    private final Search search = new Search();
    private final NamesToFindList namesToFindList = new NamesToFindList();

    public void perform() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start quick sort + binary search");

        quickSort.quickSort(phoneBook.create(), 0, phoneBook.getPhoneBook().size() - 1);
        quickSort.setEndTime(System.currentTimeMillis());
        search.binarySearch(quickSort.getPhoneBook(), namesToFindList.create());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, endTime));
        System.out.println("Sorting time: " + Timer.timeTaken(startTime, quickSort.getEndTime()));
    }
}
