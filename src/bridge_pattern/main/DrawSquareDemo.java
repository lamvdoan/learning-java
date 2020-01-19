package bridge_pattern.main;

import bridge_pattern.draw.PaintGreen;
import bridge_pattern.draw.Shape;
import bridge_pattern.draw.Square;

public class DrawSquareDemo {
    public static void main(String[] args) {
        Shape greenSquare = new Square(new PaintGreen(), 5);
        greenSquare.paint();
    }
}
