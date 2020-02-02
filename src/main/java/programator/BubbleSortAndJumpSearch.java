package programator;

public class BubbleSortAndJumpSearch {

    static long startTime;
    static long endTime;

    public static void perform(long linearSearchTime) {
        startTime=System.currentTimeMillis();
        System.out.println("Start bubble sort + jump search");
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(linearSearchTime);
        Search search = new Search();
        if(!Main.brokeFromBubbleSort){
            search.jumpSearch(bubbleSort.getPhoneBook());
        } else {
            search.linearSearch(bubbleSort.getPhoneBook());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: "+ Timer.timeTaken(startTime,endTime));
        System.out.print("Sorting time: "+Timer.timeTaken(startTime,bubbleSort.getEndTime()));
        if (Main.brokeFromBubbleSort) {
            System.out.println("- STOPPED, moved to linear search");
        }
        System.out.println("Searching time: "+Timer.timeTaken(search.getStartTime(),endTime));
    }
}
