package com.example.threadexamples;

// have other choices for inheritance when using the interface
public class ThreadExampleWithInterface implements Runnable {

    private int primeCount;
    private int startValue;
    private int endValue;

    public ThreadExampleWithInterface(int startValue, int endValue) {
        primeCount = 0;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public int getPrimeCount() {
        return primeCount;
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.ceil(Math.sqrt(n)); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started, looking for primes between " + startValue + " - " + endValue);
        for (int number = startValue; number < endValue; number++) {
            if (isPrime(number)) {
                // if this isn't synchronized, you can lose updates
                PrimeCounter.incrementPrimeCount();
                primeCount++;
            }
        }
        System.out.println(primeCount);
        System.out.println(Thread.currentThread().getName() + " is done");
    }

}
