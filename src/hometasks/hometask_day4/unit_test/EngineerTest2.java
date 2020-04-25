package hometasks.hometask_day4.unit_test;

import hometasks.hometask_day3.entity.Result;
import hometasks.hometask_day3.entity.test.*;
import hometasks.hometask_day3.people.worker.*;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EngineerTest2 {

    private static final String INSTABILITYMESSAGE = "Instability is not as expected";
    private static final String MESSAGE = "Test execution for %s by %s Anxiety %s is not correct!";
    private Engineer testEngineer = new ManualEngineer();
    private Engineer automationEngineer = new AutomationEngineer();

    @Test
    public void verifyZeroInstability() {
        ManualTest test = new ManualTest(TestLevel.UNIT, 0);
        assertEquals(INSTABILITYMESSAGE, 1, test.getInstability());
    }

    @Test
    public void verifyZeroExcludedToTenIncludedInstability() {
        ManualTest test = new ManualTest(TestLevel.API, 10);
        assertEquals(INSTABILITYMESSAGE, 10,test.getInstability());
    }

    @Test
    public void verifyInstabilityAboveTen() {
        ManualTest test = new ManualTest(TestLevel.GUI, 135);
        assertEquals(INSTABILITYMESSAGE, 10, test.getInstability());
    }


    // if1 (true || false) else (not evaluate), if2 (true)
    @Test
    public void verifyExecuteManualTestByAutomationEngineerPassed () {
        ManualTest test = new ManualTest(TestLevel.UNIT, 5);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                Result.PASSED, automationEngineer.executeTest(test));
    }

    //  if1 (true || false) else (not evaluate), if2 (false)
    @Test
    public void verifyExecuteManualTestByAutomationEngineerFailed () {
        if (automationEngineer.getSkill() > 7) automationEngineer.setSkill(7);
        ManualTest test = new ManualTest(TestLevel.GUI, 9);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                automationEngineer.getClass().getSimpleName(), automationEngineer.getAnxiety()),
                Result.FAILED, automationEngineer.executeTest(test));
    }

    // if1 (false || true) else (not evaluate), if2 (true)
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerPassed(){
        if (testEngineer.getSkill()>2) testEngineer.setSkill(2);
         AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
         assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                Result.FAILED, testEngineer.executeTest(test));
    }

    // if1 (false || true) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerFailed() {
        if (testEngineer.getSkill() < 2) testEngineer.setSkill(7);
        AutomatedTest test = new AutomatedTest(TestLevel.API, 8);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                Result.PASSED, testEngineer.executeTest(test));
    }

    // if1 (false || false) else (true), if2 (true);
    @Test
    public void verifyExecuteManualTestByTestEngineerPassed (){
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                Result.PASSED, testEngineer.executeTest(test));
    }

    // if1 (false || false) else (true), if2 (false);
    @Test
    public void verifyExecuteManualTestByTestEngineerFailed (){
        ManualTest test = new ManualTest(TestLevel.GUI, 3);
        assertEquals(String.format(MESSAGE, test.getClass().getSimpleName(),
                testEngineer.getClass().getSimpleName(), testEngineer.getAnxiety()),
                Result.PASSED, testEngineer.executeTest(test));
    }


}
