import entity.test.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class InstabilityTest {

    private static final String MSG = "Instability is not as expected";
    private entity.test.Test test;
    private int expected;

    public InstabilityTest(Test test, int expected) {
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                {new ManualTest(TestLevel.UNIT, 0), 1},
                {new ManualTest(TestLevel.API, 1), 1},
                {new AutomatedTest(TestLevel.API, 10), 10},
                {new AutomatedTest(TestLevel.GUI, 11), 10},
        });
    }

    @org.junit.Test
    public void verifyInstability() {
        assertEquals(MSG, expected, test.getInstability());
    }

}
