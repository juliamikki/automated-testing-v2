package people;


import activity.Speakable;

public class Human implements Speakable {

    public Human() {
    }

    public Human(int age) {
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public void speak() {
        System.out.println(String.format("I am %s and I can speak", this.getClass().getSimpleName()));
    }
}
