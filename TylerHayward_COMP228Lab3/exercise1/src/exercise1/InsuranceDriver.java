package exercise1;

import java.util.Scanner;

public class InsuranceDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Insurance Manager ===");

        int numEntries = -1;
        while (numEntries <= 0) {
            System.out.print("How many insurance records do you wanna add? ");
            String in = sc.nextLine().trim();
            try {
                numEntries = Integer.parseInt(in);
                if (numEntries <= 0) System.out.println("C'mon, number must be positive.");
            } catch(Exception e) {
                System.out.println("That ain't a number, try again.");
            }
        }

        Insurance[] insArr = new Insurance[numEntries];

        for (int i = 0; i < numEntries; i++) {
            System.out.println("\nEntry #" + (i+1) + " out of " + numEntries);

            System.out.print("Insurance type (Health / Life)? ");
            String type = sc.nextLine().trim();

            double fee = -1;
            while (fee < 0) {
                System.out.print("Monthly fee: ");
                String feeIn = sc.nextLine().trim();
                try {
                    fee = Double.parseDouble(feeIn);
                    if (fee < 0) System.out.println("Fee can't be negative.");
                } catch(Exception e) {
                    System.out.println("Not a valid number, try again.");
                }
            }

            Insurance ins;
            if(type.equalsIgnoreCase("Health")) {
                ins = new Health();
            } else if(type.equalsIgnoreCase("Life")) {
                ins = new Life();
            } else {
                System.out.println("Unknown type, gonna use Health by default.");
                ins = new Health();
            }

            ins.setInsuranceCost(fee);
            insArr[i] = ins;

            System.out.println("Added!");
        }

        System.out.println("\nAll done, here's what you entered:");
        for(Insurance ins : insArr) {
            ins.displayInfo();
        }

        System.out.println("\nThat's it! Bye.");
        sc.close();
    }
}
