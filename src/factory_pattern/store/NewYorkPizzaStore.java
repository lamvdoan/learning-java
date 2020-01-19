package factory_pattern.store;

import factory_pattern.data.PizzaType;
import factory_pattern.factory.NewYorkPizzaIngredientFactory;
import factory_pattern.helper.PizzaSelector;
import factory_pattern.helper.StringHelper;
import factory_pattern.pizza.Pizza;

public class NewYorkPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(PizzaType pizzaType) {
        pizzaIngredientFactory = new NewYorkPizzaIngredientFactory();
        Pizza pizza = PizzaSelector.createPizza(pizzaType, pizzaIngredientFactory);

        String pizzaNamePrefix= "New York Style";
        pizza.setName(pizzaNamePrefix + " " + StringHelper.toTitleCase(pizzaType.toString()) + " Pizza");

        return pizza;
    }
}
