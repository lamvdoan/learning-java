package bridge_pattern.draw;

public class Square extends Shape {
    private int length;

    public Square(PaintAPI paintAPI, int length) {
        super(paintAPI);
        this.length = length;
    }

    @Override
    public void paint() {
        paintAPI.paintSquare(length);
    }
}
