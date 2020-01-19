package template_method.beverage;

public class Coffee extends HotBeverage {
    @Override
    void brew() {
        System.out.println("Brewing coffee grinds");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and cream");
    }
}
