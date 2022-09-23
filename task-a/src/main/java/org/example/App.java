package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class App
{
    static final int max = 10;
    static final AtomicBoolean blocked = new AtomicBoolean(false);
    static int hive = 0;

    public static void main( String[] args )
    {
        int n = 2;
        for (int i = 0; i < n; i += 1) {
            new Bee().start();
        }
        new Bear().start();
    }
}
