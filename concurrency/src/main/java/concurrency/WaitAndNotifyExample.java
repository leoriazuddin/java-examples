package concurrency;

import java.util.Scanner;

/**
 * Basic use of wait and notify
 */
public class WaitAndNotifyExample {

    public static void main(String[] args) throws Exception {
        WaitAndNotifyExample r = new WaitAndNotifyExample();
        Thread t1 = new Thread(() -> {
            try {
                r.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                r.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();t2.start();
        t1.join();t2.join();
    }

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running...");

            //lock is released
            wait();
            System.out.println("Resumed... ");
        }
    }

    public void consume() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        Thread.sleep(2000);

        //lock is released
        synchronized (this) {
            System.out.println("Waiting for return key...");
            s.nextLine();
            System.out.println("Pressed return key...");

            //does not relinquish the lock, this should be the last line
            notify();
        }
    }
}
