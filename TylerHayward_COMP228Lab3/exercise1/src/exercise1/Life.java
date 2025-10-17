package exercise1;

public class Life extends Insurance {

    public Life() {
        super("Life");
    }

    @Override
    public void setInsuranceCost(double cost) {
        // Could add validation or additional logic here
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Insurance Type: %s | Monthly Cost: $%.2f%n", insuranceType, monthlyCost);
    }
}
