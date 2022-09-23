package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Barber implements Runnable {
    final int n;

    Barber(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500,  1500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished: " + n);
    }
}
