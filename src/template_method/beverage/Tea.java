package template_method.beverage;

public class Tea extends HotBeverage {
    @Override
    void brew() {
        System.out.println("Cooking tea leaves");
    }

    @Override
    void addCondiments() {
        System.out.println("Squeezing lemon");
    }
}
