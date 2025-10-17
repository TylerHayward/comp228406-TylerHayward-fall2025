package exercise2;

public class FullTimeGameTester extends GameTester {
    private static final double BASE_SALARY = 3000.0;

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double determineSalary(int hoursWorked) {
        // For full time, base salary (hours parameter is ignored here)
        return BASE_SALARY;
    }
}
