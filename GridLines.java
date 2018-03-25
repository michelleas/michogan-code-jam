import comp124graphics.GraphicsGroup;

public class GridLines extends GraphicsGroup {

    public static final double LINE_WIDTH = TicTacToe.CANVAS_WIDTH / 15.0;
    public static final double LINE_LENGTH = 13 * LINE_WIDTH;

    public GridLines(double x, double y) {
        super(x, y);
    }
}
