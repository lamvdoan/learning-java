package factory_pattern.store;

import factory_pattern.data.PizzaType;
import factory_pattern.pizza.CheesePizza;
import factory_pattern.pizza.PepperoniPizza;
import factory_pattern.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

public class CreatePizzaTest {

    @Test
    public void createCheesePizza_CreatesChicagoStyleCheesePizza_FromChicagoStore() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.createPizza(PizzaType.CHEESE);
        Assert.assertTrue(pizza instanceof CheesePizza);
        Assert.assertEquals("Chicago Style" + " Cheese Pizza", pizza.getName());
    }

    @Test
    public void createPepperoniPizza_CreatesNewYorkStylePepperoniPizza_FromNewYorkStore() {
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        Pizza pizza = pizzaStore.createPizza(PizzaType.PEPPERONI);
        Assert.assertTrue(pizza instanceof PepperoniPizza);
        Assert.assertEquals("New York Style" + " Pepperoni Pizza", pizza.getName());
    }
}
