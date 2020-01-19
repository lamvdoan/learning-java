package factory_pattern.helper;

import factory_pattern.data.PizzaType;
import factory_pattern.factory.ChicagoPizzaIngredientFactory;
import factory_pattern.factory.NewYorkPizzaIngredientFactory;
import factory_pattern.factory.PizzaIngredientFactory;
import factory_pattern.pizza.CheesePizza;
import factory_pattern.pizza.PepperoniPizza;
import factory_pattern.pizza.Pizza;
import factory_pattern.pizza.SausagePizza;
import org.junit.Assert;
import org.junit.Test;

public class PizzaSelectorTest {

    @Test
    public void createCheesePizzaForChicagoStylePizza() {
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        Pizza pizza = PizzaSelector.createPizza(PizzaType.CHEESE, pizzaIngredientFactory);
        Assert.assertTrue(pizza instanceof CheesePizza);
    }

    @Test
    public void createPepperoniPizzaForNewYorkStylePizza() {
        PizzaIngredientFactory pizzaIngredientFactory = new NewYorkPizzaIngredientFactory();

        Pizza pizza = PizzaSelector.createPizza(PizzaType.PEPPERONI, pizzaIngredientFactory);
        Assert.assertTrue(pizza instanceof PepperoniPizza);
    }

    @Test
    public void createSausagePizzaForNewYorkStylePizza() {
        PizzaIngredientFactory pizzaIngredientFactory = new NewYorkPizzaIngredientFactory();

        Pizza pizza = PizzaSelector.createPizza(PizzaType.SAUSAGE, pizzaIngredientFactory);
        Assert.assertTrue(pizza instanceof SausagePizza);
    }
}
