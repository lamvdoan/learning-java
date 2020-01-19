package decorator_pattern.coffee_shop.coffee_decorator;

import decorator_pattern.coffee_shop.coffee.Coffee;

public class Mocha extends CoffeeDecorator {
    Coffee coffee;

    public Mocha(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + coffee.cost();
    }
}
