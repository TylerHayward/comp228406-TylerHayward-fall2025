package exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, double currentPrime, int term) {
        super(mortgageNumber, customerName, amount, /*interestRate=*/ currentPrime + 2.0, term);
        // interest rate automatically set to currentPrime + 2%
    }
}
