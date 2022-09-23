package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{
    public static void main( String[] args )
    {
        int clientsCount = 15;
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < clientsCount; i += 1) {
            executor.execute(new Barber(i));
        }
    }
}
