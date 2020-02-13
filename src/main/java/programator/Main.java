package programator;

import programator.methods.HashTable;
import programator.methods.Linear;
import programator.methods.QuickSortAndBinary;

public class Main {

    public static void main(String[] args) {
        Linear linear = new Linear();
        QuickSortAndBinary quickSortAndBinary = new QuickSortAndBinary();
        HashTable hashTable = new HashTable();

        linear.perform();
        System.out.println();
        quickSortAndBinary.perform();
        System.out.println();
        hashTable.perform();
    }
}