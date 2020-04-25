package entity.test;

import entity.Result;
import people.worker.*;

import java.util.function.Function;

public abstract class Test implements Function <Engineer, Result> {

    private int complexity;
    private int instability;

    public int getComplexity() {
        return complexity;
    }
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
    public int getInstability() {
        return instability;
    }
    public void setInstability(int instability) {
        this.instability = instability;
    }

    public Test(TestLevel testlevel, int instability) {
        this.complexity = testlevel.COMPLEXITY;

        if (instability <= 0) {
            this.instability =1;
        } else if (instability > 10) {
            this.instability = 10;
        } else this.instability = instability;
    }

   public Result apply (Engineer engineer) {
        int anxiety;

        if (((this instanceof ManualTest) & (engineer instanceof AutomationEngineer)) | ((this instanceof AutomatedTest)&(engineer instanceof ManualEngineer))) {
            anxiety = engineer.getAnxiety();
        } else {
            anxiety = 1;
        }

        int testCompletionRate = (anxiety*complexity*instability)/engineer.getSkill();
        System.out.println(String.format("The test completion rate is: %s",testCompletionRate));

        return testCompletionRate > 30 ?  Result.FAILED : Result.PASSED;

    }
}
