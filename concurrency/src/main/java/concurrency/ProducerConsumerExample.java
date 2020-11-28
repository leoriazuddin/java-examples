package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * multi threading without synchronization. using concurrent utilities.
 */
public class ProducerConsumerExample {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws Exception {
        ProducerConsumerExample r = new ProducerConsumerExample();
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
        Random r = new Random();

        while (true) {
            queue.put(r.nextInt(100));
        }
    }

    public void consume() throws InterruptedException {
        Random r = new Random();
        while (true) {
            Thread.sleep(100);

            if (r.nextInt(10) == 0) {
                System.out.println("Taken " + queue.take() + " size is " + queue.size());
            }
        }
    }
}
