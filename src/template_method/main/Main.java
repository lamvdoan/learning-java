package template_method.main;

import template_method.beverage.Coffee;
import template_method.beverage.HotBeverage;
import template_method.beverage.Tea;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n---- Coffee ----");
        HotBeverage coffee = new Coffee();
        coffee.prepareDrink();

        System.out.println("\n---- Tea ----");
        HotBeverage tea = new Tea();
        tea.prepareDrink();
    }
}
