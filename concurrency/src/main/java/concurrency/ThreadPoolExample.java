package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            service.submit(new Processor(i));
        }

        service.shutdown();
        System.out.println("All submitted...");

        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All done...");
    }

    static class Processor implements Runnable {
        int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Starting " + id);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Completed " + id);
        }
    }
}
