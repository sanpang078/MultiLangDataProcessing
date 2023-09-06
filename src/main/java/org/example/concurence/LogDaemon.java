package org.example.concurence;

import java.io.SyncFailedException;
import java.util.Date;

public class LogDaemon {
    public static void main(String[] args) {
        Thread logThread = new Thread(() -> {
            while (true) {
                //模拟日志记录
                logMessage("Log Message: " + new Date());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        logThread.setDaemon(true);

        logThread.start();

        for (int i=0;i<10;i++) {
            System.out.println("i: " + i);
            try {
               Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main Application is existing");

    }

    private static void logMessage(String message){
        System.out.println(message);
    }
}

