package decorator_pattern.shape_design.design;

import decorator_pattern.shape_design.design_attribute.Color;
import decorator_pattern.shape_design.shape.Shape;

public class ColorDecorator extends ShapeDecorator {
    Color color;

    public ColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Color: " + color);
    }
}
