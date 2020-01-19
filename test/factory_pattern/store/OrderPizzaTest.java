package factory_pattern.store;

import factory_pattern.data.PizzaType;
import factory_pattern.pizza.CheesePizza;
import factory_pattern.pizza.PepperoniPizza;
import factory_pattern.pizza.Pizza;
import factory_pattern.pizza.SausagePizza;
import org.junit.Assert;
import org.junit.Test;

public class OrderPizzaTest {

    @Test
    public void orderCheesePizza() {
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        Assert.assertTrue(pizza instanceof CheesePizza);
    }

    @Test
    public void orderSausagePizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.SAUSAGE);
        Assert.assertTrue(pizza instanceof SausagePizza);
    }

    @Test
    public void orderPepperoniPizza() {
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        Assert.assertTrue(pizza instanceof PepperoniPizza);
    }
}
