package decorator_pattern.coffee_shop.main;


import decorator_pattern.coffee_shop.coffee.Cappuccino;
import decorator_pattern.coffee_shop.coffee.Coffee;
import decorator_pattern.coffee_shop.coffee.DarkRoast;
import decorator_pattern.coffee_shop.coffee_decorator.Mocha;
import decorator_pattern.coffee_shop.coffee_decorator.Soy;
import decorator_pattern.coffee_shop.coffee_decorator.WhipCream;

public class LamsCoffeeShop {
    public static void main(String[] args) {
        Coffee jackiesCoffee = new Cappuccino();
        jackiesCoffee = new Mocha(jackiesCoffee);
        jackiesCoffee = new WhipCream(jackiesCoffee);
        jackiesCoffee = new WhipCream(jackiesCoffee);
        System.out.println(jackiesCoffee.getDescription() + ": $" + jackiesCoffee.cost());

        Coffee lamsCoffee = new DarkRoast();
        lamsCoffee = new Mocha(lamsCoffee);
        lamsCoffee = new Soy(lamsCoffee);
        System.out.println(lamsCoffee.getDescription() + ": $" + lamsCoffee.cost());
    }
}
