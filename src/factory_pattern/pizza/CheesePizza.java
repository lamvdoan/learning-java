package factory_pattern.pizza;

import factory_pattern.factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();

        System.out.println("Preparing " +
                dough.getName() + ", " +
                sauce.getName() + ", " +
                cheese.getName()
        );
    }
}
