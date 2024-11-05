package ua.edu.ucu.lab8.decorator;

public class PremiumPackagingDecorator extends AbstractDecorator {
    private final AbstractDecorator order;
    private final double premiumPackagingCost;

    public PremiumPackagingDecorator(AbstractDecorator order, double premiumPackagingCost) {
        this.order = order;
        this.premiumPackagingCost = premiumPackagingCost;
    }

    @Override
    public double calculateCost() {
        return order.calculateCost() + premiumPackagingCost;
    }
}
