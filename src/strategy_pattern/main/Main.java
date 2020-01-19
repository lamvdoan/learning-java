package strategy_pattern.main;

import strategy_pattern.context.Context;
import strategy_pattern.strategy.OperationAdd;
import strategy_pattern.strategy.OperationMultiply;

public class Main {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        System.out.println("\n---- Add Operation ----");
        Context context = new Context(new OperationAdd());
        int results = context.performOperation(5, 10);
        System.out.println("Num1: " + num1 + ", Num2: " + num2 + " = " + results);

        System.out.println("\n---- Multiply Operation ----");
        Context context2 = new Context(new OperationMultiply());
        int results2 = context2.performOperation(5, 10);
        System.out.println("Num1: " + num1 + ", Num2: " + num2 + " = " + results2);

    }
}
