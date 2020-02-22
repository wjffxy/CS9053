package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private static Semaphore binarySemaphore = new Semaphore(1);

    public static Customer createCustomer() {
        return new CustomerX(binarySemaphore);
    }

    public static Barista createBarista() {
        return new BaristaX(binarySemaphore);
    }
}