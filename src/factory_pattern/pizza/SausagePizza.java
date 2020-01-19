package factory_pattern.pizza;

import factory_pattern.factory.PizzaIngredientFactory;

public class SausagePizza extends Pizza {

    public SausagePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        sausage = pizzaIngredientFactory.createSausage();

        System.out.println("Preparing " +
                dough.getName() + ", " +
                sauce.getName() + ", " +
                cheese.getName() + ", " +
                sausage.getName()
        );
    }
}
