package hometasks.hometask_day3.people.worker;


import hometasks.hometask_day3.activity.*;
import hometasks.hometask_day3.entity.Code;
import hometasks.hometask_day3.entity.Result;
import hometasks.hometask_day3.entity.test.Test;
import hometasks.hometask_day3.people.Person;

public abstract class Engineer extends Person implements Inventable, Testable{

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

    @Override
    public Code inventCode(int hours, int lines) {
        Code code = new Code(lines);
        code.develop(hours);
        return code;
    }

    @Override
    public Result executeTest(Test test) {
        return test.apply(this);
    }
}
