package programator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NamesToFindList {

    private List<String> namesToFind = new ArrayList<>();
    private File find = new File(this.getClass().getClassLoader().getResource("find.txt").getFile());

    public List<String> create() {
        try (Scanner scanner = new Scanner(find)) {
            while (scanner.hasNextLine()) {
                namesToFind.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return namesToFind;
    }
}
