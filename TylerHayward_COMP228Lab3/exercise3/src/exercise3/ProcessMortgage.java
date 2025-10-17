package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Exercise 3: Mortgage Processor ===");

        // TODO: check if we need to handle edge cases here
        double prime = 0.0;
        System.out.print("Enter current prime interest rate (annual percentage, e.g. 5.0): ");
        while(true) {
            try {
                prime = Double.parseDouble(scanner.nextLine().trim());
                if(prime < 0) {
                    System.out.println("You cannot put intrest rate to be negatice.");
                    System.out.print("Enter current prime interest rate (annual percentage, e.g. 5.0): ");
                    continue;
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                System.out.print("Enter current prime interest rate (annual percentage, e.g. 5.0): ");
            }
        }

        Mortgage[] mortgageList = new Mortgage[3]; // could make this dynamic later
        System.out.println("You will create 3 mortgages.");

        int counter = 0;
        while(counter < mortgageList.length) {
            System.out.printf("%nCreating mortgage %d of %d%n", counter+1, mortgageList.length);

            System.out.print("Enter mortgage number: ");
            String mortgageNum = scanner.nextLine().trim();

            System.out.print("Enter customer name: ");
            String name = scanner.nextLine().trim();

            double amt = 0.0;
            System.out.print("Enter mortgage amount (max $300000): ");
            while(true) {
                try {
                    String input = scanner.nextLine().trim();
                    amt = Double.parseDouble(input);
                    if(amt < 0) {
                        System.out.print("Amount cannot be negative. Enter again: ");
                        continue;
                    }
                    // NOTE: not checking max $300k here - should we?
                    break;
                } catch(NumberFormatException ex) {
                    System.out.print("Invalid number. Enter again: ");
                }
            }

            int years = 0;
            System.out.print("Enter term (1 for short, 3 for medium, 5 for long): ");
            boolean gotValidTerm = false;
            while(!gotValidTerm) {
                try {
                    years = Integer.parseInt(scanner.nextLine().trim());
                    gotValidTerm = true;
                } catch(NumberFormatException nfe) {
                    System.out.print("Invalid. Enter 1, 3 or 5: ");
                }
            }

            System.out.print("Enter mortgage type (Business / Personal): ");
            String typeStr = scanner.nextLine().trim();

            // Create mortgage based on type
            Mortgage mortgage = null;
            if(typeStr.equalsIgnoreCase("Business")) {
                mortgage = new BusinessMortgage(mortgageNum, name, amt, prime, years);
            }
            else if(typeStr.equalsIgnoreCase("Personal")) {
                mortgage = new PersonalMortgage(mortgageNum, name, amt, prime, years);
            }
            else {
                // fallback to personal if unknown
                System.out.println("Unknown type. Defaulting to PersonalMortgage.");
                mortgage = new PersonalMortgage(mortgageNum, name, amt, prime, years);
            }

            mortgageList[counter] = mortgage;
            counter++;
        }

        // Display results
        System.out.println("\n--- All mortgages entered ---");
        for(int idx = 0; idx < mortgageList.length; idx++) {
            mortgageList[idx].getMortgageInfo();
        }

        scanner.close();
    }
}