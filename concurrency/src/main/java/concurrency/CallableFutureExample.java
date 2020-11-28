package concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit((Callable<Integer>) () -> {
            Random r = new Random();
            int duration = r.nextInt(4000);

            System.out.println("Starting...");
            try{
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finished");
            return duration;
        });

        service.shutdown();
        System.out.println(future.get());
    }
}
