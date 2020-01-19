package factory_pattern.factory;

import factory_pattern.ingredient.cheese.Cheese;
import factory_pattern.ingredient.cheese.MozzarellaCheese;
import factory_pattern.ingredient.dough.Dough;
import factory_pattern.ingredient.dough.ThickCrustDough;
import factory_pattern.ingredient.meat.Pepperoni;
import factory_pattern.ingredient.meat.Sausage;
import factory_pattern.ingredient.sauce.MarinaSauce;
import factory_pattern.ingredient.sauce.Sauce;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    @Override
    public Sausage createSausage() {
        return new Sausage();
    }
}
