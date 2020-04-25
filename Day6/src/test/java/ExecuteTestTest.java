import entity.Result;
import people.worker.*;
import entity.test.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
public class ExecuteTestTest {

    private Engineer engineer;
    private entity.test.Test test;
    private int skill;
    private Result expected;

    public ExecuteTestTest(Engineer engineer, entity.test.Test test, int skill, Result expected){
        this.engineer = engineer;
        this.skill = skill;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new ManualEngineer(), new ManualTest(TestLevel.UNIT, 10), 10, Result.PASSED},
                {new ManualEngineer(), new ManualTest(TestLevel.API, 0), 1, Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.GUI, 0), 10, Result.PASSED},
                {new ManualEngineer(), new AutomatedTest(TestLevel.UNIT, 11), 10, Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.API, 11), 10, Result.PASSED},
                {new ManualEngineer(), new AutomatedTest(TestLevel.GUI, 10), 1, Result.FAILED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.GUI, 1), 1, Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.API, 10), 1, Result.FAILED},
                {new ManualEngineer(), new ManualTest(TestLevel.GUI, 1), 10, Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.UNIT, 1), 10, Result.PASSED},
                {new AutomationEngineer(), new ManualTest(TestLevel.GUI, 11), 10, Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.UNIT, 0), 1, Result.PASSED},
                {new ManualEngineer(), new ManualTest(TestLevel.UNIT, 11), 10, Result.PASSED},
                {new ManualEngineer(), new AutomatedTest(TestLevel.API, 0), 10, Result.PASSED},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.GUI, 10), 1, Result.FAILED},
                {new ManualEngineer(), new AutomatedTest(TestLevel.API, 1), 10, Result.PASSED},
        });
    }

    private static final String MESSAGE = "Test execution for %s by %s Anxiety %s is not correct!";

    @Test
    public void MethodTesting (){
        engineer.setSkill(skill);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                engineer.getClass().getSimpleName(), engineer.getAnxiety()),
                expected, engineer.executeTest(test));
    }
}
