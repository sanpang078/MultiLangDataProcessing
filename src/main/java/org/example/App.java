package org.example;

import org.example.concurence.Hb;
import org.example.concurence.RaceConditionTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RaceConditionTest rct = new RaceConditionTest();
        Thread t1 = new Thread(() -> rct.add10k());
        Thread t2 = new Thread(() -> rct.add10k());

        t1.start();
        //t2.start();


        try {
            t1.join();
            //t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(rct.get());

    }
}
