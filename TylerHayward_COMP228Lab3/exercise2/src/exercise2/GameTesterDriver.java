package exercise2;

import java.util.Scanner;

public class GameTesterDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Game Tester Payroll ===");

        System.out.print("Name? ");
        String name = sc.nextLine().trim();

        System.out.print("FullTime or PartTime? ");
        String type = sc.nextLine().trim();

        if(type.equalsIgnoreCase("FullTime")) {
            FullTimeGameTester ft = new FullTimeGameTester(name);
            double salary = ft.determineSalary(0); // full-time, no hours needed
            System.out.printf("%s is full-time and earns $%.2f%n", ft.getName(), salary);
        } else {
            int hours = -1;
            while(hours < 0) {
                System.out.print("Hours worked? ");
                String hInput = sc.nextLine().trim();
                try {
                    hours = Integer.parseInt(hInput);
                    if(hours < 0) System.out.println("Can't be negative, try again.");
                } catch(Exception e) {
                    System.out.println("Not a valid number. Enter integer hours.");
                }
            }

            PartTimeGameTester pt = new PartTimeGameTester(name);
            double salary = pt.determineSalary(hours);
            System.out.printf("%s worked %d hours and earned $%.2f%n", pt.getName(), hours, salary);
        }

        System.out.println("All done! Thanks for checking payroll.");
        sc.close();
    }
}


