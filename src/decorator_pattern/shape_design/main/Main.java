package decorator_pattern.shape_design.main;

import decorator_pattern.shape_design.design.ColorDecorator;
import decorator_pattern.shape_design.design.ShadeDecorator;
import decorator_pattern.shape_design.design_attribute.Color;
import decorator_pattern.shape_design.design_attribute.Shade;
import decorator_pattern.shape_design.shape.Circle;
import decorator_pattern.shape_design.shape.Rectangle;
import decorator_pattern.shape_design.shape.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Creating a Circle with decorations -----");
        Shape circle = new Circle();
        circle = new ColorDecorator(circle, Color.BLUE);
        circle = new ShadeDecorator(circle, Shade.FILLED);
        circle.draw();

        System.out.println("\n----- Creating a Rectangle with decorations -----");
        Shape rectangle = new Rectangle();
        rectangle = new ColorDecorator(rectangle, Color.RED);
        rectangle = new ShadeDecorator(rectangle, Shade.STRIPED);
        rectangle.draw();
    }
}
