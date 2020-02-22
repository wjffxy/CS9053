package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class BaristaX implements Barista {

    private final Semaphore binarySemaphore;

    public BaristaX(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    public OrderNumber handle(Queue from) {
        try {
            binarySemaphore.acquire();
            try {
                if (from.isEmpty()) {
                    return null;
                }
                else {
                    OrderNumber orderNumber = from.getOrderNumber();            
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
}