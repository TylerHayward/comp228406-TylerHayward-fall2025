package exercise1;

public class Health extends Insurance {

    public Health() {
        super("Health");
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
