package exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        // Enforce maximum amount
        if (amount > MAX_MORTGAGE) {
            System.out.printf("Amount exceeds bank maximum - setting to maximum.%n", amount, MAX_MORTGAGE);
            this.amount = MAX_MORTGAGE;
        } else {
            this.amount = amount;
        }
        this.interestRate = interestRate;
        // Force term to short if not defined
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            System.out.println("Words are not recognized. Will default to short ter, (1 year).");
            this.term = SHORT_TERM;
        }
    }

    public String getMortgageNumber() { return mortgageNumber; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public double getInterestRate() { return interestRate; }
    public int getTerm() { return term; }

    public double calculateTotalOwed() {

        double interest = amount * (interestRate / 100.0) * term;
        return amount + interest;
    }

    public void getMortgageInfo() {
        System.out.println("----- Mortgage Info -----");
        System.out.printf("Bank: %s%n", BANK_NAME);
        System.out.printf("Mortgage #: %s%n", mortgageNumber);
        System.out.printf("Customer: %s%n", customerName);
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.printf("Term: %d year(s)%n", term);
        System.out.printf("Total Owed (amount + interest over term): $%.2f%n", calculateTotalOwed());
        System.out.println("-------------------------");
    }
}
