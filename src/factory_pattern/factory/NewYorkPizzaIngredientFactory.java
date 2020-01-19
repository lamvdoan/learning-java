package factory_pattern.factory;

import factory_pattern.ingredient.cheese.CheddarCheese;
import factory_pattern.ingredient.cheese.Cheese;
import factory_pattern.ingredient.dough.Dough;
import factory_pattern.ingredient.dough.ThinCrustDough;
import factory_pattern.ingredient.meat.Pepperoni;
import factory_pattern.ingredient.meat.Sausage;
import factory_pattern.ingredient.sauce.PestoSauce;
import factory_pattern.ingredient.sauce.Sauce;

public class NewYorkPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PestoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new CheddarCheese();
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
