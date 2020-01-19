package bridge_pattern.draw;

public class PaintGreen implements PaintAPI {
    @Override
    public void paintSquare(int length) {
        System.out.println("Painting a green square " + length + " squared inches.");
    }
}
