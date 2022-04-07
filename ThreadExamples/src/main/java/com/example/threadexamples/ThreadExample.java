package com.example.threadexamples;

public class ThreadExample extends Thread {

    private int primeCount;
    private int startValue;
    private int endValue;

    public ThreadExample(int startValue, int endValue){
        primeCount = 0;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public int getPrimeCount(){
        return primeCount;
    }

    @Override
    public void run(){
        System.out.println(this.getName() + " started, looking for primes between " + startValue + " - " + endValue);
        for ( int number = startValue; number < endValue; number++ ){
            if ( isPrime(number) ){
                // if this isn't synchronized, you can lose updates
                PrimeCounter.incrementPrimeCount();
                primeCount++;
            }
        }
        System.out.println(primeCount);
        System.out.println(this.getName() + " is done");
    }

    public static boolean isPrime(int n){
        for(int i=2; i<=n/2; i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }

}
