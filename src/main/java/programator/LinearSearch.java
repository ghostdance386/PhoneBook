package programator;

public class LinearSearch {

    private final Search search = new Search();
    private final PhoneBook phoneBook = new PhoneBook();
    private final NamesToFindList namesToFindList = new NamesToFindList();

    public void perform() {
        long startTime = System.currentTimeMillis();

        System.out.println("Start linear search");
        search.linearSearch(phoneBook.create(), namesToFindList.create());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + Timer.timeTaken(startTime, endTime));
    }

}
