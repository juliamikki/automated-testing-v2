package entry;

import entity.test.AutomatedTest;
import entity.test.TestLevel;
import people.worker.AutomationEngineer;
import people.worker.ManualEngineer;

public class Main {
    public static void main(String[] args) {


       AutomationEngineer automationEn1 = new AutomationEngineer(30, "John", "Doe");
       ManualEngineer manualEn1 = new ManualEngineer();

       System.out.println();

       AutomatedTest autoTest1 = new AutomatedTest(TestLevel.UNIT, 7);
       AutomatedTest autoTest2 = new AutomatedTest(TestLevel.GUI, 8);

       System.out.println("Result: " + automationEn1.executeTest(autoTest1) + "\n");
       System.out.println("Result: " + manualEn1.executeTest(autoTest2));


    }

}
