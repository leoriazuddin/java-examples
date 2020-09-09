package behavioral;

/**
 * https://refactoring.guru/design-patterns/strategy/java/example
 */
public class StrategyDemo {
}

interface PayStrategy {
    boolean pay(int amount);
    void collectPayment();
}

class PayPal implements PayStrategy {

    @Override
    public boolean pay(int amount) {
        return false;
    }

    @Override
    public void collectPayment() {

    }
}

class CreditCard implements PayStrategy {

    @Override
    public boolean pay(int amount) {
        return false;
    }

    @Override
    public void collectPayment() {

    }
}