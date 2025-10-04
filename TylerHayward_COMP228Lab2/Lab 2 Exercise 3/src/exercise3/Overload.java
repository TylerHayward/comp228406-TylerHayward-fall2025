package exercise3;

public class Overload {

    // method 1 - takes two ints
    public static int addNums(int a, int b) {
        return a + b;
    }

    // method 2 - takes three ints
    public static int addNums(int a, int b, int c) {
        return a + b + c;
    }

    // method 3 - takes two doubles
    public static double addNums(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        // testing the overloaded methods
        int sum1 = addNums(5, 10);
        int sum2 = addNums(3, 4, 8);
        double sum3 = addNums(2.5, 3.7);

        System.out.println("Sum of 2 ints: " + sum1);
        System.out.println("Sum of 3 ints: " + sum2);
        System.out.println("Sum of 2 doubles: " + sum3);
    }
}
