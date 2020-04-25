package people;

public class Person extends Human {

    private String name;
    private String surname;

    public Person() {
    }

    public Person(int age, String name, String surname) {
        super(age);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }



}
