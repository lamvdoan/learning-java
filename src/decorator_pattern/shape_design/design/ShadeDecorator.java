package decorator_pattern.shape_design.design;

import decorator_pattern.shape_design.design_attribute.Shade;
import decorator_pattern.shape_design.shape.Shape;

public class ShadeDecorator implements Shape {
    protected Shape decoratedShape;
    Shade shade;

    public ShadeDecorator(Shape decoratedShape, Shade shade) {
        this.decoratedShape = decoratedShape;
        this.shade = shade;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Shade: " + shade);
    }
}
