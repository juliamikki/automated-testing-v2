package classwork.day4;

import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class PersonTestNG {

    @Test
    public void personAgeTest() {
        Person person = new Person(25);
        assertEquals("Person age is not as expected!", person.getAge(),25);
    }

    @Test
    public void personAgeTestFail() {
        Person person = new Person(30);
        assertEquals("Person age is not as expected!", person.getAge(),25);
    }
}