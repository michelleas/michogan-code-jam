import comp124graphics.GraphicsGroup;
import comp124graphics.Rectangle;

public class GridLines extends GraphicsGroup {

	public static final double LINE_WIDTH = TicTacToe.MARGIN;
	public static final double LINE_HEIGHT = 13 * LINE_WIDTH;

	public GridLines() {
		super(0, 0);

		double spacing = Square.SIDE_LENGTH + TicTacToe.MARGIN;

		add(makeGridline(spacing, TicTacToe.MARGIN));
		add(makeGridline(2 * spacing, TicTacToe.MARGIN));
		add(makeGridline(TicTacToe.MARGIN, spacing));
		add(makeGridline(TicTacToe.MARGIN, 2 * spacing));
	}

	private Rectangle makeGridline(double x, double y) {
		Rectangle line;

		if (x > y)
			line = new Rectangle(x, y, LINE_WIDTH, LINE_HEIGHT);
		else
			line = new Rectangle(x, y, LINE_HEIGHT, LINE_WIDTH);

		line.setFilled(true);
		line.setFillColor(java.awt.Color.black);

		return line;
	}
}
