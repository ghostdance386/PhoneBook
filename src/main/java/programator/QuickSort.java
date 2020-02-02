package programator;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private long startTime;
    private long endTime;
    private List<Person> phoneBook = new ArrayList<>();

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public List<Person> getPhoneBook() {
        return phoneBook;
    }

    public void quickSort(List<Person> phoneBook, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(phoneBook, left, right);
            quickSort(phoneBook, left, pivotIndex - 1);
            quickSort(phoneBook, pivotIndex + 1, right);
        }
        this.phoneBook = phoneBook;
    }

    private int partition(List<Person> phoneBook, int left, int right) {
        Person pivot = phoneBook.get(right);
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (phoneBook.get(i).getName().compareTo(pivot.getName()) < 0) {
                swap(phoneBook, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(phoneBook, partitionIndex, right);

        return partitionIndex;
    }

    private void swap(List<Person> phoneBook, int i, int j) {
        Person temp = phoneBook.get(i);
        phoneBook.set(i,phoneBook.get(j));
        phoneBook.set(j,temp);
    }

}



