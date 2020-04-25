package classwork.day4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PersonTest {

    @Test
    public void personAgeTest() {
        Person person = new Person(25);
        assertEquals("Person age is not as expected!", person.getAge(), 25);
    }

    @Test
    public void personAgeTestFail() {
        Person person = new Person(30);
        assertEquals("Person age is not as expected!", person.getAge(), 25);
    }
}