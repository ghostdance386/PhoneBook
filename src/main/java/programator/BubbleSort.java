package programator;

import java.util.LinkedList;
import java.util.List;

public class BubbleSort {

    private long startTime;
    private long endTime;
    private List<Person> phoneBook = new LinkedList<>();

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public List<Person> getPhoneBook() {
        return phoneBook;
    }

    public void bubbleSort() {
        startTime = System.currentTimeMillis();
        PhoneBook phoneBook = new PhoneBook();
        this.phoneBook = phoneBook.create();
        Person temp;
        boolean swapped;

        for (int i = 0; i < this.phoneBook.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < this.phoneBook.size() - i - 1; j++) {
                if (this.phoneBook.get(j).getName().compareTo(this.phoneBook.get(j + 1).getName()) < 0) {
                    temp = this.phoneBook.get(j);
                    this.phoneBook.set(j, this.phoneBook.get(j + 1));
                    this.phoneBook.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(Timer.timeTaken(startTime, endTime));

    }

    public void bubbleSort(long linearSearchTime) {
        startTime = System.currentTimeMillis();
        long midTime;
        PhoneBook phoneBook = new PhoneBook();
        this.phoneBook = phoneBook.create();
        Person temp;
        boolean swapped;

        for (int i = 0; i < this.phoneBook.size() - 1; i++) {
            swapped = false;
            midTime = System.currentTimeMillis();
            if (midTime - startTime > 10 * linearSearchTime) {
                Main.brokeFromBubbleSort = true;
                break;
            }
            for (int j = 0; j < this.phoneBook.size() - i - 1; j++) {
                if (this.phoneBook.get(j).getName().compareTo(this.phoneBook.get(j + 1).getName()) < 0) {
                    temp = this.phoneBook.get(j);
                    this.phoneBook.set(j, this.phoneBook.get(j + 1));
                    this.phoneBook.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        endTime = System.currentTimeMillis();

    }


}
