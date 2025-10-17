package exercise2;

public class PartTimeGameTester extends GameTester {
    private static final double HOURLY_RATE = 20.0;

    public PartTimeGameTester(String name) {
        super(name, false);
    }

    @Override
    public double determineSalary(int hoursWorked) {
        return HOURLY_RATE * hoursWorked;
    }
}
