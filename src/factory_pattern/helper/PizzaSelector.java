package factory_pattern.helper;

import factory_pattern.data.PizzaType;
import factory_pattern.factory.PizzaIngredientFactory;
import factory_pattern.pizza.CheesePizza;
import factory_pattern.pizza.PepperoniPizza;
import factory_pattern.pizza.Pizza;
import factory_pattern.pizza.SausagePizza;

public class PizzaSelector {

    public static Pizza createPizza(PizzaType pizzaType, PizzaIngredientFactory pizzaIngredientFactory) {
        Pizza pizza = null;

        switch (pizzaType) {
            case CHEESE:
                pizza = new CheesePizza(pizzaIngredientFactory);
                break;
            case PEPPERONI:
                pizza = new PepperoniPizza(pizzaIngredientFactory);
                break;
            case SAUSAGE:
                pizza = new SausagePizza(pizzaIngredientFactory);
                break;
        }

        return pizza;
    }
}
