package programator;


import java.util.List;

public class Search {

    private long startTime;

    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void linearSearch(List<Person> phoneBook) {
        startTime = System.currentTimeMillis();
        NamesToFindList namesToFindList = new NamesToFindList();
        List<String> namesToFind = namesToFindList.create();

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
    }

    public void jumpSearch(List<Person> phoneBook) {
        startTime = System.currentTimeMillis();
        NamesToFindList namesToFindList = new NamesToFindList();
        List<String> namesToFind = namesToFindList.create();
        int foundCount = 0;
        int searchesCount = namesToFind.size();
        for (String name : namesToFind) {

            int currentRight = 0;
            int prevRight = 0;

            if (phoneBook.size() == 0) {
                break;
            }

            if (phoneBook.get(currentRight).getName().equals(name)) {
                foundCount++;
                continue;
            }

            int jumpLength = (int) Math.sqrt(phoneBook.size());

            while (currentRight < phoneBook.size() - 1) {

                currentRight = Math.min(phoneBook.size() - 1, currentRight + jumpLength);

                if (phoneBook.get(currentRight).getName().compareTo(name) >= 0) {
                    break;
                }
                prevRight = currentRight;
            }

            for (int i = currentRight; i > prevRight; i--) {
                if (phoneBook.get(i).getName().equals(name)) {
                    foundCount++;
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Found: " + foundCount + "/" + searchesCount);
    }

    public void binarySearch(List<Person> phoneBook) {
        startTime = System.currentTimeMillis();
        NamesToFindList namesToFindList = new NamesToFindList();
        List<String> namesToFind = namesToFindList.create();
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
    }
}
