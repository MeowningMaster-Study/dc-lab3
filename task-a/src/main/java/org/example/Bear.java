package org.example;

public class Bear extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            if (App.blocked.compareAndSet(false, true)) {
                if (App.hive >= App.max) {
                    App.hive = 0;
                    System.out.println("Bear: 0");
                }
                App.blocked.set(false);
                try {
                    Thread.sleep(1);

                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
