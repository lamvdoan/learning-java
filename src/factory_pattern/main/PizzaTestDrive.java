package factory_pattern.main;

import factory_pattern.data.PizzaType;
import factory_pattern.pizza.Pizza;
import factory_pattern.store.ChicagoPizzaStore;
import factory_pattern.store.NewYorkPizzaStore;
import factory_pattern.store.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();

        Pizza cheesePizza = chicagoPizzaStore.orderPizza(PizzaType.SAUSAGE);
        System.out.println("Lam ordered a " + cheesePizza.getName() + ".\n");

        Pizza sausagePizza = newYorkPizzaStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Jackie ordered a " + sausagePizza.getName() + ".\n");

        Pizza pepperoniPizza = newYorkPizzaStore.orderPizza(PizzaType.PEPPERONI);
        System.out.println("David ordered a " + pepperoniPizza.getName() + ".\n");
    }
}
