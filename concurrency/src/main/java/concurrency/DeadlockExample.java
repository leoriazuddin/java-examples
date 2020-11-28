package concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    public static void main(String[] args) throws Exception {
        Runner r = new Runner();
        Thread t1 = new Thread(() -> r.firstThread());
        Thread t2 = new Thread(() -> r.secondThread());

        t1.start();t2.start();
        t1.join();t2.join();

        r.finished();
    }

    /**
     * Locks here are acquired in different order and cause deadlock. This can happen in
     * synchronized blocks also.
     *
     * Solution: use locks in same order.
     */
    static class Runner {
        Account a = new Account();
        Account b = new Account();

        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        void firstThread() {
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                l1.lock();l2.lock();
                try {
                    Account.transfer(a, b, r.nextInt(100));
                } finally {
                    l1.unlock();l2.unlock();
                }
            }
        }

        void secondThread() {
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                l2.lock();l1.lock();
                try {
                    Account.transfer(b, a, r.nextInt(100));
                } finally {
                    l1.unlock();l2.unlock();
                }
            }
        }

        void finished() {
            System.out.println("a balance "+a.balance());
            System.out.println("b balance "+b.balance());
            System.out.println("Total "+(a.balance() + b.balance()));
        }
    }

    static class Account {
        private int balance = 10000;

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int balance() {
            return balance;
        }

        static void transfer(Account a, Account b, int amount) {
            a.withdraw(amount);
            b.deposit(amount);
        }
    }
}
