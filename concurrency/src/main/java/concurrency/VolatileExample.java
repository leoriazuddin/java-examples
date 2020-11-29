package concurrency;

import java.util.Scanner;

public class VolatileExample {
    public static void main(String[] args) {
        Processor p = new Processor();
        new Thread(p).start();

        System.out.println("Press return to stop....");
        Scanner s = new Scanner(System.in);
        s.nextLine();

        p.shutdown();
    }

    static class Processor implements Runnable {
        //IMPORTANT: if this 'running'' is not volatile, the behavior could be unpredictable.
        //In a multicore system 2 threads can be running on different cores and they get
        // their own cached copy of boolean variable 'running'. When one thread changes it,
        // the other thread might not see it. So the shutdown() method may have no impact.
        //volatile prevents threads from caching their own variables.
        private volatile boolean running = true;

        public void shutdown() {
            running = false;
        }

        @Override
        public void run() {
            while(running) {
                System.out.println("Hello");

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
