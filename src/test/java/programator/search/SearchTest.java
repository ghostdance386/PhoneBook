package programator.search;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programator.model.Person;

import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchTest {

    private Search search;

    @BeforeEach
    public void init() {
        search = new Search();
    }

    @Test
    public void linear_findAllNames() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> linear = Lists.newArrayList(person, person1);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.linearSearch(linear, names);
        assertEquals(2, actual);
    }

    @Test
    public void linear_findOneName_inOneNameList() {
        Person person = new Person();
        person.setName("Jan");
        List<Person> linear = Lists.newArrayList(person);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.linearSearch(linear, names);
        assertEquals(1, actual);
    }

    @Test
    public void linear_findOneName_inTwoNamesList() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> linear = Lists.newArrayList(person, person1);

        List<String> name = Lists.newArrayList("John");

        int actual = search.linearSearch(linear, name);
        assertEquals(1, actual);
    }

    @Test
    public void linear_emptyList_inTwoNamesList() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> linear = Lists.newArrayList(person, person1);

        List<String> name = Lists.newArrayList();

        int actual = search.linearSearch(linear, name);
        assertEquals(0, actual);
    }

    @Test
    public void linear_notFound() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> linear = Lists.newArrayList(person, person1);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.linearSearch(linear, names);
        assertNotEquals(3, actual);
    }

    @Test
    public void binary_findAllNames() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> binary = Lists.newArrayList(person, person1);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.binarySearch(binary, names);
        assertEquals(2, actual);
    }

    @Test
    public void binary_findOneName_inOneNameList() {
        Person person = new Person();
        person.setName("Jan");
        List<Person> binary = Lists.newArrayList(person);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.binarySearch(binary, names);
        assertEquals(1, actual);
    }

    @Test
    public void binary_findOneName_inTwoNamesList() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> binary = Lists.newArrayList(person, person1);

        List<String> name = Lists.newArrayList("John");

        int actual = search.binarySearch(binary, name);
        assertEquals(1, actual);
    }

    @Test
    public void binary_emptyList_inTwoNamesList() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> binary = Lists.newArrayList(person, person1);

        List<String> name = Lists.newArrayList();

        int actual = search.binarySearch(binary, name);
        assertEquals(0, actual);
    }

    @Test
    public void binary_notFound() {
        Person person = new Person();
        Person person1 = new Person();
        person.setName("Jan");
        person1.setName("John");
        List<Person> binary = Lists.newArrayList(person, person1);

        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.binarySearch(binary, names);
        assertNotEquals(3, actual);
    }

    @Test
    public void hashtable_findAllNames() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Jan", "Kowalski");
        hashtable.put("John", "Nowak");
        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.hashTableSearch(hashtable, names);

        assertEquals(2, actual);
    }

    @Test
    public void hashtable_findOneName_inOneNameList() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Jan", "Kowalski");
        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.hashTableSearch(hashtable, names);

        assertEquals(1, actual);
    }

    @Test
    public void hashtable_findOneName_inTwoNamesHashtable() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Jan", "Kowalski");
        hashtable.put("John", "Nowak");
        List<String> names = Lists.newArrayList("Jan");

        int actual = search.hashTableSearch(hashtable, names);
        assertEquals(1, actual);
    }

    @Test
    public void hashtable_emptyList_inTwoNamesHashtable() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Jan", "Kowalski");
        hashtable.put("John", "Nowak");
        List<String> names = Lists.newArrayList();

        int actual = search.hashTableSearch(hashtable, names);
        assertEquals(0, actual);
    }

    @Test
    public void hashTable_notFound() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Jan", "Kowalski");
        hashtable.put("John", "Nowak");
        List<String> names = Lists.newArrayList("Jan", "John");

        int actual = search.hashTableSearch(hashtable, names);

        assertNotEquals(3, actual);
    }
}