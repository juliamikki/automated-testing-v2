package hometasks.hometask_day4.unit_test;

import hometasks.hometask_day3.entity.Result;
import hometasks.hometask_day3.entity.test.*;
import hometasks.hometask_day3.people.worker.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EngineerTest {

    private static final String MESSAGE = "Test execution for %s by %s is failed!";

    @Test
    public void checkAutomationEngineerExecutesManualTest () {
        ManualTest manualTest = new ManualTest(TestLevel.GUI,5);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        automationEngineer.setSkill(3);
        assertEquals(String.format(MESSAGE, manualTest.getClass().getSimpleName(), automationEngineer.getClass().getSimpleName()),
                Result.FAILED, automationEngineer.executeTest(manualTest));
    }

    @Test
    public void checkManualEngineerExecutesAutomationTest () {
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.API, 4);
        ManualEngineer manualEngineer = new ManualEngineer();
        manualEngineer.setSkill(5);
        assertEquals(String.format(MESSAGE,automatedTest.getClass().getSimpleName(), manualEngineer.getClass().getSimpleName()),
                Result.PASSED, manualEngineer.executeTest(automatedTest) );
    }

    @Test
    public void checkAutomationEngineerExecutesAutomationTest () {
        AutomationEngineer automationEngineer = new AutomationEngineer();
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.GUI, 6);
        automationEngineer.setSkill(1);
        assertEquals(String.format(MESSAGE, automatedTest.getClass().getSimpleName(), automationEngineer.getClass().getSimpleName()),
                Result.FAILED, automationEngineer.executeTest(automatedTest));
    }

    @Test
    public void checkManualEngineerExecutesManualTest () {
        ManualTest manualTest = new ManualTest(TestLevel.UNIT, 6);
        ManualEngineer manualEngineer = new ManualEngineer();
        manualEngineer.setSkill(1);
        assertEquals(String.format(MESSAGE, manualTest.getClass().getSimpleName(), manualEngineer.getClass().getSimpleName()),
                Result.PASSED, manualEngineer.executeTest(manualTest));
    }



        //true true
       /* @Test
        public void manualTestFailed() {
            ManualTest manualTest = new ManualTest(TestLevel.GUI, 2);
            AutomationEngineer automationEngineer = new AutomationEngineer();
            assertEquals("ManualTest, AutomationEngineer, GUI(9), instability 2, anxiety 3: ", Result.FAILED, manualTest.apply(automationEngineer));
        }


        //false false
        @Test
        public void manualTestPassed() {
            ManualTest manualTest = new ManualTest(TestLevel.UNIT, 4);
            ManualEngineer testEngineer = new ManualEngineer();
            assertEquals("ManualTest, AutomationEngineer, UNIT(1), instability 4, anxiety 3: ", Result.PASSED, manualTest.apply(testEngineer));
        }*/
    }



