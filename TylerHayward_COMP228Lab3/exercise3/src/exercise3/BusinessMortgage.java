package exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, double currentPrime, int term) {
        super(mortgageNumber, customerName, amount, /*interestRate=*/ currentPrime + 1.0, term);
        // interest rate automatically set to currentPrime + 1%
    }
}
