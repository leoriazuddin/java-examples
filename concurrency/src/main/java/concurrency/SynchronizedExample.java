package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * without synchronization, the lists will contain unexpected number of elements, sometimes erroring out.
 * with method synchronization, the program will take more time to finish.
 * with separate locks, the result is fast and predictable.
 */
public class SynchronizedExample {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    Random random = new Random();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void one() {
        synchronized (lock1) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.add(random.nextInt());
        }
    }

    public synchronized void two() {
        synchronized (lock2) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            l2.add(random.nextInt());
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            one();
            two();
        }
    }

    public void print() {
        System.out.println(l1.size() + " " + l2.size());
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample runner = new SynchronizedExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.process();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        runner.print();
    }
}
