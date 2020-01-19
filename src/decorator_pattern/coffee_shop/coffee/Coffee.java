package decorator_pattern.coffee_shop.coffee;

public abstract class Coffee {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
