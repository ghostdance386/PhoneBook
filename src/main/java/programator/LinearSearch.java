package programator;

public class LinearSearch {

    private static long linearSearchTime;
    static long startTime;
    static long endTime;

    public static long getLinearSearchTime() {
        return linearSearchTime;
    }

    public static void perform() {
        startTime = System.currentTimeMillis();
        System.out.println("Start linear search");
        Search search = new Search();
        PhoneBook phoneBook = new PhoneBook();
        search.linearSearch(phoneBook.create());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: "+ Timer.timeTaken(startTime,endTime));
        linearSearchTime = search.getEndTime()-search.getStartTime();
    }

}
