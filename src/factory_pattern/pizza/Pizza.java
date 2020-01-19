package factory_pattern.pizza;

import factory_pattern.factory.PizzaIngredientFactory;
import factory_pattern.ingredient.cheese.Cheese;
import factory_pattern.ingredient.dough.Dough;
import factory_pattern.ingredient.meat.Pepperoni;
import factory_pattern.ingredient.meat.Sausage;
import factory_pattern.ingredient.sauce.Sauce;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Sausage sausage;
    protected Pepperoni pepperoni;

    protected PizzaIngredientFactory pizzaIngredientFactory;

    public Pizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println(String.format("Baking %s at 400 degrees for 30 minutes.", name));
    }

    public void cut() {
        System.out.println("Cutting into square slices");
    };

    public void serve() {
        System.out.println(String.format("Ready to serve %s", name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
