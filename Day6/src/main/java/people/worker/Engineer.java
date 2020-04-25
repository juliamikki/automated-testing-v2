package people.worker;


import activity.Inventable;
import activity.Testable;
import entity.*;
import entity.test.Test;
import people.Person;

public abstract class Engineer extends Person implements Inventable, Testable {

    private int skill = (int)(Math.random()*10+1);
    private int anxiety = 3;

    public int getSkill() {
        return skill;
    }
    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public Engineer () {
    }

    public Engineer(int age, String name, String surname) {
        super(age, name, surname);
    }

    public Code inventCode(int hours, int lines) {
        Code code = new Code(lines);
        code.develop(hours);
        return code;
    }

    public Result executeTest(Test test) {
        return test.apply(this);
    }
}
