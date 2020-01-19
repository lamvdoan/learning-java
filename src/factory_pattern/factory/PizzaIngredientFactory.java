package factory_pattern.factory;

import factory_pattern.ingredient.cheese.Cheese;
import factory_pattern.ingredient.dough.Dough;
import factory_pattern.ingredient.meat.Pepperoni;
import factory_pattern.ingredient.meat.Sausage;
import factory_pattern.ingredient.sauce.Sauce;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Pepperoni createPepperoni();
    public Sausage createSausage();
}
