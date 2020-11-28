package concurrency;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) throws Exception {
        Runner r = new Runner();
        Thread t1 = new Thread(() -> r.firstThread());
        Thread t2 = new Thread(() -> r.secondThread());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        r.finished();
    }

    static class Runner {
        int count = 0;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        private void increment() {
            for (int i = 0; i < 1000; i++)
                count++;
        }

        void firstThread() {
            lock.lock();
            System.out.println("Waiting...");

            try {
                //now waits for other thread to acquire lock and finish.
                condition.await();
                System.out.println("Awake...");
                increment();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void secondThread() {
            lock.lock();

            System.out.println("Press enter....");
            new Scanner(System.in).nextLine();
            System.out.println("Got enter....");

            //signals other thread to start, must unlock for other thread to continue.
            condition.signal();

            try {
                increment();
            } finally {
                lock.unlock();
            }
        }

        void finished() {
            System.out.println("Count is " + count);
        }
    }
}
