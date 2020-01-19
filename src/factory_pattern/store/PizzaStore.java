package factory_pattern.store;

import factory_pattern.data.PizzaType;
import factory_pattern.factory.PizzaIngredientFactory;
import factory_pattern.pizza.Pizza;

public abstract class PizzaStore {
    protected PizzaIngredientFactory pizzaIngredientFactory;

    public abstract Pizza createPizza(PizzaType pizzaType);

    public Pizza orderPizza(PizzaType pizzaType) {
        Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();

        return pizza;
    }
}
