package programator.sort;

import lombok.Getter;
import lombok.Setter;
import programator.model.Person;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class QuickSort {

    private long startTime;
    private long endTime;
    private List<Person> phoneBook = new ArrayList<>();

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
        phoneBook.set(i, phoneBook.get(j));
        phoneBook.set(j, temp);
    }
}