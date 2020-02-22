package edu.nyu.cs9053.homework9;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class CustomerX implements Customer {

    private final Semaphore binarySemaphore;

    public CustomerX(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    public OrderNumber order(Queue queue) {
        try {
            binarySemaphore.acquire();
            try {
                if (queue.full()) {
                    return null;
                }
                else {
                    OrderNumber orderNumber = queue.addOrder(coffee());
                    return orderNumber;
                }
            } finally { 
                binarySemaphore.release();
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }

    public CoffeeDrink coffee() {
        Random random = new Random();
        int number = random.nextInt(5);
        switch (number) {
            case 0 :
                return new Cappucino();
            case 1 :
                return new ColdBrew();
            case 2 :
                return new MatchaLatte();
            case 3 :
                return new Americano(false, false);
            case 4 :
                return new IcedCoffee();
            default :
                return null;
        }
    }
}