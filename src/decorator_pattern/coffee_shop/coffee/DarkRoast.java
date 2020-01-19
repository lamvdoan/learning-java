package decorator_pattern.coffee_shop.coffee;

public class DarkRoast extends Coffee {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
