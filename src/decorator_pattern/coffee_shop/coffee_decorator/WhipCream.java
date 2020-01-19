package decorator_pattern.coffee_shop.coffee_decorator;

import decorator_pattern.coffee_shop.coffee.Coffee;

public class WhipCream extends CoffeeDecorator {
    Coffee coffee;

    public WhipCream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whip Cream";
    }

    @Override
    public double cost() {
        return .10 + coffee.cost();
    }
}
