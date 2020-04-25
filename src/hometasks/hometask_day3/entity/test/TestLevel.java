package hometasks.hometask_day3.entity.test;

public enum TestLevel {
    UNIT(1), API(3), GUI(9);

    public final int COMPLEXITY;

    TestLevel(int COMPLEXITY) {
        this.COMPLEXITY = COMPLEXITY;
    }




}
