package entity;

public class Code {

    public Code() {
    }
    public Code(int lines) {
        this.lines = lines;
    }

    private int lines;

    public int getLines() {
        return lines;
    }
    public void setLines(int lines) {
        this.lines = lines;
    }

    public void develop (int hours) {
        this.lines += 20*hours;
    }
}
