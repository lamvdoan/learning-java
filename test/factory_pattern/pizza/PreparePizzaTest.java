package factory_pattern.pizza;

import factory_pattern.factory.ChicagoPizzaIngredientFactory;
import factory_pattern.factory.NewYorkPizzaIngredientFactory;
import org.junit.Assert;
import org.junit.Test;

public class PreparePizzaTest {

    @Test
    public void PrepareChicagoStyleCheesePizza() {
        ChicagoPizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        CheesePizza pizza = new CheesePizza(pizzaIngredientFactory);
        pizza.prepare();

        Assert.assertEquals("Thick Crust", pizza.dough.getName());
        Assert.assertEquals("Marina Sauce", pizza.sauce.getName());
        Assert.assertEquals("Mozzarella Cheese", pizza.cheese.getName());
    }

    @Test
    public void PrepareNewYorkStylePepperoniPizza() {
        NewYorkPizzaIngredientFactory pizzaIngredientFactory = new NewYorkPizzaIngredientFactory();
        PepperoniPizza pizza = new PepperoniPizza(pizzaIngredientFactory);
        pizza.prepare();

        Assert.assertEquals("Thin Crust", pizza.dough.getName());
        Assert.assertEquals("Pesto Sauce", pizza.sauce.getName());
        Assert.assertEquals("Cheddar Cheese", pizza.cheese.getName());
        Assert.assertEquals("Pepperoni", pizza.pepperoni.getName());
    }

    @Test
    public void PrepareChicagoStyleSausagePizza() {
        ChicagoPizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        SausagePizza pizza = new SausagePizza(pizzaIngredientFactory);
        pizza.prepare();

        Assert.assertEquals("Thick Crust", pizza.dough.getName());
        Assert.assertEquals("Marina Sauce", pizza.sauce.getName());
        Assert.assertEquals("Mozzarella Cheese", pizza.cheese.getName());
        Assert.assertEquals("Sausage", pizza.sausage.getName());
    }
}
