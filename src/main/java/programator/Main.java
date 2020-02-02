package programator;

public class Main {

    public static boolean brokeFromBubbleSort;

    public static void main(String[] args) {

        LinearSearch.perform();
        System.out.println();
        BubbleSortAndJumpSearch.perform(LinearSearch.getLinearSearchTime());
        System.out.println();
        QuickSortAndBinarySearch.perform();
        System.out.println();
        HashTable.perform();


    }




}
