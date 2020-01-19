package factory_pattern.ingredient;

import factory_pattern.ingredient.cheese.CheddarCheese;
import factory_pattern.ingredient.cheese.MozzarellaCheese;
import factory_pattern.ingredient.cheese.ProvoloneCheese;
import factory_pattern.ingredient.dough.ThickCrustDough;
import factory_pattern.ingredient.dough.ThinCrustDough;
import factory_pattern.ingredient.sauce.CreamyGarlicSauce;
import factory_pattern.ingredient.sauce.MarinaSauce;
import factory_pattern.ingredient.sauce.PestoSauce;
import org.junit.Assert;
import org.junit.Test;

public class IngredientsTest {

    @Test
    public void DoughIsAThickCrust() {
        ThickCrustDough dough = new ThickCrustDough();
        Assert.assertEquals(dough.getName(), "Thick Crust");
    }

    @Test
    public void DoughIsAThinCrust() {
        ThinCrustDough dough = new ThinCrustDough();
        Assert.assertEquals(dough.getName(), "Thin Crust");
    }

    @Test
    public void SauceIsAMarinaSauce() {
        MarinaSauce sauce = new MarinaSauce();
        Assert.assertEquals(sauce.getName(), "Marina Sauce");
    }

    @Test
    public void SauceIsAPestoSauce() {
        PestoSauce sauce = new PestoSauce();
        Assert.assertEquals(sauce.getName(), "Pesto Sauce");
    }

    @Test
    public void SauceIsACreamyGarlicSauce() {
        CreamyGarlicSauce sauce = new CreamyGarlicSauce();
        Assert.assertEquals(sauce.getName(), "Creamy Garlic Sauce");
    }

    @Test
    public void CheeseIsMozzarellaCheese() {
        MozzarellaCheese cheese = new MozzarellaCheese();
        Assert.assertEquals(cheese.getName(), "Mozzarella Cheese");
    }

    @Test
    public void CheeseIsCheddarCheese() {
        CheddarCheese cheese = new CheddarCheese();
        Assert.assertEquals(cheese.getName(), "Cheddar Cheese");
    }

    @Test
    public void CheeseIsProvoloneCheese() {
        ProvoloneCheese cheese = new ProvoloneCheese();
        Assert.assertEquals(cheese.getName(), "Provolone Cheese");
    }

}
