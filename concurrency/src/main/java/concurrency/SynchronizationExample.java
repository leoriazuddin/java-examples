package concurrency;

import java.util.LinkedList;
import java.util.Random;

/**
 * Produce and consume using lock object.
 */
public class SynchronizationExample {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    Object lock = new Object();

    public static void main(String[] args) throws Exception {
        SynchronizationExample r = new SynchronizationExample();
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

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                //list is full, wait for items to be consumed
                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(value++);
            }
        }
    }

    public void consume() throws InterruptedException {
        Random r = new Random();
        while (true) {
            synchronized (lock) {

                //wait for items to be added
                while (list.isEmpty()) {
                    lock.wait();
                }
                System.out.println("List size " + list.size());
                int value = list.removeFirst();
                System.out.println("Value is " + value);

                //wake up the producer
                lock.notify();
            }

            Thread.sleep(r.nextInt(1000));
        }
    }
}
