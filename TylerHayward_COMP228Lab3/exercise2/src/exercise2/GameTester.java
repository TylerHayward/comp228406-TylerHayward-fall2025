package exercise2;

public abstract class GameTester {
    protected String name;
    protected boolean fullTime;

    public GameTester(String name, boolean fullTime) {
        this.name = name;
        this.fullTime = fullTime;
    }

    public String getName() { return name; }
    public boolean isFullTime() { return fullTime; }

    // Abstract method to determine salary
    public abstract double determineSalary(int hoursWorked);
}
