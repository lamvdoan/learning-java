package factory_pattern.pizza;

import factory_pattern.factory.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        pepperoni = pizzaIngredientFactory.createPepperoni();

        System.out.println("Preparing " +
                dough.getName() + ", " +
                sauce.getName() + ", " +
                cheese.getName() + ", " +
                pepperoni.getName()
        );
    }
}
