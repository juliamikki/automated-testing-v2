package people.worker;

public class AutomationEngineer extends Engineer {

    public AutomationEngineer() {
       // System.out.println(String.format("I am Automation engineer with \"%s\" skill level", this.getSkill()));
    }

    public AutomationEngineer(int age, String name, String surname) {
        super(age, name, surname);
        //System.out.println(String.format("I am Automation engineer with \"%s\" skill level", this.getSkill()));
    }

}
