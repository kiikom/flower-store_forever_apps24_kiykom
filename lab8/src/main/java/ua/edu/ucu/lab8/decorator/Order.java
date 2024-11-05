package ua.edu.ucu.lab8.decorator;

public class Order extends AbstractDecorator {
    private double baseCost;

    public Order(double baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public double calculateCost() {
        return baseCost;
    }
}
