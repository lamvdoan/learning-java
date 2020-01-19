package decorator_pattern.coffee_shop.coffee;

public class Cappuccino extends Coffee {

    public Cappuccino() {
        description = "Cappuccino Coffee";
    }

    @Override
    public double cost() {
        return 1.25;
    }
}
