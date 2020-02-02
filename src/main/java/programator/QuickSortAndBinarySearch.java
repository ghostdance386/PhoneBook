package programator;

public class QuickSortAndBinarySearch {

    static long startTime;
    static long endTime;

    public static void perform() {
        startTime = System.currentTimeMillis();
        System.out.println("Start quick sort + binary search");
        PhoneBook phoneBook = new PhoneBook();
        QuickSort quickSort = new QuickSort();
        Search search = new Search();
        quickSort.quickSort(phoneBook.create(), 0, phoneBook.getPhoneBook().size() - 1);
        quickSort.setEndTime(System.currentTimeMillis());
        search.binarySearch(quickSort.getPhoneBook());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, endTime));
        System.out.println("Sorting time: " + Timer.timeTaken(startTime, quickSort.getEndTime()));
        System.out.println("Searching time: " + Timer.timeTaken(search.getStartTime(), endTime));
    }
}
