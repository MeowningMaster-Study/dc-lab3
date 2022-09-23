package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Bee extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            if (App.blocked.compareAndSet(false, true)) {
                App.hive += 1;
                System.out.println(App.hive);
                App.blocked.set(false);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,  1500));

                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}