package decorator_pattern.coffee_shop.coffee;

public class Decaf extends Coffee {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
