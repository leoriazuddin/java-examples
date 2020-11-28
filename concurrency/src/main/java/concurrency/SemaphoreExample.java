package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.instance().connect();
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * without semaphore, the caller will consume 200 connections.
     * with semaphore, limit of 2 is enforced.
     */
    static class Connection {
        private Semaphore s = new Semaphore(20);
        private static Connection connection = new Connection();
        private int connections = 0;

        private Connection() {
        }

        static Connection instance() {
            return connection;
        }

        void connect() {
            try {
                s.acquire();
                doConnect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }

        private void doConnect() {
            synchronized (this) {
                connections++;
                System.out.println("Coon " + connections);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                connections--;
            }
        }
    }
}
