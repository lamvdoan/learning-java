package strategy_pattern.context;

import strategy_pattern.strategy.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int performOperation(int num1, int num2) {
        return strategy.operation(num1, num2);
    }
}
