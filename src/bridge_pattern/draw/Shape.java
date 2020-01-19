package bridge_pattern.draw;

public abstract class Shape {
    protected PaintAPI paintAPI;

    public Shape(PaintAPI paintAPI) {
        this.paintAPI = paintAPI;
    }

    public abstract void paint();
}
