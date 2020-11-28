package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++) {
            service.submit(new Processor(latch));
        }

        //waits until latch is counted down to 0
        latch.await();
        service.shutdown();
        System.out.println("Completed...");
    }

    static class Processor implements Runnable {
        private CountDownLatch latch;
        public Processor(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Started");
            Random r = new Random();
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " finished.");
            latch.countDown();
        }
    }
}
