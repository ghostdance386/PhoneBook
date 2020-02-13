package programator.search;


import lombok.Getter;
import programator.lists.ContactsToFind;
import programator.model.Person;

import java.util.Hashtable;
import java.util.List;

@Getter
public class Search {

    private final ContactsToFind contactsToFind = new ContactsToFind();
    private long startTime;
    private long endTime;

    public int linearSearch(List<Person> phoneBook, List<String> namesToFind) {
        startTime = System.currentTimeMillis();

        int foundCount = 0;
        int searchesCount = namesToFind.size();

        for (String s : namesToFind) {
            for (Person person : phoneBook) {
                if (person.getName().equals(s)) {
                    foundCount++;
                }
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Found: " + foundCount + "/" + searchesCount);
        return foundCount;
    }

    public int binarySearch(List<Person> phoneBook, List<String> namesToFind) {
        startTime = System.currentTimeMillis();

        int foundCount = 0;
        int searchesCount = namesToFind.size();

        for (String name : namesToFind) {
            int left = 0;
            int right = phoneBook.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (phoneBook.get(mid).getName().equals(name)) {
                    foundCount++;
                    break;
                } else if (phoneBook.get(mid).getName().compareTo(name) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Found: " + foundCount + "/" + searchesCount);
        return foundCount;
    }

    public int hashTableSearch(Hashtable<String, String> phoneBook, List<String> namesToFind) {
        startTime = System.currentTimeMillis();

        int foundCount = 0;
        int searchesCount = namesToFind.size();

        for (String name : namesToFind) {
            if (phoneBook.containsKey(name)) {
                foundCount++;
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Found: " + foundCount + "/" + searchesCount);
        return foundCount;
    }
}