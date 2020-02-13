package programator;

public class Main {

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        QuickSortAndBinarySearch quickSortAndBinarySearch = new QuickSortAndBinarySearch();
        HashTable hashTable = new HashTable();

        linearSearch.perform();
        System.out.println();
        quickSortAndBinarySearch.perform();
        System.out.println();
        hashTable.perform();
    }
}
