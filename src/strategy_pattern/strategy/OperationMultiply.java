package strategy_pattern.strategy;

public class OperationMultiply implements Strategy {
    @Override
    public int operation(int num1, int num2) {
        return num1 * num2;
    }
}
