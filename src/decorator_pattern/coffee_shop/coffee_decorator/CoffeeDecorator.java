package decorator_pattern.coffee_shop.coffee_decorator;

import decorator_pattern.coffee_shop.coffee.Coffee;

public abstract class CoffeeDecorator extends Coffee {
    public abstract String getDescription();
}
