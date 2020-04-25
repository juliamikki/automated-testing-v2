package people.worker;

public class ManualEngineer extends Engineer {

    public ManualEngineer() {
        //System.out.println(String.format("I am Manual engineer with \"%s\" skill level", this.getSkill()));
    }

    public ManualEngineer(int age, String name, String surname) {
        super(age, name, surname);
        //System.out.println(String.format("I am Manual engineer with \"%s\" skill level", this.getSkill()));
    }

}
