package ua.edu.ucu.lab8.model.delivery;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public void deliver() {
        System.out.println("Delivering order via DHL.");
    }
}