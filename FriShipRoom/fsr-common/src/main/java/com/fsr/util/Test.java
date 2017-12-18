package com.fsr.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hasee on 2017/6/11.
 */
public class Test {
    static boolean flag = true;
    static Object lock = new Object();
    static Object waitObject = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {

        }
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run(){
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true.wait@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        waitObject.wait();
                   } catch(InterruptedException e) {

                   }
                }
                System.out.println(Thread.currentThread() + "flag is false.running@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        public void run(){
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock.notify@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                waitObject.notifyAll();
                flag = false;
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {

                }

            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock again.sleep @" +new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
