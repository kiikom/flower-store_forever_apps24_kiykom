package ua.edu.ucu.lab8.decorator;

public class GiftWrapDecorator extends AbstractDecorator {
    private final AbstractDecorator order;
    private final double giftWrapCost;

    public GiftWrapDecorator(AbstractDecorator order, double giftWrapCost) {
        this.order = order;
        this.giftWrapCost = giftWrapCost;
    }

    @Override
    public double calculateCost() {
        return order.calculateCost() + giftWrapCost;
    }
}