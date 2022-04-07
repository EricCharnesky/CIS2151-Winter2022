package com.example.threadexamples;

public class PrimeCounter {
    private static int primeCount = 0;

    public static synchronized int getPrimeCount() {
        return primeCount;
    }

    // synchronized ensures that only 1 thread can access this at a time
    public static synchronized void incrementPrimeCount() {
        primeCount++;
    }
}
