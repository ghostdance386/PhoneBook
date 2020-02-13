package programator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import programator.methods.HashTable;
import programator.methods.Linear;
import programator.methods.QuickSortAndBinary;

@RestController
public class PhoneBookController {

    private final Linear linear;
    private final QuickSortAndBinary quickSortAndBinary;
    private final HashTable hashTable;

    public PhoneBookController(Linear linear, QuickSortAndBinary quickSortAndBinary, HashTable hashTable) {
        this.linear = linear;
        this.quickSortAndBinary = quickSortAndBinary;
        this.hashTable = hashTable;
    }

    @GetMapping("/linear")
    public String linear() {
        return "Linear method: " + linear.perform();
    }

    @GetMapping("/binary")
    public String binary() {
        return "Binary method: " + quickSortAndBinary.perform();
    }

    @GetMapping("/hashtable")
    public String hashtable() {
        return "Hashtable method: " + hashTable.perform();
    }
}