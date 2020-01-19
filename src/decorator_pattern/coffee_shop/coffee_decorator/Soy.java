package decorator_pattern.coffee_shop.coffee_decorator;

import decorator_pattern.coffee_shop.coffee.Coffee;

public class Soy extends CoffeeDecorator {
    Coffee coffee;

    public Soy(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .15 + coffee.cost();
    }
}
